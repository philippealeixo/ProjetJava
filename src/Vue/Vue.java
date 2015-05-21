package Vue;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;

import javax.swing.*;

import Controleur.Controleur;
import modele.Films;
import modele.GestionnaireFilms;

@SuppressWarnings("serial")
public class Vue extends JPanel {

    public static final String AJOUTER = "ajouter";
    public static final String SUPPRIMER = "supprimer";
    public static final String NOTER = "noter";
    public static final String ALL = "all";
    public static final String NOTE = "note";
    public static final String PASNOTE = "non noter";


    String[] optionTrier = { "Trie par note", "Trie par annee", "Trie par titre"}; // d�finition des options de la liste d�roulante
    JComboBox trier = new JComboBox(optionTrier); // Creation de la liste deroulante
    //trier.setSelectedIndex(0);


    JPanel global; // Panneau general
    JPanel menu; //Panneau menu
    JPanel gauche;// Panneau de gauche
    JPanel boutons; // JPabel compos� de Bouton
    JPanel droite;// Panneau de droite

    JLabel titreD;
    JLabel titreG;
    JLabel information;

    GestionnaireFilms gestion;
    JButton ajouter;
    JButton supprimer;
    JButton noter;
    JCheckBox pasNote;
    JCheckBox note;
    JCheckBox all;



    @SuppressWarnings("rawtypes")
    DefaultListModel listeTitre;
    @SuppressWarnings("rawtypes")
    JList liste;

    @SuppressWarnings({"unchecked", "rawtypes"})
    public Vue(GestionnaireFilms gestion) {

        this.gestion = gestion;

        global = new JPanel();
        global.setLayout(new BorderLayout());

        // GESTION DES CHECKBOXS
        all = new JCheckBox("tous");
        note = new JCheckBox("note");
        pasNote = new JCheckBox("pas note");
        all.setSelected(true);
        all.setActionCommand(ALL);
        pasNote.setActionCommand(PASNOTE);
        note.setActionCommand(NOTE);


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

        // Panneau du menu
        menu = new JPanel();
        menu.setLayout(new FlowLayout());
        menu.add(all);
        menu.add(note);
        menu.add(pasNote);

        boutons = new JPanel();
        boutons.add(noter);
        boutons.add(ajouter);
        boutons.add(supprimer);
        boutons.add(trier);
        gauche.setLayout(new BorderLayout());
        gauche.add(titreG, BorderLayout.PAGE_START);
        gauche.add(liste, BorderLayout.CENTER);
        gauche.add(boutons, BorderLayout.PAGE_END);
        gauche.setBorder(BorderFactory.createMatteBorder(0,0,0,10,new Color(0,0,0,0)));


        droite = new JPanel();
        titreD = new JLabel("Informations :");
        droite.setLayout(new BorderLayout());
        droite.add(titreD, BorderLayout.PAGE_START);
        droite.add(information, BorderLayout.CENTER);

        global.add(menu, BorderLayout.PAGE_START);
        global.add(gauche, BorderLayout.LINE_START);
        global.add(droite, BorderLayout.CENTER);

        this.setPreferredSize(new Dimension(750, 370));
        this.setLayout(new GridLayout(1, 2, 20, 0));
        this.add(global);


        ajouter.setEnabled(true);
        supprimer.setEnabled(false);
        ajouter.setActionCommand("ajouter");
        noter.setEnabled(false);

        trier.setActionCommand("tri");
    }


    public void setControler(Controleur c) {
        liste.addListSelectionListener(c);
        ajouter.addActionListener(c);
        trier.addActionListener(c);
        noter.addActionListener(c);
       // supprimer.addActionListener(c);

        all.addActionListener(c);
        note.addActionListener(c);
        pasNote.addActionListener(c);



    }

    public void maj() {
        if (liste.getAnchorSelectionIndex() <= liste.getLastVisibleIndex())
            liste.setSelectedIndex(liste.getAnchorSelectionIndex());
        else
            liste.setSelectedIndex(liste.getLastVisibleIndex());
        information.setIcon(new ImageIcon(gestion.getImage(liste.getSelectedIndex())));
        information.setText(gestion.getInfosHTML(liste.getSelectedIndex()));
}

    public void majJList () {
        ArrayList<Films> listeFilms = gestion.getFilm();
        String[] tab = new String[listeFilms.size()];
        for (int i=0; i<listeFilms.size(); i++) {
            tab[i] = listeFilms.get(i).getTitre();
        }
        liste.setListData(tab);
        if (liste.getAnchorSelectionIndex() <= liste.getLastVisibleIndex())
            liste.setSelectedIndex(liste.getAnchorSelectionIndex());
        else
            liste.setSelectedIndex(liste.getLastVisibleIndex());
    }

    public void majButton(){
        if (note.isSelected() || pasNote.isSelected()){
            noter.setEnabled(false);
        }
        else
            noter.setEnabled(true);
        supprimer.setEnabled(true);

    }

    public void selectAll(){
        if (all.isSelected()){
            pasNote.setSelected(false);
            note.setSelected(false);
            all.setSelected(true);
            gestion.listAll();
        }
    }

    public void selectNote(){
        pasNote.setSelected(false);
        all.setSelected(false);
        note.setSelected(true);
        gestion.listNote();
    }

    public void selectPasNote(){
        all.setSelected(false);
        note.setSelected(false);
        pasNote.setSelected(true);
        gestion.listNonNote();
    }

    public int getIndex() {
        return liste.getSelectedIndex();
    }

    public String getValueSelectedTri() {
        return (String) trier.getSelectedItem();
    }
}
