package Controleur;

import Vue.*;

import java.awt.event.*;
import java.io.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import modele.GestionnaireFilms;



public class Controleur implements ListSelectionListener, ActionListener, FocusListener, ItemListener {

    GestionnaireFilms g;
    Vue v;
	VueAjout vueAjout;

    public Controleur(GestionnaireFilms g, Vue v) {
        super();
        this.g = g;
        this.v = v;
    }


	@Override
	public void valueChanged(ListSelectionEvent e) {
		v.maj();
		v.majButton();
	}



	@Override
	public void actionPerformed(ActionEvent a) {
		if(a.getActionCommand().equals(Vue.AJOUTER)){
			this.vueAjout = new VueAjout(true);
			this.vueAjout.ajouterControleur(this);
		}
		if (a.getActionCommand().equals(VueAjout.VALIDATION)) {
			if (vueAjout.formulaireOK()) {
				String [] data = vueAjout.getInfosDialogAjoutFilm(); // data de la JDialog
				g.ajouterFilm(data[0], data[1], data[2], data[3], data[4], data[5]);
				vueAjout.dispose();
				v.majJList();
			}
		}
		if(a.getActionCommand().equals(Vue.ALL)){
			v.selectAll();
			System.out.println("trrtt");
		}
		if(a.getActionCommand().equals(Vue.PASNOTE)){
			v.selectPasNote();
		}
		if (a.getActionCommand().equals(Vue.NOTE)){
			v.selectNote();
		}
		if (a.getActionCommand().equals(Vue.NOTER)){
			Object[] notes = {0,1,2,3,4,5};
			int result = (int) JOptionPane.showInputDialog(null, "Veuillez noter le Films\n", "NOTER Films", JOptionPane.PLAIN_MESSAGE, new ImageIcon(), notes, 3);
			g.setNote(v.getIndex(), result);
			g.ajoutDansBase("txt/oeuvres.txt");
			v.majJList();
		}
		if (a.getActionCommand().equals("tri")) { // dans le cas ou on utilise la JComboBox de tri
			if (v.getValueSelectedTri().equals("Trier par Nom")) {
				g.sortByName();
			}
			else if (v.getValueSelectedTri().equals("Trier par Annee")) {
				g.sortByYear();
			}
			else if (v.getValueSelectedTri().equals("Trier par Note")) { // option disponible seulement dans l'onglet des films notes
				g.sortByNote();
			}
			v.majJListTri(); // mettre a jour la liste de l'onglet courant
		}

	}

	@Override
	public void focusGained(FocusEvent e) {

	}

	@Override
	public void focusLost(FocusEvent e) {
		if (e.getComponent().getName().equals("Titre")) {
			vueAjout.validerTitre(!vueAjout.getZoneTitre().isEmpty());
		}
		if (e.getComponent().getName().equals("Annee")) {
			vueAjout.validerAnnee(!(vueAjout.getZoneAnnee().isEmpty()));
		}
		if (e.getComponent().getName().equals("Realisateur")) {
			vueAjout.validerRealisateur(!vueAjout.getZoneRealisateur().isEmpty());
		}
		if (e.getComponent().getName().equals("Duree")) {
			vueAjout.validerDuree(vueAjout.getZoneDuree().matches("[1-9][0-9]*"));
		}
		if (e.getComponent().getName().equals("Image")) {
			vueAjout.validerImage(!vueAjout.getZoneImage().isEmpty());
		}
		//this.majBoutonAjout();
	}

	@Override
	public void itemStateChanged(ItemEvent e) {

	}


}
