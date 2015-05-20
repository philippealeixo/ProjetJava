package modele;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

/**
 * Created by Philippe on 13/05/2015.
 */
public class Films {

    private String titre;
    private String annee;
    private String realisateur;
    private int duree;
    private String synopsis;
    private File image;
    private int note;
    private boolean estNote;

    private int resultatSave;

    public Films(String titre, String annee, String realisateur, int duree, int note, File image, String synopsis) {
        this.titre = titre;
        this.annee = annee;
        this.realisateur = realisateur;
        this.duree = duree;
        this.image = image;
        this.synopsis = synopsis;
        this.note = note;
        this.estNote=true;
    }

    public Films(String titre, String annee, String realisateur, int duree, File image, String synopsis) {
        this.titre = titre;
        this.annee = annee;
        this.realisateur = realisateur;
        this.duree = duree;
        this.image = image;
        this.note = -1;
        this.synopsis = synopsis;
        this.estNote=false;
    }

    public String getTitre() {
        return titre;
    }

    public String getAnnee() {
        return annee;
    }

    public String getRealisateur() {
        return realisateur;
    }

    public int getduree() {
        return duree;
    }

    public int getNote() {
        return note;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public File getImage() { return image; }

    public boolean estNote() {
        return estNote;
    }

    public String toString() {
        return titre + "-" + realisateur + "-" + duree + "-" + synopsis;
    }

    public String filmToBase() {
        String s=new String();

        s=s+this.titre+"/-/";
        s=s+this.annee+"/-/";
        s=s+this.realisateur+"/-/";
        s=s+this.duree+"/-/";
        s=s+this.note+"/-/";
        s=s+this.image+"/-/";
        s=s+this.synopsis + System.getProperty("line.separator");

        return s;
    }

    public String filmNonNoteToBase() {
        String s=new String();

        s=s+this.titre+"/-/";
        s=s+this.annee+"/-/";
        s=s+this.realisateur+"/-/";
        s=s+this.duree+"/-/";
        s=s+"-1/-/";
        s=s+this.image+"/-/";
        s=s+this.synopsis + System.getProperty("line.separator");

        return s;
    }

    public String getInfosHTML() {
        String s = new String();

        s += "<html>Titre : " + this.titre + "<br/>";
        s += "<br/>Premiere Sortie : " + this.annee + "<br/>";
        s += "Realisateur : " + this.realisateur + "<br/>";
        s += "Duree : " + this.duree + " min<br/>";
        if (this.note!=-1) {
            s += "Note : " + this.note + "<br/>";
        }
        else{
            s += "Note : ND<br>";
        }

        s += "Resume : <br/>" + this.synopsis + "<br/></html>";

        return s;
    }

    public void setNote(int note){
        this.note = note;
        this.estNote = true;
    }


    /**
     * Ajout des differents COmparator car on veut pouvoir trier des Films selon plusieurs parametres
     */
    /**
     * Ajout du Caparateur par titre
     * @return Comparator
     */
    static Comparator<Films> compareByTitre() {
        return new Comparator<Films>() {
            @Override
            public int compare(Films f1, Films f2) {
                return f1.titre.compareToIgnoreCase(f2.titre);
            }
        };
    }

    /**
     * Ajout du Caparateur par annee
     * @return Comparator
     */
    static Comparator<Films> compareByYear() {
        return new Comparator<Films>() {
            @Override
            public int compare(Films f1, Films f2) {
                try {
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                String dateInString1 = f1.annee;
                String dateInString2 = f2.annee;

                    Date date1 = formatter.parse(dateInString1);
                    Date date2 = formatter.parse(dateInString2);
                    f1.resultatSave = date2.compareTo(date1);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                return f1.resultatSave;
            }
        };
    }
    /**
     * Ajout du Caparateur Note
     * @return Comparator
     */
    static Comparator<Films> compareByNote() { // tri par note decroissante
        return new Comparator<Films>() {
            @Override
            public int compare(Films f1, Films f2) {
                if (f1.note < f2.note)
                    return 1;
                else if (f1.note == f2.note)
                    return 0;
                else
                    return -11;
            }
        };
    }

}
