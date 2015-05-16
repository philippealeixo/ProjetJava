import Controleur.Controleur;
import Vue.Vue;

import javax.swing.*;
import java.awt.*;


public class Main {

    public static void main(String[] args) {


        modele.GestionnaireFilms g = new modele.GestionnaireFilms("txt/oeuvres.txt");
        /*
		b.ajouter(new Roman("Terry Pratchett", "L'Atalante", "La Huitieme Couleur", 5, Roman.FANTASY));
		b.ajouter(new Roman("Terry Pratchett", "L'Atalante", "Mortimer", 1, Roman.FANTASY));
		b.ajouter(new Roman("Terry Pratchett", "L'Atalante", "Au guet !", 8, Roman.FANTASY));
		b.ajouter(new Roman("Douglas Adams", "Folio SF", "Le Guide du voyageur galactique", 4, Roman.SF));
		b.ajouter(new Roman("Douglas Adams", "Folio SF", "Le Dernier Restaurant avant la fin du monde", 3, Roman.SF));
		b.ajouter(new BandeDessinee("Neil Gaiman", "Delcourt", "Sandman : Préludes et Nocturnes", 3, "Sam Kieth"));
		*/
/*
		g.litFichier("src/txt/oeuvres.txt");
		g.parcourtbase("src/txt/oeuvres.txt");

		g.trier();
*/
        JFrame fenetre = new JFrame("Gestionnaire Films");
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setResizable(false);
        fenetre.getContentPane().setLayout(new FlowLayout());


        fenetre.setAlwaysOnTop(true);
        fenetre.setSize(800, 400);

        Vue v = new Vue(g);
        Controleur c = new Controleur(g, v);
        v.setControler(c);
        fenetre.getContentPane().add(v);

        fenetre.setVisible(true);
    }
}

