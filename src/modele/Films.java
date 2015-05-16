package modele;

import java.text.DateFormat;
import java.util.Date;

/**
 * Created by Philippe on 13/05/2015.
 */
public class Films {

    private String titre;
    private String annee;
    private String realisateur;
    private String genre;
    private String resume;
    private int note;


    public Films(String titre, String annee, String realisateur, String genre, int note, String resume) {
        this.titre = titre;
        this.annee = annee;
        this.realisateur = realisateur;
        this.genre = genre;
        this.resume = resume;
        this.note = note;
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

    public String getGenre() {
        return genre;
    }

    public int getNote() {
        return note;
    }

    public String getResume() {
        return resume;
    }

    public String toString() {
        return titre + "-" + realisateur + "-" + genre + "-" + resume;
    }


    public String getInfosHTML() {
        String s = new String();

            s += "<html>Titre : " + this.titre + "<br/>";
            s += "<br/>Premiere Sortie : " + this.annee + "<br/>";
            s += "Realisateur : " + this.realisateur + "<br/>";
            s += "Genre : " + this.genre + "<br/>";
            s += "Note : " + this.note +"<br/>";
            s += "Resume : <br/>" + this.resume + "<br/></html>";

        return s;
    }
}
