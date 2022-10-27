/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package workbot_jobtn.services;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import workbot_jobtn.entites.*;
import workbot_jobtn.entites.DTOavis_societe;
import workbot_jobtn.utils.MyDB;

/**
 *
 * @author youcef
 */
public class ServiceReclamationAvis implements InterfaceServiceReclamationAvis<ReclamationAvis>{
    private Statement statement ;
    private PreparedStatement pst;
    private Connection connection;
    public ServiceReclamationAvis() {
        connection=(Connection) MyDB.getInstance().getConnection();
    }

    @Override
    public void ajouter(ReclamationAvis t) throws SQLException {
        statement=connection.createStatement();
        String req;
        req = null;
        if(t.getImage()!=null){
        req="INSERT INTO reclamation_avis(objet,description,id_categorie,image) VALUES ('"+ t.getObjet()+"','"+t.getDescription()+"',"+t.getCategorie().getId()+",'"+t.getImage()+"');";
        }
        else {req="INSERT INTO reclamation_avis(objet,description,id_categorie) VALUES ('"+ t.getObjet()+"','"+t.getDescription()+"',"+t.getCategorie().getId()+");";}
        statement.executeUpdate(req);
        
    }

    

    @Override
    public boolean modifier(ReclamationAvis t) throws SQLException {
        String req;
        req=null;
        if(t.getImage()!=null){
        req="update reclamation_avis set objet = '"+t.getObjet()+"',description='"+t.getDescription()+"',image='"+t.getImage()+"' where id ="+t.getId()+";";
        }
        else{
        req="update reclamation_avis set objet = '"+t.getObjet()+"',description='"+t.getDescription()+"',image=null'"+"' where id ="+t.getId()+";";
        }
        try {
            statement=connection.createStatement();
            statement.executeUpdate(req);

        } catch (SQLException ex) {                                
        }
       return true;
        
    }

    @Override
    public boolean supprimer(ReclamationAvis t) throws SQLException {
        String req="delete from reclamation_avis where id ="+t.getId()+";";
        try {
            statement=connection.createStatement();
            statement.executeUpdate(req);

        } catch (SQLException ex) {                                
        }
       return true;
    }

    @Override
    public ObservableList<ReclamationAvis> afficherTout() throws SQLException {
        
        ObservableList<ReclamationAvis> l=FXCollections.observableArrayList();
     statement = connection.createStatement();
     ResultSet r= statement.executeQuery("select * from reclamation_avis");
     while (r.next()){
         int id=r.getInt("id");
         String objet=r.getString("objet");
         String date=(r.getDate("dateAjout")).toString();
         String description=r.getString("description");
         String image=r.getString("image");
         int note=r.getInt("note");
         int id_categorie=r.getInt("id_categorie");
         ServiceCategorie serv1=new ServiceCategorie();
         Categorie categorie= serv1.afficher(id_categorie);
         ReclamationAvis reclamationAvis=new ReclamationAvis(id, objet, date, description,categorie,image);
         
         l.add(reclamationAvis);
     }
     return l;
    }

