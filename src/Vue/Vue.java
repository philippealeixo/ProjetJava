package Vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.*;

import Controleur.Controleur;
import modele.GestionnaireFilms;

@SuppressWarnings("serial")
public class Vue extends JPanel {

    public static final String AJOUTER = "ajouter";
    public static final String SUPPRIMER = "supprimer";
    public static final String NOTER = "noter";


    String[] optionTrier = { "Trie par note", "Trie par annee", "Trie par titre"}; // définition des options de la liste déroulante
    JComboBox trier = new JComboBox(optionTrier); // Creation de la liste déroulante
    //trier.setSelectedIndex(0);



    JPanel gauche;
    JPanel boutons; // JPabel composé de Bouton
    JPanel droite;

    JLabel titreD;
    JLabel titreG;
    JLabel information;

    GestionnaireFilms gestion;
    JButton ajouter;
    JButton supprimer;
    JButton noter;
    JCheckBox pasVu;
    JCheckBox vu;



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
        noter = new JButton("Noter");
        ajouter.setActionCommand(AJOUTER);
        supprimer.setActionCommand(SUPPRIMER);
        noter.setActionCommand(NOTER);



        information = new JLabel();
        information.setVerticalAlignment(SwingConstants.TOP);
        information.setBackground(Color.WHITE);
        information.setOpaque(true);

        boutons = new JPanel();
        boutons.add(noter);
        boutons.add(ajouter);
        boutons.add(supprimer);
        boutons.add(trier);
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


        ajouter.setEnabled(true);
        supprimer.setEnabled(false);
        ajouter.setActionCommand("ajouter");
        noter.setEnabled(false);
    }




    public void setControler(Controleur c) {
        liste.addListSelectionListener(c);
        ajouter.addActionListener(c);
        trier.addActionListener(c);
       // supprimer.addActionListener(c);

    }

    public void maj() {
	//information.setText(gestion.getInfosHTML());

        information.setIcon(new ImageIcon(gestion.getImage(liste.getSelectedIndex())));
        information.setText(gestion.getInfosHTML(liste.getSelectedIndex()));
}

    public void majButton(){
        noter.setEnabled((liste.getSelectedIndex()!=0));
        supprimer.setEnabled((liste.getSelectedIndex()!=0));

    }



    public int getIndex() {

        return liste.getSelectedIndex();
    }
}
