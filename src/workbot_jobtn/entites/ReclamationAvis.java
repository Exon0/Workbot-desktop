/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package workbot_jobtn.entites;


import java.sql.Date;
import java.util.Objects;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author youcef
 */
public class ReclamationAvis {
    private int id;
    private String objet;
    private String date;      
    private String description;
    private String image;
    private String note;
    private Categorie categorie;      
    private User user;
    private User societe;
    private Offre offre;
    private Evennement evennement;

    private ImageView img;

    public ReclamationAvis(String description, String note) {
        this.description = description;
        this.note = note;
    }

    
    public ReclamationAvis(int id, String objet, String date, String description, Categorie categorie, String image) {
        this.id = id;
        this.objet = objet;
        this.date = date;
        this.description = description;
        this.categorie = categorie;
        this.image = image;
        
    }
    public ImageView getImg() {
        return img;
    }

    public void setImg(ImageView img) {
        this.img = img;
    }


    public ReclamationAvis() {
    }

    public ReclamationAvis(int id, String objet, String date, String description, String image, String note, Categorie categorie, User user, Societe societe, Offre offre, Evennement evennement) {


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
    public ReclamationAvis( String objet, String date, String description, String image, String note, Categorie categorie, User user, Societe societe, Offre offre, Evennement evennement) {

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

    public ReclamationAvis(int id, String objet, String date, String description,Categorie categorie) {
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
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

    public User getSociete() {
        return societe;
    }

    public void setSociete(User societe) {
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
        int hash = 7;
        hash = 61 * hash + this.id;
        hash = 61 * hash + Objects.hashCode(this.objet);
        hash = 61 * hash + Objects.hashCode(this.date);
        hash = 61 * hash + Objects.hashCode(this.description);
        hash = 61 * hash + Objects.hashCode(this.image);
        hash = 61 * hash + Objects.hashCode(this.note);
        hash = 61 * hash + Objects.hashCode(this.categorie);
        hash = 61 * hash + Objects.hashCode(this.user);
        hash = 61 * hash + Objects.hashCode(this.societe);
        hash = 61 * hash + Objects.hashCode(this.offre);
        hash = 61 * hash + Objects.hashCode(this.evennement);
        hash = 61 * hash + Objects.hashCode(this.img);
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
        if (!Objects.equals(this.objet, other.objet)) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.image, other.image)) {
            return false;
        }
        if (!Objects.equals(this.note, other.note)) {
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
        if (!Objects.equals(this.evennement, other.evennement)) {
            return false;
        }
        if (!Objects.equals(this.img, other.img)) {
            return false;
        }
        return true;
    }

    
}