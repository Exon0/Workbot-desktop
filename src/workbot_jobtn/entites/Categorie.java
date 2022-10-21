/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package workbot_jobtn.entites;

import java.util.Objects;
import workbot_jobtn.entites.*;
import static workbot_jobtn.entites.NomCategorie.*;


/**
 *
 * @author youcef
 */
public class Categorie {

    private int id;
    
    private NomCategorie nomCategorie;

    public Categorie() {
    }

    
    public Categorie(int id, NomCategorie nomCategorie) {
        this.id = id;
        this.nomCategorie = nomCategorie;
    }

    public Categorie(NomCategorie nomCategorie) {
        this.nomCategorie = nomCategorie;
    }

    public Categorie(int id, String nomCategorie) {
        
        this.id = id;
        if (nomCategorie.equals("Reclamation")){this.nomCategorie = Reclamation;}
        else if (nomCategorie.equals("Avis")){this.nomCategorie = Avis;}
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public NomCategorie getNomCategorie() {
        return nomCategorie;
    }

    public void setNomCategorie(NomCategorie nomCategorie) {
        this.nomCategorie = nomCategorie;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + this.id;
        hash = 73 * hash + Objects.hashCode(this.nomCategorie);
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
        final Categorie other = (Categorie) obj;
        if (this.id != other.id) {
            return false;
        }
        return this.nomCategorie == other.nomCategorie;
    }

    @Override
    public String toString() {
        return "Categorie{" + "id=" + id + ", nomCategorie=" + nomCategorie + '}';
    }

    public void setNomCategorie(String reclamation) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
}
