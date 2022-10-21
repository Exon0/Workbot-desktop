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
    private int id;
    private String objet;
    private Date date;      
    private String description;
    private String image;
    private int note;
    private Categorie categorie;      
    private User user;
    private Societe societe;
    private Offre offre;
    private Evenement evennement;

    public ReclamationAvis() {
    }

    public ReclamationAvis(int id, String objet, Date date, String description, String image, int note, Categorie categorie, User user, Societe societe, Offre offre, Evenement evennement) {
        this.id = id;
        this.objet = objet;
        this.date = date;
        this.description = description;
        this.image = image;
        this.note = note;
        this.categorie = categorie;
        this.user = user;
        this.societe = societe;
        this.offre = offre;
        this.evennement = evennement;
    }

    public ReclamationAvis(String objet, Date date, String description, String image, int note, Categorie categorie, User user, Societe societe, Offre offre, Evenement evennement) {
        this.objet = objet;
        this.date = date;
        this.description = description;
        this.image = image;
        this.note = note;
        this.categorie = categorie;
        this.user = user;
        this.societe = societe;
        this.offre = offre;
        this.evennement = evennement;
    }

    public ReclamationAvis(int id, String objet, Date date, String description,Categorie categorie) {
        this.id = id;
        this.objet = objet;
        this.date = date;
        this.description = description;
        this.categorie = categorie;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Societe getSociete() {
        return societe;
    }

    public void setSociete(Societe societe) {
        this.societe = societe;
    }

    public Offre getOffre() {
        return offre;
    }

    public void setOffre(Offre offre) {
        this.offre = offre;
    }

    public Evenement getEvennement() {
        return evennement;
    }

    public void setEvennement(Evenement evennement) {
        this.evennement = evennement;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + this.id;
        hash = 47 * hash + Objects.hashCode(this.objet);
        hash = 47 * hash + Objects.hashCode(this.date);
        hash = 47 * hash + Objects.hashCode(this.description);
        hash = 47 * hash + Objects.hashCode(this.image);
        hash = 47 * hash + this.note;
        hash = 47 * hash + Objects.hashCode(this.categorie);
        hash = 47 * hash + Objects.hashCode(this.user);
        hash = 47 * hash + Objects.hashCode(this.societe);
        hash = 47 * hash + Objects.hashCode(this.offre);
        hash = 47 * hash + Objects.hashCode(this.evennement);
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
        if (this.id != other.id) {
            return false;
        }
        if (this.note != other.note) {
            return false;
        }
        if (!Objects.equals(this.objet, other.objet)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.image, other.image)) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        if (!Objects.equals(this.categorie, other.categorie)) {
            return false;
        }
        if (!Objects.equals(this.user, other.user)) {
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
        return "ReclamationAvis{" + "id=" + id + ", objet=" + objet + ", date=" + date + ", description=" + description + ", image=" + image + ", note=" + note + ", categorie=" + categorie + ", user=" + user + ", societe=" + societe + ", offre=" + offre + ", evennement=" + evennement + '}';
    }
    

}