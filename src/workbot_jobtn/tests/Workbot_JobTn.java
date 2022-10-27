/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package workbot_jobtn.tests;

import java.sql.SQLException;
import java.util.List;
import javafx.collections.ObservableList;
import workbot_jobtn.entites.*;
import static workbot_jobtn.entites.NomCategorie.*;
import workbot_jobtn.services.*;
import workbot_jobtn.utils.MyDB;
import java.sql.Date;

/**
 *
 * @author Exon
 */
public class Workbot_JobTn {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        System.out.println(MyDB.getInstance());
        
        //Categorie categorie1=new Categorie(Reclamation);
        //Categorie categorie2=new Categorie(Avis);    
        ServiceCategorie serv=new ServiceCategorie();       
        //serv.ajouter(categorie1);
        //serv.ajouter(categorie2);        
        //categorie1.setNomCategorie(Reclamation);
        //categorie1.setId(14);        
        //serv.modifier(categorie1);
        //serv.supprimer(categorie1);
        //List<Categorie> list=serv.afficherTout();
        //System.out.println(list);
        //System.out.println(categorie1);
        //Categorie c=serv.afficher(14);
        //Categorie c2=serv.afficher(11);
        //System.out.println(c);
        //System.out.println(c2);
        ServiceReclamationAvis serv2=new ServiceReclamationAvis();
        //ReclamationAvis rec1=new ReclamationAvis();
        //rec1.setCategorie(c);
        //rec1.setObjet("exemple");
        //rec1.setDescription("exemple");
        //serv2.ajouter(rec1);
        //ReclamationAvis av1=new ReclamationAvis();
        //av1.setCategorie(c2);
        //av1.setObjet("exemple");
        //av1.setDescription("exemple");
        //serv2.ajouter(av1);
        //rec1.setId(1);
        //rec1.setObjet("reclamation_cours");
        //rec1.setDescription("pas de cours");
        //serv2.modifier(rec1);
        //serv2.supprimer(rec1);
        
        //ObservableList<ReclamationAvis> r=serv2.afficherTout();
        
        ReclamationAvis r=serv2.afficher(3);
        System.out.println(r);
        
        
        
        
        
    }
    
}
