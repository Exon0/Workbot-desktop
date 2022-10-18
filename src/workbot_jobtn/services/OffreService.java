/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package workbot_jobtn.services;

import java.util.List;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Button;
import workbot_jobtn.entites.Offre;
import workbot_jobtn.entites.TypeOffre;
import workbot_jobtn.utils.MyDB;

/**
 *
 * @author Exon
 */
public class OffreService implements ICrud_Interface<Offre>{

    private Connection connection;
    private Statement Statement;

    public OffreService() {
        connection=MyDB.getInstance().getConnection();
    }
    
    @Override
    public void ajouter(Offre O) throws SQLException {
       
            PreparedStatement prep = connection.prepareStatement("INSERT INTO `offre`( `titre`, `description`, `domaine`, `dateExpiration`, "
                    + "  `id_Soc`, `modeTravail`, `typeOffre`) "
                    + " VALUES (?,?,?,?,?,?,?);");
            prep.setString(1, O.getTitre());
            prep.setString(2, O.getDescription());
            prep.setString(3, O.getDomaine());
            prep.setString(4, O.getDateExpiration());
            prep.setInt(5, O.getId_soc());
            prep.setString(6, O.getModeTravail());    
            prep.setString(7,O.getTypeOffre().name());
            
            prep.executeUpdate();

        
    }

    @Override
    public boolean update(Offre O){
        try {
            PreparedStatement prep = connection.prepareStatement("UPDATE `offre` SET `titre`=?,`description`=?,`domaine`=?,`dateExpiration`=?,`id_Soc`=?,`modeTravail`=?,`typeOffre`=? WHERE id=?");
            prep.setInt(8, O.getId());
            prep.setString(1, O.getTitre());
            prep.setString(2, O.getDescription());
            prep.setString(3, O.getDomaine());
            prep.setString(4, O.getDateExpiration());
            prep.setInt(5, O.getId_soc());
            prep.setString(6, O.getModeTravail());    
            prep.setString(7,O.getTypeOffre().name());
            prep.executeUpdate();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }

    @Override
    public boolean delete(Offre O) {
        try {
            PreparedStatement prep = connection.prepareStatement("DELETE FROM `offre` WHERE id=?");
            prep.setInt(1, O.getId());
                        prep.executeUpdate();
                        return true;
        } catch (SQLException ex) {
                        return false;        }
    }

    /**
     *
     * @return
     */
    @Override
    public List<Offre> readAll() {
        List<Offre> listeOffre = new ArrayList<>();
        try {
               Statement=connection.createStatement();
               ResultSet r=Statement.executeQuery("SELECT * from `offre`");
               while(r.next()){
                   int id = r.getInt("id");
                   String titre= r.getString(2);
                   String desc= r.getString(4);
                   String domaine= r.getString(5);
                   String dateExp= r.getString(6);
                   int id_soc= r.getInt(12);
                   String modeTravail= r.getString(13);
                   String typeOffre= r.getString(16);
                   TypeOffre tp= TypeOffre.valueOf(typeOffre);
                   String dateAjout=r.getString(17);
                   //Button bt=new Button("test");
                   Offre O= new Offre(id, titre, desc, domaine, dateExp, modeTravail, id_soc, tp,dateAjout);
                   
                   listeOffre.add(O);
                   

               }
        } catch (SQLException ex) {
            Logger.getLogger(OffreService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listeOffre;
    }
    
}
