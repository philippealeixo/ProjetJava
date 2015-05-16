package Controleur;

import Vue.Vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import modele.GestionnaireFilms;



public class Controleur implements ListSelectionListener/*, ActionListener*/ {

    GestionnaireFilms g;
    Vue v;

    public Controleur(GestionnaireFilms g, Vue v) {
        super();
        this.g = g;
        this.v = v;
    }


	@Override
	public void valueChanged(ListSelectionEvent e) {
		v.maj();
		//v.majBouton();
	}


/*
    @Override
	public void valueChanged(ListSelectionEvent e) {
		v.maj();
		v.majBouton();
	}

	@Override
	public void actionPerformed(ActionEvent a) {

		final String cmd=a.getActionCommand();

		if(cmd.equals(Vue.AJOUTER)) {
			m.emprunter(v.getIndex());
			v.majBouton();
			v.maj();
		}
		else {
			m.retourner(v.getIndex());
			v.majBouton();
			v.maj();
		}	
	}
*/
}
