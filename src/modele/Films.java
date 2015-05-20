package modele;

import java.io.File;

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
}
