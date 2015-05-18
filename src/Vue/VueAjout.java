package Vue;

import Controleur.Controleur;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class VueAjout extends JDialog{

    private JPanel image;
    private JPanel genre;
    private JLabel infoTitre, infoRealisateur, infoDuree, infoAnnee, infoSynopsis, infoImage, infoNote;
    private JTextField zoneTitre, zoneRealisateur, zoneAnnee, zoneDuree, zoneImage,zoneSynopsis, zoneNote ;
    private JButton valider;
    private boolean vTitre = false, vAnnee = false, vRealisateur = false, vDuree = false, vImage = false, vSynopsis = false, vNote = false;
    private JComboBox<String> typeListe;
    private JComboBox<String> genreListe;


    private final String erreur = "Tous les champs doivent être complétés.";


    public VueAjout() {

        this.setSize(new Dimension(800, 400));
        this.setLayout(new GridLayout(0, 1));


        JLabel pageTitle = new JLabel("Ajout d'un film");
        pageTitle.setPreferredSize(new Dimension(600, 50));
        pageTitle.setVerticalAlignment(SwingConstants.CENTER);
        pageTitle.setHorizontalAlignment(SwingConstants.CENTER);
        pageTitle.setFont(new Font(" TimesRoman ", Font.BOLD, 30));
        this.getContentPane().add(pageTitle);

        JPanel titre = new JPanel();

        JLabel labelTitre = new JLabel("Titre :");
        labelTitre.setPreferredSize(new Dimension(150, 25));
        titre.add(labelTitre);

        zoneTitre = new JTextField();
        zoneTitre.setName("Titre");
        zoneTitre.setBackground(Color.WHITE);
        zoneTitre.setOpaque(true);
        zoneTitre.setBorder(new EmptyBorder(5, 5, 5, 0));
        zoneTitre.setPreferredSize(new Dimension(200, 25));
        titre.add(zoneTitre);

        infoTitre = new JLabel("");
        infoTitre.setPreferredSize(new Dimension(250, 25));
        infoTitre.setForeground(Color.RED);
        titre.add(infoTitre);

        this.getContentPane().add(titre);

        JPanel realisateur = new JPanel();

        JLabel labelRealisateur = new JLabel("Realisateur");
        labelRealisateur.setPreferredSize(new Dimension(150, 25));
        realisateur.add(labelRealisateur);

        zoneRealisateur = new JTextField();
        zoneRealisateur.setName("Realisateur");
        zoneRealisateur.setBackground(Color.WHITE);
        zoneRealisateur.setOpaque(true);
        zoneRealisateur.setBorder(new EmptyBorder(5, 5, 5, 0));
        zoneRealisateur.setPreferredSize(new Dimension(200, 25));
        realisateur.add(zoneRealisateur);


        infoRealisateur = new JLabel("");
        infoRealisateur.setPreferredSize(new Dimension(250, 25));
        infoRealisateur.setForeground(Color.RED);
        realisateur.add(infoRealisateur);

        this.getContentPane().add(realisateur);

        JPanel annee = new JPanel();

        JLabel labelannee = new JLabel("annee");
        labelannee.setPreferredSize(new Dimension(150, 25));
        annee.add(labelannee);

        zoneAnnee = new JTextField();
        zoneAnnee.setName("annee");
        zoneAnnee.setBackground(Color.WHITE);
        zoneAnnee.setOpaque(true);
        zoneAnnee.setBorder(new EmptyBorder(5, 5, 5, 0));
        zoneAnnee.setPreferredSize(new Dimension(200, 25));
        annee.add(zoneAnnee);

        infoAnnee = new JLabel("");
        infoAnnee.setPreferredSize(new Dimension(250, 25));
        infoAnnee.setForeground(Color.RED);
        annee.add(infoAnnee);

        this.getContentPane().add(annee);

        JPanel synopsis = new JPanel();

        JLabel labelsynopsis = new JLabel("Resume");
        labelsynopsis.setPreferredSize(new Dimension(150, 25));
        synopsis.add(labelsynopsis);

        zoneSynopsis = new JTextField();
        zoneSynopsis.setName("Resume");
        zoneSynopsis.setBackground(Color.WHITE);
        zoneSynopsis.setOpaque(true);
        zoneSynopsis.setBorder(new EmptyBorder(5, 5, 5, 0));
        zoneSynopsis.setPreferredSize(new Dimension(200, 25));
        synopsis.add(zoneSynopsis);

        infoSynopsis = new JLabel("");
        infoSynopsis.setPreferredSize(new Dimension(250, 25));
        infoSynopsis.setForeground(Color.RED);
        synopsis.add(infoSynopsis);

        this.getContentPane().add(synopsis);

        image = new JPanel();

        JLabel labelImage = new JLabel("Image");
        labelImage.setPreferredSize(new Dimension(150, 25));
        image.add(labelImage);

        zoneImage = new JTextField();
        zoneImage.setName("Image");
        zoneImage.setBackground(Color.WHITE);
        zoneImage.setOpaque(true);
        zoneImage.setBorder(new EmptyBorder(5, 5, 5, 0));
        zoneImage.setPreferredSize(new Dimension(200, 25));
        image.add(zoneImage);

        infoImage = new JLabel("");
        infoImage.setPreferredSize(new Dimension(250, 25));
        infoImage.setForeground(Color.RED);
        image.add(infoImage);

        this.add(image);
        image.setVisible(false);



        JPanel validation = new JPanel();

        valider = new JButton("Valider");
        valider.setEnabled(false);
        validation.add(valider);

        this.getContentPane().add(validation);

        this.setVisible(true);
    }

    public void majValider(boolean b) {
        valider.setEnabled(b);
    }

    public void ajouterControleur(Controleur controleur) {
        this.valider.addActionListener(controleur);
        this.zoneTitre.addFocusListener(controleur);
        this.zoneRealisateur.addFocusListener(controleur);
        this.zoneAnnee.addFocusListener(controleur);
        this.zoneSynopsis.addFocusListener(controleur);
        this.zoneImage.addFocusListener(controleur);
        this.typeListe.addItemListener(controleur);
        this.genreListe.addItemListener(controleur);
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