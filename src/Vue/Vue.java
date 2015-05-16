package Vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Controleur.Controleur;
import modele.GestionnaireFilms;

@SuppressWarnings("serial")
public class Vue extends JPanel {

    public static final String AJOUTER = "ajouter";
    public static final String SUPPRIMER = "supprimer";

    JPanel gauche;
    JLabel titreG;
    JLabel information;
    GestionnaireFilms gestion;
    JButton ajouter;
    JButton supprimer;

    JPanel boutons;
    JPanel droite;
    JLabel titreD;
    @SuppressWarnings("rawtypes")
    DefaultListModel listeTitre;
    @SuppressWarnings("rawtypes")
    JList liste;

    @SuppressWarnings({"unchecked", "rawtypes"})
    public Vue(GestionnaireFilms gestion) {

        this.gestion = gestion;
        gauche = new JPanel();
        titreG = new JLabel("Liste Films :");
        listeTitre = new DefaultListModel();

        for (String f : gestion.getListe()) {
            listeTitre.addElement(f);
        }


        liste = new JList(listeTitre);
        ajouter = new JButton("Ajouter");
        supprimer = new JButton("Supprimer");
        ajouter.setActionCommand(AJOUTER);
        supprimer.setActionCommand(SUPPRIMER);

        information = new JLabel();
        information.setVerticalAlignment(SwingConstants.TOP);
        information.setBackground(Color.WHITE);
        information.setOpaque(true);

        boutons = new JPanel();
        boutons.add(ajouter);
        boutons.add(supprimer);
        gauche.setLayout(new BorderLayout());
        gauche.add(titreG, BorderLayout.PAGE_START);
        gauche.add(liste, BorderLayout.CENTER);
        gauche.add(boutons, BorderLayout.PAGE_END);


        droite = new JPanel();
        titreD = new JLabel("Informations :");
        droite.setLayout(new BorderLayout());
        droite.add(titreD, BorderLayout.PAGE_START);
        droite.add(information, BorderLayout.CENTER);

        this.setPreferredSize(new Dimension(750, 370));
        this.setLayout(new GridLayout(1, 2, 20, 0));
        this.add(gauche);
        this.add(droite);


        ajouter.setEnabled(false);
        supprimer.setEnabled(false);
    }




    public void setControler(Controleur c) {
        liste.addListSelectionListener(c);
      // ajouter.addActionListener(c);
       // supprimer.addActionListener(c);

    }

public void maj() {
	//information.setText(gestion.getInfosHTML());

        information.setText(gestion.getInfosHTML(liste.getSelectedIndex()));

}


    public int getIndex() {
        return liste.getSelectedIndex();
    }
}
