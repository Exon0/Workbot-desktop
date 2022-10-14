/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package workbot_jobtn;

/**
 *
 * @author hp
 */
public class H_sponsor {
private int id;
private String nom;
private String logo;
private int id_evenement;

    public H_sponsor() {
    }

    public H_sponsor(String nom, String logo, int id_evenement) {
        this.nom = nom;
        this.logo = logo;
        this.id_evenement = id_evenement;
    }

    public H_sponsor(int id, String nom, String logo, int id_evenement) {
        this.id = id;
        this.nom = nom;
        this.logo = logo;
        this.id_evenement = id_evenement;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public int getId_evenement() {
        return id_evenement;
    }

    public void setId_evenement(int id_evenement) {
        this.id_evenement = id_evenement;
    }
}

