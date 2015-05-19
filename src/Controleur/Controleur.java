package Controleur;

import Vue.*;

import java.awt.event.*;

import javax.swing.JButton;
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
	}



	@Override
	public void actionPerformed(ActionEvent a) {
		if(a.getActionCommand().equals(Vue.AJOUTER)){
			this.vueAjout = new VueAjout(true);
			this.vueAjout.ajouterControleur(this);
		}
		else if (a.getActionCommand().equals("Valider")) {
			this.vueAjout.valider();
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
