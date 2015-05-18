package modele;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by Philippe on 13/05/2015.
 */
public class GestionnaireFilms {

    private ArrayList<Films> film;

    public GestionnaireFilms(String cheminfichier) {
        film = new ArrayList<Films>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(cheminfichier));
            String ligne; //lecture ligne par ligne
            while ((ligne = reader.readLine()) != null) {
                //System.out.println(ligne);
                film.add(creerFilms(ligne));
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Fichier non trouvé");
        } catch (IOException e) {
            System.out.println("Lecture du fichier impossible");
        }

    }


    public Films creerFilms(String ligne) {

        String fichier[] = ligne.split("/-/");
        return new Films(fichier[0], fichier[1], fichier[2], Integer.parseInt(fichier[3]), Integer.parseInt(fichier[4]), new File(fichier[5]), fichier[6]);

    }

    public ArrayList<Films> getFilm() {
        return film;
    }


    public ArrayList<String> getListe() {
        ArrayList<String> titre = new ArrayList<String>();
        for (Films f : film)
            titre.add(f.getTitre());
        return titre;
    }

    public String getInfosHTML(int index) {
        return film.get(index).getInfosHTML();

    }

    public String getImage(int index){
        return  film.get(index).getImage().getPath();
    }

    public void ajoutDansBase(String filename) {
        try {
            PrintWriter sortie= new PrintWriter(new BufferedWriter(new java.io.FileWriter(filename)));
            for(int i=0;i<this.film.size();i++) {
                sortie.write(this.film.get(i).filmToBase());
            }
            sortie.close();
        }
        catch(FileNotFoundException e) {
            System.out.println("Fichier non trouvé");
        }
        catch(IOException io) {
            System.out.println("Ecriture du fichier impossible...");
        }
    }
/*
    //main de test uniquement
    public static void main(String[] args) {
        GestionnaireFilms g = new GestionnaireFilms("txt/oeuvres.txt");

        for (Films f : g.getFilm()) {
            System.out.println(f);
        }
    }


        @Override
        public int compareTo(Films arg0) {
            return titre.compareTo(arg0.titre);
        }
*/


}
