package Vue;

import Controleur.Controleur;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class VueAjout extends JDialog{

    public static final String VALIDATION = "Validation";

    private JLabel infoTitre, infoRealisateur, infoDuree, infoAnnee, infoSynopsis, infoImage, infoNote;
    private JTextField zoneTitre, zoneRealisateur, zoneAnnee, zoneDuree, zoneImage,zoneSynopsis, zoneNote ;
    private JComboBox<String> choixJour;
    private JComboBox<String> choixMois;
    private JComboBox<String> choixAnnee;
    private JComboBox<String> choixNote;
    private JButton valider;
    private boolean vTitre = false, vAnnee = false, vRealisateur = false, vDuree = false, vImage = false, vSynopsis = false, vNote = false;



    private final String erreur = "Tous les champs doivent etre completes.";


    public VueAjout(boolean b) {

        this.setSize(new Dimension(500, 400));
        this.setLayout(new GridLayout(0, 1));
        Dimension textFieldDimension = new Dimension(250, 30);
        Dimension comboBoxDimension = new Dimension(81, 30);
        Dimension labelDimension = new Dimension(150, 30);

                    /*Panel Titre*/
        JLabel pageTitre = new JLabel("Ajout d'un film");
        this.setResizable(false); //Bloque le redimensionnement de la fenetre
        pageTitre.setPreferredSize(labelDimension);
        pageTitre.setMaximumSize(labelDimension);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        pageTitre.setVerticalAlignment(SwingConstants.CENTER);
        pageTitre.setHorizontalAlignment(SwingConstants.CENTER);
        pageTitre.setFont(new Font(" TimesRoman ", Font.BOLD, 30));
        this.getContentPane().add(pageTitre);

        JPanel titre = new JPanel();

        JLabel labeltitre = new JLabel("Titre :");
        labeltitre.setPreferredSize(labelDimension);
        labeltitre.setMaximumSize(labelDimension);
        titre.add(labeltitre);

        zoneTitre = new JTextField();
        zoneTitre.setName("Titre");
        zoneTitre.setBackground(Color.WHITE);
        zoneTitre.setOpaque(true);
        zoneTitre.setPreferredSize(textFieldDimension);
        zoneTitre.setMaximumSize(textFieldDimension);
        titre.add(zoneTitre);

        infoTitre = new JLabel("");
        infoTitre.setPreferredSize(labelDimension);
        infoTitre.setForeground(Color.RED);
        titre.add(infoTitre);

        this.getContentPane().add(titre);

        /*Panel Realisateur*/
        JPanel realisateur = new JPanel();

        JLabel labelrealisateur = new JLabel("Realisateur :");
        labelrealisateur.setPreferredSize(labelDimension);
        labelrealisateur.setMaximumSize(labelDimension);
        realisateur.add(labelrealisateur);

        zoneRealisateur = new JTextField();
        zoneRealisateur.setName("Realisateur");
        zoneRealisateur.setBackground(Color.WHITE);
        zoneRealisateur.setOpaque(true);
        zoneRealisateur.setPreferredSize(textFieldDimension);
        zoneRealisateur.setMaximumSize(textFieldDimension);
        realisateur.add(zoneRealisateur);


        infoRealisateur = new JLabel("");
        infoRealisateur.setPreferredSize(labelDimension);
        infoRealisateur.setForeground(Color.RED);
        realisateur.add(infoRealisateur);

        this.getContentPane().add(realisateur);

        /*Panel Annee*/

        JPanel annee = new JPanel();
        //annee.setPreferredSize(panelsDimension);
        //annee.setMaximumSize(panelsDimension);
        JLabel labelannee = new JLabel("Date de sortie :");
        labelannee.setHorizontalAlignment(SwingConstants.LEFT);
        labelannee.setPreferredSize(labelDimension);
        labelannee.setMaximumSize(labelDimension);
        annee.add(labelannee);


        /*ANNEE*/
        choixAnnee = new JComboBox<String>();
        choixAnnee.addItem("Annee");
        int cpt = 0;
        for (int i=1870; i<2041; i++) {
            choixAnnee.addItem(""+i);
            cpt++;
        }
        choixAnnee.setPreferredSize(comboBoxDimension);
        choixAnnee.setMaximumSize(comboBoxDimension);
        choixAnnee.setActionCommand("dateFilm");

        /*MOIS*/
        choixMois = new JComboBox<String>();
        choixMois.addItem("Mois");
        cpt = 0;
        for (int i=1; i<13; i++) {
            choixMois.addItem(""+i);
            cpt++;
        }
        choixMois.setPreferredSize(comboBoxDimension);
        choixMois.setMaximumSize(comboBoxDimension);
        choixMois.setActionCommand("dateFilm");

        /*JOUR*/
        choixJour = new JComboBox<String>();
        choixJour.addItem("Jour");
        cpt = 0;
        for (int i=1; i<32; i++) {
            choixJour.addItem(""+i);
            cpt++;
        }
        choixJour.setPreferredSize(comboBoxDimension);
        choixJour.setMaximumSize(comboBoxDimension);
        choixJour.setActionCommand("dateFilm");

        annee.add(labelannee);
        annee.add(choixJour);
        annee.add(choixMois);
        annee.add(choixAnnee);
        this.getContentPane().add(annee);

        /*Panel Duree*/
        JPanel duree = new JPanel();

        JLabel labelduree = new JLabel("Duree :");
        labelduree.setPreferredSize(labelDimension);
        labelduree.setMaximumSize(labelDimension);
        duree.add(labelduree);

        zoneDuree = new JTextField();
        zoneDuree.setName("Synopsis");
        zoneDuree.setBackground(Color.WHITE);
        zoneDuree.setOpaque(true);
        zoneDuree.setPreferredSize(textFieldDimension);
        zoneDuree.setMaximumSize(textFieldDimension);
        duree.add(zoneDuree);

        infoDuree = new JLabel("");
        infoDuree.setPreferredSize(labelDimension);
        infoDuree.setForeground(Color.RED);
        duree.add(infoDuree);

        this.getContentPane().add(duree);

        /*Panel Sypnosis*/
        JPanel synopsis = new JPanel();

        JLabel labelsynopsis = new JLabel("Synopsis :");
        labelsynopsis.setPreferredSize(labelDimension);
        labelsynopsis.setMaximumSize(labelDimension);
        synopsis.add(labelsynopsis);

        zoneSynopsis = new JTextField();
        zoneSynopsis.setName("Synopsis");
        zoneSynopsis.setBackground(Color.WHITE);
        zoneSynopsis.setOpaque(true);
        zoneSynopsis.setPreferredSize(textFieldDimension);
        zoneSynopsis.setMaximumSize(textFieldDimension);
        synopsis.add(zoneSynopsis);

        infoSynopsis = new JLabel("");
        infoSynopsis.setPreferredSize(labelDimension);
        infoSynopsis.setForeground(Color.RED);
        synopsis.add(infoSynopsis);

        this.getContentPane().add(synopsis);

        /*Panel Image*/
        JPanel image = new JPanel();

        JLabel labelimage = new JLabel("Image");
        labelimage.setPreferredSize(labelDimension);
        labelimage.setMaximumSize(labelDimension);
        image.add(labelimage);

        zoneImage = new JTextField();
        zoneImage.setName("Image");
        zoneImage.setBackground(Color.WHITE);
        zoneImage.setOpaque(true);
        zoneImage.setPreferredSize(textFieldDimension);
        zoneImage.setMaximumSize(textFieldDimension);
        image.add(zoneImage);

        infoImage = new JLabel("");
        infoImage.setPreferredSize(labelDimension);
        infoImage.setForeground(Color.RED);
        image.add(infoImage);

        this.getContentPane().add(image);


        /*Panel Valider*/
        JPanel validation = new JPanel();

        valider = new JButton("Validation");
        //this.valider();
        valider.setActionCommand(VALIDATION);
        validation.add(valider);

        this.getContentPane().add(validation);

        this.setVisible(true);
        this.setVisible(b);
    }

    public void majValider(boolean b) {
        valider.setEnabled(b);
    }

    public void ajouterControleur(Controleur controleur) {
        this.valider.addActionListener(controleur);
        this.zoneTitre.addFocusListener(controleur);
        this.zoneRealisateur.addFocusListener(controleur);
        this.zoneSynopsis.addFocusListener(controleur);
        this.zoneImage.addFocusListener(controleur);
    }

    public boolean formulaireOK () {
        boolean vTitre = (zoneTitre.getText().equals("") || zoneTitre.getText() == null);
        boolean vRealisateur= (zoneRealisateur.getText().equals("") || zoneRealisateur.getText() == null);
        boolean vSynopsis = (zoneSynopsis.getText().equals("") || zoneSynopsis.getText() == null);
        boolean vAnnee = (choixJour.getSelectedIndex() == 0 || choixMois.getSelectedIndex() == 0 || choixAnnee.getSelectedIndex() == 0);
        boolean vDuree = (zoneDuree.getText().equals("") || zoneDuree.getText() == null);
        boolean vImage = zoneImage.getText() == null;

        return (!vTitre && !vRealisateur && !vSynopsis && !vAnnee && !vDuree && !vImage);
    }

    public String [] getInfosDialogAjoutFilm () {
        String [] s;
        if (formulaireOK()) {
            s = new String[6];
            s[0] = zoneTitre.getText();
            s[1] = zoneRealisateur.getText();
            s[2] = choixJour.getSelectedItem() + "/" + choixMois.getSelectedItem() + "/" + choixAnnee.getSelectedItem();
            s[3] = zoneDuree.getText();
            s[4] = zoneSynopsis.getText().replaceAll("\n|\t", "");
            s[5] = zoneImage.getText();
            return s;
        }
        else
            return null;
    }


    public void validerRealisateur(boolean b){
        if (b){
            this.vRealisateur = true;
            this.infoRealisateur.setText("");
        }
        else {
            this.infoRealisateur.setText(erreur);
            this.vRealisateur = false;
        }
    }

    public void  validerTitre(boolean b){
        if (b){
            this.vTitre=true;
            this.infoTitre.setText("");
        }
        else {
            this.vTitre=false;
            this.infoTitre.setText(erreur);
        }
    }

    public void  validerAnnee(boolean b){
        if (b){
            this.vAnnee=true;
            this.infoAnnee.setText("");
        }
        else {
            this.vAnnee=false;
            this.infoAnnee.setText(erreur);
        }
    }

    public void  vaiderSynopsis(boolean b){
        if (b){
            this.vSynopsis=true;
            this.infoSynopsis.setText("");
        }
        else {
            this.vSynopsis=false;
            this.infoSynopsis.setText("Un nombre positif est attendu.");
        }
    }

    public void validerImage(boolean b){
        if(b){
            this.vImage=true;
            this.infoImage.setText("");
        }
        else{
            this.vImage=false;
            this.infoImage.setText(erreur);
        }
    }

    public void validerDuree(boolean b){
        if(b){
            this.vDuree=true;
            this.infoDuree.setText("");
        }
        else {
            this.vDuree=false;
            this.infoDuree.setText(erreur);
        }
    }

    public void validerNote(boolean b){
        if(b){
            this.vNote=true;
            this.infoNote.setText("");
        }
        else {
            this.vNote=false;
            this.infoNote.setText(erreur);
        }
    }

    public String getZoneRealisateur() {
        return zoneRealisateur.getText();
    }

    public String getZoneTitre() {
        return zoneTitre.getText();
    }

    public String getZoneAnnee() {
        return zoneAnnee.getText();
    }

    public String getZoneDuree() {
        return zoneDuree.getText();
    }

    public String getZoneImage() {
        return zoneImage.getText();
    }

    public String getZoneSynopsis() {
        return zoneSynopsis.getText();
    }

    public String getZoneNote() {
        return zoneNote.getText();
    }
}