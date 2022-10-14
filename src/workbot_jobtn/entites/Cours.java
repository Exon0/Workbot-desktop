/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author ADMIN
 */
public class Cours {
    private int id;
    private String titre,matiere,domaine,categorie,chemin;

    public Cours(int id) {
        this.id = id;
    }

    
    public Cours(String titre, String domaine, String categorie) {
        this.titre = titre;
        this.domaine = domaine;
        this.categorie = categorie;
    }
    

    public Cours(int id, String titre, String matiere, String domaine, String categorie, String chemin) {
        this.id = id;
        this.titre = titre;
        this.matiere = matiere;
        this.domaine = domaine;
        this.categorie = categorie;
        this.chemin = chemin;
    }

    public Cours(String titre, String matiere, String domaine, String categorie, String chemin) {
        this.titre = titre;
        this.matiere = matiere;
        this.domaine = domaine;
        this.categorie = categorie;
        this.chemin = chemin;
    }

    public Cours(String titre, String matiere, String domaine, String categorie) {
        this.titre = titre;
        this.matiere = matiere;
        this.domaine = domaine;
        this.categorie = categorie;
    }

    public Cours() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getMatiere() {
        return matiere;
    }

    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }

    public String getDomaine() {
        return domaine;
    }

    public void setDomaine(String domaine) {
        this.domaine = domaine;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getChemin() {
        return chemin;
    }

    public void setChemin(String chemin) {
        this.chemin = chemin;
    }

    @Override
    public String toString() {
        return "cours{" + "id=" + id + ", titre=" + titre + ", matiere=" + matiere + ", domaine=" + domaine + ", categorie=" + categorie + ", chemin=" + chemin + '}';
    }
    
    
}