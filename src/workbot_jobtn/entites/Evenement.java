/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package workbot_jobtn.entites;

/**
 *
 * @author hp
 */
public class Evenement {
private int id;
private int id_user;
private int nbPlaces;
private String dateDebut;
private String dateFin;
private String heureDebut;
private String heureFin;
private String libelle;
private String video;
private String prix;
private String flyer;

    
    public Evenement() {
    }

    public Evenement(int id_user, int nbPlaces, String dateDebut, String dateFin, String heureDebut, String heureFin, String libelle, String video, String prix, String flyer) {
        this.id_user = id_user;
        this.nbPlaces = nbPlaces;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.heureDebut = heureDebut;
        this.heureFin = heureFin;
        this.libelle = libelle;
        this.video = video;
        this.prix = prix;
        this.flyer = flyer;
    }

    public Evenement(int id, int id_user, int nbPlaces, String dateDebut, String dateFin, String heureDebut, String heureFin, String libelle, String video, String prix, String flyer) {
        this.id = id;
        this.id_user = id_user;
        this.nbPlaces = nbPlaces;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.heureDebut = heureDebut;
        this.heureFin = heureFin;
        this.libelle = libelle;
        this.video = video;
        this.prix = prix;
        this.flyer = flyer;
    }
public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getNbPlaces() {
        return nbPlaces;
    }

    public void setNbPlaces(int nbPlaces) {
        this.nbPlaces = nbPlaces;
    }

    public String getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    public String getDateFin() {
        return dateFin;
    }

    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }

    public String getHeureDebut() {
        return heureDebut;
    }

    public void setHeureDebut(String heureDebut) {
        this.heureDebut = heureDebut;
    }

    public String getHeureFin() {
        return heureFin;
    }

    public void setHeureFin(String heureFin) {
        this.heureFin = heureFin;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }

    public String getFlyer() {
        return flyer;
    }

    public void setFlyer(String flyer) {
        this.flyer = flyer;
    }

}
