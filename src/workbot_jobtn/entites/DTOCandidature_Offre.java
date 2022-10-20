/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package workbot_jobtn.entites;

/**
 *
 * @author Exon
 */
public class DTOCandidature_Offre {
    
    private String nomCandidat;
    
    private String dateAjout;
    
    private String noteTest;
    
    private String lettreMotivation;
    
    private String statut;
    
    private String titreOffre;

    public int getId_cand() {
        return id_cand;
    }

    public void setId_cand(int id_cand) {
        this.id_cand = id_cand;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    private int id_cand;
    
    private String email;

    public DTOCandidature_Offre() {
    }

    
    public DTOCandidature_Offre(int id_cand,String nomCandidat, String dateAjout, String noteTest, String lettreMotivation, String statut, String titreOffre) {
        this.id_cand=id_cand;
        this.nomCandidat = nomCandidat;
        this.dateAjout = dateAjout;
        this.noteTest = noteTest;
        this.lettreMotivation = lettreMotivation;
        this.statut = statut;
        this.titreOffre = titreOffre;
    }
    
    

    public String getNomCandidat() {
        return nomCandidat;
    }

    public void setNomCandidat(String nomCandidat) {
        this.nomCandidat = nomCandidat;
    }

    public String getDateAjout() {
        return dateAjout;
    }

    public void setDateAjout(String dateAjout) {
        this.dateAjout = dateAjout;
    }

    public String getNoteTest() {
        return noteTest;
    }

    public void setNoteTest(String noteTest) {
        this.noteTest = noteTest;
    }

    public String getLettreMotivation() {
        return lettreMotivation;
    }

    public void setLettreMotivation(String lettreMotivation) {
        this.lettreMotivation = lettreMotivation;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getTitreOffre() {
        return titreOffre;
    }

    public void setTitreOffre(String titreOffre) {
        this.titreOffre = titreOffre;
    }
    
    
    
}
