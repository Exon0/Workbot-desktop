/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package workbot_jobtn.entites;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author youcef
 */
public class ReclamationAvis {
    private Integer id;
    private String objet;
    private Date date;      
    private String description;
    private String image;
    private Integer note;
    private Categorie categorie;      
    private Compte compte;
    private Compte societe;
    private Offre offre;
    private Evennement evennement;

    public ReclamationAvis() {
    }

    public ReclamationAvis(Integer id, String objet, Date date, String description, String image, Integer note, Categorie categorie, Compte compte, Compte societe, Offre offre, Evennement evennement) {
        this.id = id;
        this.objet = objet;
        this.date = date;
        this.description = description;
        this.image = image;
        this.note = note;
        this.categorie = categorie;
        this.compte = compte;
        this.societe = societe;
        this.offre = offre;
        this.evennement = evennement;
    }

    public ReclamationAvis(String objet, Date date, String description, String image, Integer note, Categorie categorie, Compte compte, Compte societe, Offre offre, Evennement evennement) {
        this.objet = objet;
        this.date = date;
        this.description = description;
        this.image = image;
        this.note = note;
        this.categorie = categorie;
        this.compte = compte;
        this.societe = societe;
        this.offre = offre;
        this.evennement = evennement;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getObjet() {
        return objet;
    }

    public void setObjet(String objet) {
        this.objet = objet;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getNote() {
        return note;
    }

    public void setNote(Integer note) {
        this.note = note;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }

    public Compte getSociete() {
        return societe;
    }

    public void setSociete(Compte societe) {
        this.societe = societe;
    }

    public Offre getOffre() {
        return offre;
    }

    public void setOffre(Offre offre) {
        this.offre = offre;
    }

    public Evennement getEvennement() {
        return evennement;
    }

    public void setEvennement(Evennement evennement) {
        this.evennement = evennement;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + Objects.hashCode(this.id);
        hash = 19 * hash + Objects.hashCode(this.objet);
        hash = 19 * hash + Objects.hashCode(this.date);
        hash = 19 * hash + Objects.hashCode(this.description);
        hash = 19 * hash + Objects.hashCode(this.image);
        hash = 19 * hash + Objects.hashCode(this.note);
        hash = 19 * hash + Objects.hashCode(this.categorie);
        hash = 19 * hash + Objects.hashCode(this.compte);
        hash = 19 * hash + Objects.hashCode(this.societe);
        hash = 19 * hash + Objects.hashCode(this.offre);
        hash = 19 * hash + Objects.hashCode(this.evennement);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ReclamationAvis other = (ReclamationAvis) obj;
        if (!Objects.equals(this.objet, other.objet)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.image, other.image)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        if (!Objects.equals(this.note, other.note)) {
            return false;
        }
        if (!Objects.equals(this.categorie, other.categorie)) {
            return false;
        }
        if (!Objects.equals(this.compte, other.compte)) {
            return false;
        }
        if (!Objects.equals(this.societe, other.societe)) {
            return false;
        }
        if (!Objects.equals(this.offre, other.offre)) {
            return false;
        }
        return Objects.equals(this.evennement, other.evennement);
    }

    @Override
    public String toString() {
        return "ReclamationAvis{" + "id=" + id + ", objet=" + objet + ", date=" + date + ", description=" + description + ", image=" + image + ", note=" + note + ", categorie=" + categorie + ", compte=" + compte + ", societe=" + societe + ", offre=" + offre + ", evennement=" + evennement + '}';
    }
    
    
    
}
