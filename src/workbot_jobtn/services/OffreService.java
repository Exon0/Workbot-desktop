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
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import workbot_jobtn.entites.Candidat;
import workbot_jobtn.entites.Candidature;
import workbot_jobtn.entites.DTOCandidature_Offre;
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
                    + "  `id_Soc`, `modeTravail`, `typeOffre`, `salaire`, `typeContrat`, `dureeStage`, `typeStage`,`dateAjout`) "
                    + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?);");
            prep.setString(1, O.getTitre());
            prep.setString(2, O.getDescription());
            prep.setString(3, O.getDomaine());
            prep.setString(4, O.getDateExpiration());
            prep.setInt(5, O.getId_soc());
            prep.setString(6, O.getModeTravail());    
            prep.setString(7,O.getTypeOffre().name());
            prep.setString(8, O.getSalaire());    
            prep.setString(9,O.getTypeContrat());
            prep.setString(10, O.getSalaire());    
            prep.setString(11,O.getTypeStage());
            prep.setString(12,new Date().toString());
           
            prep.executeUpdate();

        
    }

    @Override
    public boolean update(Offre O){
        try {
            PreparedStatement prep = connection.prepareStatement("UPDATE `offre` SET `titre`=?,`description`=?,`domaine`=?,`dateExpiration`=?,`id_Soc`=?,`modeTravail`=?,`typeOffre`=?,`id_test`=? WHERE id=?");
            prep.setInt(9, O.getId());
            prep.setString(1, O.getTitre());
            prep.setString(2, O.getDescription());
            prep.setString(3, O.getDomaine());
            prep.setString(4, O.getDateExpiration());
            prep.setInt(5, O.getId_soc());
            prep.setString(6, O.getModeTravail());    
            prep.setString(7,O.getTypeOffre().name());
                        prep.setInt(8,O.getId_test());

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
    
        public boolean deleteById(int id) {
        try {
            PreparedStatement prep = connection.prepareStatement("DELETE FROM `offre` WHERE id=?");
            prep.setInt(1, id);
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
                   int nbCand=nbCandidature(id);
                   String titre= r.getString(2);
                   String desc= r.getString(4);
                   String domaine= r.getString(5);
                   String dateExp= r.getString(6);
                   int id_soc= r.getInt(12);
                   String modeTravail= r.getString(13);
                   String typeOffre= r.getString(16);
                   TypeOffre tp= TypeOffre.valueOf(typeOffre);
                   String dateAjout=r.getString(17);
                  // Button bt=new Button("test");
                   Offre O= new Offre(id, titre, desc, domaine, dateExp, modeTravail, id_soc, tp,dateAjout,nbCand);
                   
                   listeOffre.add(O);
                   

               }
        } catch (SQLException ex) {
            Logger.getLogger(OffreService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listeOffre;
    }
       /* public Offre selectById(int id){
        try {
            Statement=connection.createStatement();
            ResultSet r=Statement.executeQuery("SELECT * from `offre` where id=?");
            int id1 = r.getInt("id");
            String titre= r.getString(2);
            String desc= r.getString(4);
            String domaine= r.getString(5);
            String dateExp= r.getString(6);
            int id_soc= r.getInt(12);
            String modeTravail= r.getString(13);
            String typeOffre= r.getString(16);
            TypeOffre tp= TypeOffre.valueOf(typeOffre);
            Offre O= new Offre(id1, titre, desc, domaine, dateExp, modeTravail, id_soc, tp);
            
            return O;
        } catch (SQLException ex) {
            Logger.getLogger(OffreService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        }*/
    /* public List<Offre> readLast() {
        List<Offre> listeOffre = new ArrayList<>();
        try {
               Statement=connection.createStatement();
               ResultSet r=Statement.executeQuery("SELECT * from `offre` where id_soc=1 ORDER BY id DESC LIMIT 1");
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
                   //String dateAjout=r.getString(17);
                   //Button bt=new Button("test");
                   Offre O= new Offre(id, titre, desc, domaine, dateExp, modeTravail, id_soc, tp);
                   
                   listeOffre.add(O);
                   

               }
        } catch (SQLException ex) {
            Logger.getLogger(OffreService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listeOffre;
    }*/
     public Offre readLast() {
        try {
               Statement=connection.createStatement();
               ResultSet r=Statement.executeQuery("SELECT * from `offre` where id_soc=1 ORDER BY id DESC LIMIT 1");
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
                   //String dateAjout=r.getString(17);
                   //Button bt=new Button("test");
                   Offre O= new Offre(id, titre, desc, domaine, dateExp, modeTravail, id_soc, tp);
                   return O;
                   

               }
        } catch (SQLException ex) {
            Logger.getLogger(OffreService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
     
    public ObservableList<DTOCandidature_Offre> candidatures_Offre(int id_off){
        
         ObservableList<DTOCandidature_Offre> candidatures = FXCollections.observableArrayList();
        try {
               Statement=connection.createStatement();
               ResultSet r=Statement.executeQuery("SELECT c.id,u.email, u.nom ,c.dateAjout,c.noteTest,c.lettreMotivation,c.statut,o.titre "
                       + "from `candidature` c join `offre` o on c.id_offre=o.id JOIN `utilisateur` u ON u.id=c.id_user where o.id="+id_off);
               while(r.next()){
                   DTOCandidature_Offre cand= new DTOCandidature_Offre();
                   cand.setNomCandidat(r.getString("u.nom"));
                   cand.setDateAjout(r.getString("c.dateAjout"));
                   cand.setNoteTest(r.getString("c.noteTest"));
                   cand.setLettreMotivation(r.getString("c.lettreMotivation"));
                   cand.setStatut(r.getString("c.statut"));
                   cand.setTitreOffre(r.getString("o.titre"));
                   cand.setId_cand(r.getInt("c.id"));
                   cand.setEmail(r.getString("u.email"));

                   candidatures.add(cand);
                   

               }
        } catch (SQLException ex) {
            Logger.getLogger(OffreService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return candidatures;
        
    }
    
    public int nbCandidature(int idO){
        int nb=-1;
         try {
               Statement=connection.createStatement();
               ResultSet r=Statement.executeQuery("SELECT count(*) from `offre` o join `candidature` c on o.id=c.id_offre where o.id="+idO);
               r.next();    
               nb=r.getInt(1);
                   return nb;
                   

               
        } catch (SQLException ex) {
            Logger.getLogger(OffreService.class.getName()).log(Level.SEVERE, null, ex);
        }
         return nb;

    }
}
