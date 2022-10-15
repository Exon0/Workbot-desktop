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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import workbot_jobtn.entites.Offre;
import workbot_jobtn.entites.Test;
import workbot_jobtn.entites.TypeOffre;
import workbot_jobtn.utils.MyDB;

/**
 *
 * @author Exon
 */
public class TestService implements ICrud_Interface<Test>{
 private Connection connection;
    private Statement Statement;

    public TestService() {
        connection=MyDB.getInstance().getConnection();
    }
    @Override
    public void ajouter(Test t) throws SQLException {
 PreparedStatement prep = connection.prepareStatement("INSERT INTO `test`(`titre`, `domaine`, `description`, `lien`, `categorie`) "
         + "                                            VALUES (?,?,?,?,?)");
            prep.setString(1, t.getTitre());
            prep.setString(2, t.getDomaine());
             prep.setString(3, t.getDescription());
            prep.setString(4, t.getLien());
            prep.setString(5, t.getCategorie());
          
            
            prep.executeUpdate();
    }

    @Override
    public boolean update(Test t) throws SQLException {
 try {
            PreparedStatement prep = connection.prepareStatement("UPDATE `test` SET `titre`=?,`domaine`=?,`description`=?,`lien`=?,`categorie`=? WHERE id=?");
            prep.setInt(6, t.getId());
            prep.setString(1, t.getTitre());
             prep.setString(2, t.getDomaine());
            prep.setString(3, t.getDescription());
             prep.setString(4, t.getLien());
              prep.setString(5, t.getCategorie());
           
         
            prep.executeUpdate();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }    

    @Override
    public boolean delete(Test t) throws SQLException {
     try {
            PreparedStatement prep = connection.prepareStatement("DELETE FROM `test` WHERE id=?");
            prep.setInt(1, t.getId());
                        prep.executeUpdate();
                        return true;
        } catch (SQLException ex) {
                        return false;        }    }

    @Override
    public List<Test> readAll() throws SQLException {
 List<Test> listeTests = new ArrayList<>();
        try {
               Statement=connection.createStatement();
               ResultSet r=Statement.executeQuery("SELECT * from `test`");
               while(r.next()){
                   int id = r.getInt(1);
                   String titre= r.getString(2);
                   String domaine= r.getString(3);
                   String desc= r.getString(4);
                   String lien= r.getString(5);
                   String cat= r.getString(6);

   
                  Test test = new Test(id, titre, domaine, desc, lien, cat);
                   listeTests.add(test);
                   

               }
        } catch (SQLException ex) {
            Logger.getLogger(OffreService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listeTests;    }


    
}