    @Override
    public ReclamationAvis afficher(int i) throws SQLException {
        ReclamationAvis l=new ReclamationAvis();
        statement = connection.createStatement();
        ResultSet r= statement.executeQuery("select * from reclamation_avis where id="+i+";");
        while (r.next()){
        int id=r.getInt("id");
         String objet=r.getString("objet");
         String date=(r.getDate("dateAjout")).toString();
         String description=r.getString("description");
         String image=r.getString("image");
         int note=r.getInt("note");
         int id_categorie=r.getInt("id_categorie");
         ServiceCategorie serv1=new ServiceCategorie();
         Categorie categorie= serv1.afficher(id_categorie);
         l=new ReclamationAvis(id, objet, date, description,categorie,image);
         }
     return l;
        
    }

 
    public ObservableList<DTOavis_societe> afficherToutAvisSociete(int id) throws SQLException {
         //To change body of generated methods, choose Tools | Templates.
        ObservableList<DTOavis_societe> l=FXCollections.observableArrayList();
     statement = connection.createStatement();
     ResultSet r= statement.executeQuery("select u.nom, u.note, a.note, a.description from utilisateur u  join reclamation_avis a on u.id=a.id_societe where a.id_utilisateur= "+id+";");
     while (r.next()){
         //if ((r.getString("u.role")).equals("sociéte")){
         String nom=r.getString("u.nom");
         int note_moy=r.getInt("u.note");;
         int note=r.getInt("a.note");
         String desc=r.getString("a.description");
         DTOavis_societe avis=new DTOavis_societe(nom,note_moy,note,desc);
         
         l.add(avis);
     //}
         
     }
     return l;
    }
    public DTOavis_societe afficherAvisSociete(String n, int id) throws SQLException {
         //To change body of generated methods, choose Tools | Templates.
        DTOavis_societe l=new DTOavis_societe();
     statement = connection.createStatement();
     ResultSet r= statement.executeQuery("select u.nom, u.note, a.note, a.description from utilisateur u join reclamation_avis a on u.id=a.id_societe where a.id_utilisateur= "+id+" and u.nom ='"+n+"';");
     while (r.next()){
         String nom=r.getString("u.nom");
         int note_moy=r.getInt("u.note");;
         int note=r.getInt("a.note");
         String desc=r.getString("a.description");
         l=new DTOavis_societe(nom,note_moy,note,desc);
         
     }
     return l;
    }
    public User afficheruser2(String n) throws SQLException {
        User l=new User();
     statement = connection.createStatement();
     ResultSet r= statement.executeQuery("select * from reclamation_avis where nom="+n+";");
     while (r.next()){
         int id=r.getInt("id");
         String nom=r.getString("nom");
         String prenom=r.getString("prenom");
         String role=r.getString("role");
         String tel=r.getString("tel");
         String email=r.getString("email");
         String mdp=r.getString("mdp");
         String adresse=r.getString("adresse");
         String photo=r.getString("photo");
         String questionSecu=r.getString("questionSecu");
         String reponseSecu=r.getString("reponseSecu");
         String methode=r.getString("methode");
         String domaine=r.getString("domaine");
         l=new User(id,nom,prenom,role,tel,email,mdp,adresse,photo,questionSecu,reponseSecu,methode,domaine);
      
     }
     return l;
    
    }
    public User afficheruser1(int n) throws SQLException {
        User l=new User();
     statement = connection.createStatement();
     ResultSet r= statement.executeQuery("select * from reclamation_avis where id="+n+";");
     while (r.next()){
         int id=r.getInt("id");
         String nom=r.getString("nom");
         String prenom=r.getString("prenom");
         String role=r.getString("role");
         String tel=r.getString("tel");
         String email=r.getString("email");
         String mdp=r.getString("mdp");
         String adresse=r.getString("adresse");
         String photo=r.getString("photo");
         String questionSecu=r.getString("questionSecu");
         String reponseSecu=r.getString("reponseSecu");
         String methode=r.getString("methode");
         String domaine=r.getString("domaine");
         l=new User(id,nom,prenom,role,tel,email,mdp,adresse,photo,questionSecu,reponseSecu,methode,domaine);
      
     }
     return l;
    
    }
    public void ajouterAvis(ReclamationAvis t) throws SQLException {
        statement=connection.createStatement();
        String req;
        req = null;
        
        req="INSERT INTO reclamation_avis(id_categorie,description,note,id_societe,id_utilisateur) VALUES ('"+t.getCategorie().getId()+",'"+t.getDescription()+",'"+t.getNote()+",'"+ t.getSociete().getId()+",'"+t.getUser().getId()+"');";
        statement.executeUpdate(req);
        
    }
    
    public boolean modifierAvis(ReclamationAvis t) throws SQLException {
        String req;
        req=null;
        
        req="update reclamation_avis set description='"+t.getDescription()+"',note='"+t.getNote()+"' where id_societe ="+t.getSociete().getId()+" and id_utilisateur="+t.getUser().getId()+");";
        
        try {
            statement=connection.createStatement();
            statement.executeUpdate(req);

        } catch (SQLException ex) {                                
        }
       return true;
        
    }
    public boolean supprimerAvis(ReclamationAvis t) throws SQLException {
        String req="delete from reclamation_avis where (id_societe ='"+t.getSociete().getId()+" and id_utilisateur="+t.getUser().getId()+");";
        try {
            statement=connection.createStatement();
            statement.executeUpdate(req);

        } catch (SQLException ex) {                                
        }
       return true;
    }

    

}
