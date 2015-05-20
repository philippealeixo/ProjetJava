package modele;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

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
                film.add(creerFilms(ligne));
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Fichier non trouve");
        } catch (IOException e) {
            System.out.println("Lecture du fichier impossible");
        }

    }


    public Films creerFilms(String ligne) {

        String[] fichier = ligne.split("/-/");
        if (fichier[4].equals("-1"))
            return new Films(fichier[0], fichier[1], fichier[2], Integer.parseInt(fichier[3]), new File(fichier[5]), fichier[6]);
        else
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

    public void ajouter(Films film){
        this.film.add(film);
    }

    public void ajouteFilm(ArrayList<Films> films){
        for (int i=0; i<films.size(); i++){
            this.ajouter(films.get(i));
        }
    }

    public void ajoutDansBase(String filename) {
        try {
            PrintWriter sortie= new PrintWriter(new BufferedWriter(new java.io.FileWriter(filename)));
            for(int i=0;i<this.film.size();i++) {
                if (film.get(i).estNote())
                    sortie.write(this.film.get(i).filmToBase());
                else
                    sortie.write(this.film.get(i).filmNonNoteToBase());
            }
            sortie.close();
        }
        catch(FileNotFoundException e) {
            System.out.println("Fichier non trouve");
        }
        catch(IOException io) {
            System.out.println("Ecriture du fichier impossible...");
        }
    }

    public void ajouterFilm (String titre, String realisateur, String annee, String duree, String synopsis, String image) {
    try {
        Films unFilm = new Films(titre, annee, realisateur, Integer.parseInt(duree), new File(image), synopsis);
        FileWriter sortie = new FileWriter(new File("txt/oeuvres.txt"),true);
        sortie.write(unFilm.filmToBase());
        sortie.close();

        this.film.add(unFilm);
    }
    catch(IOException ioe) {
        System.err.println("IOException: " + ioe.getMessage());
    }
    }

    public void setNote(int index, int note){
        film.get(index).setNote(note);
    }

    /**
     * Fonction qui trie les listes de film par nom
     */
    public void sortByName() {
        Collections.sort(this.film, Films.compareByNom());
    }

    /**
     * Fonction qui trie les listes de film par annee
     */
    public void sortByYear() {
        Collections.sort(this.film, Films.compareByYear());
    }

    /**
     * Fonction qui trie les listes de film par note (disponible seulement pour un film note)
     */
    public void sortByNote() {
        Collections.sort(this.film, Films.compareByNote());
    }

    public void listAll(){
        film = new ArrayList<Films>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("txt/oeuvres.txt"));
            String ligne; //lecture ligne par ligne
            while ((ligne = reader.readLine()) != null) {
                film.add(creerFilms(ligne));
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Fichier non trouve");
        } catch (IOException e) {
            System.out.println("Lecture du fichier impossible");
        }
    }

    public void listNote(){
        film = new ArrayList<Films>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("txt/oeuvres.txt"));
            String ligne; //lecture ligne par ligne
            while ((ligne = reader.readLine()) != null) {
                String[] fichier = ligne.split("/-/");
                if (fichier[4].equals("-1")) {
                    //ne rien faire
                }
                else
                    film.add(new Films(fichier[0], fichier[1], fichier[2], Integer.parseInt(fichier[3]), Integer.parseInt(fichier[4]), new File(fichier[5]), fichier[6]));

            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Fichier non trouve");
        } catch (IOException e) {
            System.out.println("Lecture du fichier impossible");
        }
    }

    public void listNonNote(){
        film = new ArrayList<Films>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("txt/oeuvres.txt"));
            String ligne; //lecture ligne par ligne
            while ((ligne = reader.readLine()) != null) {
                String[] fichier = ligne.split("/-/");
                if (fichier[4].equals("-1")) {
                    film.add(new Films(fichier[0], fichier[1], fichier[2], Integer.parseInt(fichier[3]), new File(fichier[5]), fichier[6]));
                }
                else{/*ne rien faire*/}
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Fichier non trouve");
        } catch (IOException e) {
            System.out.println("Lecture du fichier impossible");
        }
    }
}
