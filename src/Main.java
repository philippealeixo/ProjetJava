import Controleur.Controleur;
import Vue.Vue;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.ExecutionException;


public class Main {

    public static void main(String[] args) {


        modele.GestionnaireFilms g = new modele.GestionnaireFilms("txt/oeuvres.txt");
/* A appeller dans Ajouter Film
        try {
            g.ajoutDansBase(("txt/oeuvres.txt"));
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            e.getStackTrace();
        }
*/
        JFrame fenetre = new JFrame("Gestionnaire Films");
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setResizable(false);
        fenetre.getContentPane().setLayout(new FlowLayout());


        //fenetre.setAlwaysOnTop(true);
        fenetre.setSize(800, 400);

        Vue v = new Vue(g);
        Controleur c = new Controleur(g, v);
        v.setControler(c);
        fenetre.getContentPane().add(v);

        fenetre.setVisible(true);
    }
}

