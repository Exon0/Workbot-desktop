/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package workbot_jobtn.services;

import java.io.File;
import static java.lang.Math.round;
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
         String note=r.getString("note");
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
         String note=r.getString("note");
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
    
    public ReclamationAvis afficherAvisSociete(String n, int id) throws SQLException {
         //To change body of generated methods, choose Tools | Templates.
        ReclamationAvis l=new ReclamationAvis();
        l=null;
     statement = connection.createStatement();
     ResultSet r= statement.executeQuery("select a.note, a.description from utilisateur u join reclamation_avis a on u.id=a.id_societe where a.id_utilisateur= "+id+" and u.nom ='"+n+"';");
     while (r.next()){
         String note=r.getString("a.note");
         String desc=r.getString("a.description");
         l=new ReclamationAvis(desc,note);
         
     }
     return l;
    }
    public User afficheruser2(String n) throws SQLException {
        User l=new User();
     statement = connection.createStatement();
     ResultSet r= statement.executeQuery("select * from Utilisateur where nom='"+n+"';");
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
     ResultSet r= statement.executeQuery("select * from Utilisateur where id="+n+";");
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
        String req1;
        String nouvelle = "";
        
        req="INSERT INTO reclamation_avis(id_categorie,description,note,id_societe,id_utilisateur) VALUES ("+t.getCategorie().getId()+",'"+t.getDescription()+"','"+t.getNote()+"',"+ t.getSociete().getId()+","+t.getUser().getId()+");";
        statement.executeUpdate(req);
        int x;
        //x=t.getSociete().getNote().length();
        //if(t.getSociete().getNote().equals("*") || t.getSociete().getNote().equals("**")|| t.getSociete().getNote().equals("***")|| t.getSociete().getNote().equals("****")|| t.getSociete().getNote().equals("*****")){x=t.getSociete().getNote().length();}
       // if(afficherAvisSociete(t.getSociete().getNom()).size()==0){x=0;}
        //else if(t.getSociete().getNote().compareTo("*")==0|| t.getSociete().getNote().compareTo("**")==0|| t.getSociete().getNote().compareTo("***")==0|| t.getSociete().getNote().compareTo("****")==0|| t.getSociete().getNote().compareTo("*****")==0){x=t.getSociete().getNote().length();}
        if(t.getSociete().getNote()==null) {x=0;}
        else {x=t.getSociete().getNote().length();}
        int y = t.getNote().length();
        System.out.println(" y = "+y );
        int z = round(((x*countavis(t.getSociete().getId()))+y)/(countavis(t.getSociete().getId())+1));
        System.out.println(" z = "+z );
        System.out.println(" x = "+x );
        System.out.println(" count = "+countavis(t.getSociete().getId() ));
        switch(z) {
  case 1:
    nouvelle ="*";
    break;
  case 2:
    nouvelle ="**";
    break;
  case 3:
      nouvelle ="***";
      break;
  case 4:
      nouvelle ="****";
      break;
  case 5:
      nouvelle ="*****";
      break;
     
}
      req1="update utilisateur set note='"+nouvelle+"' where id ="+t.getSociete().getId()+";";
      statement.executeUpdate(req1);
        
        
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
public ObservableList<User> afficherToutSociete() throws SQLException {
        
        ObservableList<User> l=FXCollections.observableArrayList();
     statement = connection.createStatement();
     ResultSet r= statement.executeQuery("select nom, note from utilisateur where role='sociéte';");
     while (r.next()){
         String nom=r.getString("nom");
         
         String note=r.getString("note");
         
         User user=new User(nom,note);
         
         l.add(user);
      
      
     }
     return l;
    
    }
    
public User afficherSociete(String n) throws SQLException {
        
        User l= new User();
     statement = connection.createStatement();
     ResultSet r= statement.executeQuery("select nom, note from utilisateur where role='sociéte' and utilisateur.nom = '"+n+"';");
     while (r.next()){
         String nom=r.getString("nom");
         
         String note=r.getString("note");
         
         l=new User(nom,note);
         
         
      
      
     }
     return l;
    
    }
   public List<ReclamationAvis> afficherAvisSociete(String n) throws SQLException {
         //To change body of generated methods, choose Tools | Templates.
        List<ReclamationAvis> l=new ArrayList();
        
        ArrayList m=new ArrayList(0);
        
     statement = connection.createStatement();
     ResultSet r= statement.executeQuery("select a.note, a.description from utilisateur u join reclamation_avis a on u.id=a.id_societe where u.nom ='"+n+"';");
     ReclamationAvis rec=new ReclamationAvis();
     rec=null;
     while (r.next()){
         String note=r.getString("a.note");
         String desc=r.getString("a.description");
         ReclamationAvis rec1=new ReclamationAvis(desc,note);
         rec=rec1;
         l.add(rec1);
     }
     if(rec==null) {return m;}
     else {
     return l;}
    }
   public int countavis(int id) throws SQLException {
        int nb=0;
        //User l= new User();
     statement = connection.createStatement();
     ResultSet r= statement.executeQuery("select count(*) nb from reclamation_avis where id_societe = "+id+";");
     while (r.next()){
         nb=r.getInt("nb");
         
     }
     return nb;
    
    }
   
}
