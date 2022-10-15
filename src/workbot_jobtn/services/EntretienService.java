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
import workbot_jobtn.entites.Entretien;
import workbot_jobtn.entites.Test;
import workbot_jobtn.utils.MyDB;

/**
 *
 * @author Exon
 */
public class EntretienService implements ICrud_Interface<Entretien>{
 private Connection connection;
    private Statement Statement;

    public EntretienService() {
        connection=MyDB.getInstance().getConnection();
    }
    @Override
    public void ajouter(Entretien e) throws SQLException {
 PreparedStatement prep = connection.prepareStatement("INSERT INTO `entretien`( `date`, `lienMeet`, `id_candidature`)"
         + "                                         VALUES (?,?,?)");
            prep.setString(1, e.getDate());
            prep.setString(2, e.getLienMeet());
             prep.setInt(3, e.getId_Candidature());
     
          
            
            prep.executeUpdate();    }

    @Override
    public boolean update(Entretien e)  {
     try {
         PreparedStatement prep = connection.prepareStatement("UPDATE `entretien` SET `date`=?,`lienMeet`=?,`id_candidature`=? WHERE id=?");
         prep.setInt(4, e.getId());
         prep.setString(1, e.getDate());
         prep.setString(2, e.getLienMeet());
         prep.setInt(3, e.getId_Candidature());
         
         
         
         prep.executeUpdate();
         return true;
     } catch (SQLException ex) {
         Logger.getLogger(EntretienService.class.getName()).log(Level.SEVERE, null, ex);
     }
     return false;
 }

    @Override
    public boolean delete(Entretien t) throws SQLException {
  try {
            PreparedStatement prep = connection.prepareStatement("DELETE FROM `entretien` WHERE id=?");
            prep.setInt(1, t.getId());
                        prep.executeUpdate();
                        return true;
        } catch (SQLException ex) {
                        return false;     }
    }

  

    @Override
    public List<Entretien> readAll() throws SQLException {
 List<Entretien> listEntretiens = new ArrayList<>();
        try {
               Statement=connection.createStatement();
               ResultSet r=Statement.executeQuery("SELECT * from `entretien`");
               while(r.next()){
                   int id = r.getInt(1);
                   String date= r.getString(2);
                   String lien= r.getString(3);
                   int id_candidature= r.getInt(4);
                 

                   Entretien entretien=new Entretien(id, date, lien, id_candidature);
                               listEntretiens.add(entretien);
                   

               }
        } catch (SQLException ex) {
            Logger.getLogger(OffreService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listEntretiens;     }
    
}
