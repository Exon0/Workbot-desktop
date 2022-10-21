/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package workbot_jobtn.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import workbot_jobtn.entites.Categorie;
import workbot_jobtn.entites.Evenement;
import workbot_jobtn.entites.Offre;
import workbot_jobtn.entites.ReclamationAvis;
import workbot_jobtn.entites.Societe;
import workbot_jobtn.entites.User;
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
        String req="INSERT INTO reclamation_avis(objet,description,id_categorie) VALUES ('"+ t.getObjet()+"','"+t.getDescription()+"',"+t.getCategorie().getId()+");";
        statement.executeUpdate(req);
        
    }

    

    @Override
    public boolean modifier(ReclamationAvis t) throws SQLException {
        String req="update reclamation_avis set objet = '"+t.getObjet()+"',description='"+t.getDescription()+"' where id ="+t.getId()+";";
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
    public List<ReclamationAvis> afficherTout() throws SQLException {
        
        List<ReclamationAvis> l=new ArrayList<>();
     statement = connection.createStatement();
     ResultSet r= statement.executeQuery("select * from reclamation_avis");
     while (r.next()){
         int id=r.getInt("id");
         String objet=r.getString("objet");
         Date date=r.getDate("dateAjout");
         String description=r.getString("description");
         String image=r.getString("image");
         int note=r.getInt("note");
         int id_categorie=r.getInt("id_categorie");
         ServiceCategorie serv1=new ServiceCategorie();
         Categorie categorie= serv1.afficher(id_categorie);
         ReclamationAvis reclamationAvis=new ReclamationAvis(id, objet, date, description,categorie);
         l.add(reclamationAvis);
     }
     return l;
    }

    @Override
    public ReclamationAvis afficher(int i) throws SQLException {
        List<ReclamationAvis> l=new ArrayList<>();
        statement = connection.createStatement();
        ResultSet r= statement.executeQuery("select * from reclamation_avis where id="+i+";");
        while (r.next()){
        int id=r.getInt("id");
         String objet=r.getString("objet");
         Date date=r.getDate("dateAjout");
         String description=r.getString("description");
         String image=r.getString("image");
         int note=r.getInt("note");
         int id_categorie=r.getInt("id_categorie");
         ServiceCategorie serv1=new ServiceCategorie();
         Categorie categorie= serv1.afficher(id_categorie);
         ReclamationAvis reclamationAvis=new ReclamationAvis(id, objet, date, description,categorie);
         l.add(reclamationAvis);
     }
     return l.get(0);
        
    }

}
