/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package workbot_jobtn.entites;

import java.util.Objects;

/**
 *
 * @author Exon
 */
public class Offre {
    
    private int id;

    private String titre;

    private String Salaire;

    private String description;

    private String domaine;

    private String dateExpiration;

    private String dureeStage;

    private String typeStage;
   
    private String typeContrat;

    private String dureeContrat;

    private String anneeExperience;

    private String modeTravail;

    private String lieu;

    private Integer id_soc;

    private Integer id_test;
    
    private TypeOffre typeOffre;
    
    private String dateAjout;

    public Offre() {
    }

    public Offre(String titre, String description, String domaine, String dateExpiration, TypeOffre typeOffre,Integer id_soc) {
        this.titre = titre;
        this.description = description;
        this.domaine = domaine;
        this.dateExpiration = dateExpiration;
        this.typeOffre = typeOffre;
        this.id_soc=id_soc;
    }

    public Offre(String titre, String description, String domaine, String dateExpiration, String modeTravail, Integer id_soc, TypeOffre typeOffre) {
        this.titre = titre;
        this.description = description;
        this.domaine = domaine;
        this.dateExpiration = dateExpiration;
        this.modeTravail = modeTravail;
        this.id_soc = id_soc;
        this.typeOffre = typeOffre;
    }
    

    public Offre(int id, String titre, String Salaire, String description, String domaine, String dateExpiration, String dureeStage, String typeStage, String dureeContrat, String anneeExperience, String modeTravail, String lieu, Integer id_soc, Integer id_test, TypeOffre typeOffre) {
        this.id = id;
        this.titre = titre;
        this.Salaire = Salaire;
        this.description = description;
        this.domaine = domaine;
        this.dateExpiration = dateExpiration;
        this.dureeStage = dureeStage;
        this.typeStage = typeStage;
        this.dureeContrat = dureeContrat;
        this.anneeExperience = anneeExperience;
        this.modeTravail = modeTravail;
        this.lieu = lieu;
        this.id_soc = id_soc;
        this.id_test = id_test;
        this.typeOffre = typeOffre;
    }

    public Offre(String titre, String Salaire, String description, String domaine, String dateExpiration, String dureeStage, String typeStage, String dureeContrat, String anneeExperience, String modeTravail, String lieu, Integer id_soc, Integer id_test, TypeOffre typeOffre) {
        this.titre = titre;
        this.Salaire = Salaire;
        this.description = description;
        this.domaine = domaine;
        this.dateExpiration = dateExpiration;
        this.dureeStage = dureeStage;
        this.typeStage = typeStage;
        this.dureeContrat = dureeContrat;
        this.anneeExperience = anneeExperience;
        this.modeTravail = modeTravail;
        this.lieu = lieu;
        this.id_soc = id_soc;
        this.id_test = id_test;
        this.typeOffre = typeOffre;
    }

    public Offre(int id, String titre, String description, String domaine, String dateExpiration, String modeTravail, Integer id_soc, TypeOffre typeOffre,String dateAjout) {
        this.id = id;
        this.titre = titre;
        this.description = description;
        this.domaine = domaine;
        this.dateExpiration = dateExpiration;
        this.modeTravail = modeTravail;
        this.id_soc = id_soc;
        this.typeOffre = typeOffre;
        this.dateAjout=dateAjout;
    }

    public Offre(String titre, String Salaire, String description, String domaine, String dateExpiration, String dureeStage, String typeStage, String typeContrat, String dureeContrat, String anneeExperience, String modeTravail, String lieu, Integer id_soc, Integer id_test, TypeOffre typeOffre, String dateAjout) {
        this.titre = titre;
        this.Salaire = Salaire;
        this.description = description;
        this.domaine = domaine;
        this.dateExpiration = dateExpiration;
        this.dureeStage = dureeStage;
        this.typeStage = typeStage;
        this.typeContrat = typeContrat;
        this.dureeContrat = dureeContrat;
        this.anneeExperience = anneeExperience;
        this.modeTravail = modeTravail;
        this.lieu = lieu;
        this.id_soc = id_soc;
        this.id_test = id_test;
        this.typeOffre = typeOffre;
        this.dateAjout = dateAjout;
    }



 

  
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getSalaire() {
        return Salaire;
    }

    public void setSalaire(String Salaire) {
        this.Salaire = Salaire;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDomaine() {
        return domaine;
    }

    public void setDomaine(String domaine) {
        this.domaine = domaine;
    }

    public String getDateExpiration() {
        return dateExpiration;
    }

    public void setDateExpiration(String dateExpiration) {
        this.dateExpiration = dateExpiration;
    }

    public String getDureeStage() {
        return dureeStage;
    }

    public void setDureeStage(String dureeStage) {
        this.dureeStage = dureeStage;
    }

    public String getTypeStage() {
        return typeStage;
    }

    public void setTypeStage(String typeStage) {
        this.typeStage = typeStage;
    }

    public String getDureeContrat() {
        return dureeContrat;
    }

    public void setDureeContrat(String dureeContrat) {
        this.dureeContrat = dureeContrat;
    }

    public String getAnneeExperience() {
        return anneeExperience;
    }

    public void setAnneeExperience(String anneeExperience) {
        this.anneeExperience = anneeExperience;
    }

    public String getModeTravail() {
        return modeTravail;
    }

    public void setModeTravail(String modeTravail) {
        this.modeTravail = modeTravail;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public Integer getId_soc() {
        return id_soc;
    }

    public void setId_soc(Integer id_soc) {
        this.id_soc = id_soc;
    }

    public Integer getId_test() {
        return id_test;
    }

    public void setId_test(Integer id_test) {
        this.id_test = id_test;
    }

    public TypeOffre getTypeOffre() {
        return typeOffre;
    }

    public void setTypeOffre(TypeOffre typeOffre) {
        this.typeOffre = typeOffre;
    }
   public String getTypeContrat() {
        return typeContrat;
    }

    public void setTypeContrat(String typeContrat) {
        this.typeContrat = typeContrat;
    }

    @Override
    public String toString() {
        return "I_Offre{" + "id=" + id + ", titre=" + titre + ", Salaire=" + Salaire + ", description=" + description + ", domaine=" + domaine + ", dateExpiration=" + dateExpiration + ", dureeStage=" + dureeStage + ", typeStage=" + typeStage + ", dureeContrat=" + dureeContrat + ", anneeExperience=" + anneeExperience + ", modeTravail=" + modeTravail + ", lieu=" + lieu + ", id_soc=" + id_soc + ", id_test=" + id_test + ", typeOffre=" + typeOffre + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.id);
        hash = 29 * hash + Objects.hashCode(this.titre);
        hash = 29 * hash + Objects.hashCode(this.domaine);
        hash = 29 * hash + Objects.hashCode(this.id_soc);
        hash = 29 * hash + Objects.hashCode(this.typeOffre);
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
        final Offre other = (Offre) obj;
        if (!Objects.equals(this.titre, other.titre)) {
            return false;
        }
        if (!Objects.equals(this.domaine, other.domaine)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.id_soc, other.id_soc)) {
            return false;
        }
        return this.typeOffre == other.typeOffre;
    }
}
