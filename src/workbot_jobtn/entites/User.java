/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workbot_jobtn.entites;

/**
 *
 * @author fnmoh
 */
public class User {
    private int id;
    private String nom;
    private String prenom;
    private String role;
    private String tel;
    private String email;
    private String mdp;
    private String adresse;
    private String photo;
    private String questionSecu;
    private String reponseSecu;
    private String methode;

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getRole() {
        return role;
    }

    public String getTel() {
        return tel;
    }

    public String getEmail() {
        return email;
    }

    public String getMdp() {
        return mdp;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getPhoto() {
        return photo;
    }

    public String getQuestionSecu() {
        return questionSecu;
    }

    public String getReponseSecu() {
        return reponseSecu;
    }

    public String getMethode() {
        return methode;
    }

    public User(int id, String nom, String prenom, String role, String tel, String email, String mdp, String adresse, String photo, String questionSecu, String reponseSecu, String methode) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.role = role;
        this.tel = tel;
        this.email = email;
        this.mdp = mdp;
        this.adresse = adresse;
        this.photo = photo;
        this.questionSecu = questionSecu;
        this.reponseSecu = reponseSecu;
        this.methode = methode;
    }

    public User() {
    }

    public User(String nom, String prenom, String role, String tel, String email, String mdp, String adresse, String photo, String questionSecu, String reponseSecu, String methode) {
        this.nom = nom;
        this.prenom = prenom;
        this.role = role;
        this.tel = tel;
        this.email = email;
        this.mdp = mdp;
        this.adresse = adresse;
        this.photo = photo;
        this.questionSecu = questionSecu;
        this.reponseSecu = reponseSecu;
        this.methode = methode;
    }

    public User(int id, String nom, String prenom, String email, String mdp) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.mdp = mdp;
    }

    public User(int id, String nom, String prenom, String role, String tel, String email, String adresse) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.role = role;
        this.tel = tel;
        this.email = email;
        this.adresse = adresse;
    }

    public User(String nom, String prenom, String role, String tel, String email, String adresse) {
        this.nom = nom;
        this.prenom = prenom;
        this.role = role;
        this.tel = tel;
        this.email = email;
        this.adresse = adresse;
    }
    
}