/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package workbot_jobtn.gui;

import java.math.BigInteger;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import workbot_jobtn.utils.MyDB;


/**
 * FXML Controller class
 *
 * @author fnmoh
 */
public class Signupetape5ConController implements Initializable {

    @FXML
    private Button M_finaliser;
    @FXML
    private Button M_Back;
    @FXML
    private TextField Rec_Role;
    @FXML
    private TextField Rec_Nom;
    @FXML
    private TextField Rec_Prenom;
    @FXML
    private TextField Rec_Email;
    @FXML
    private TextField Rec_Password;
    @FXML
    private TextField Rec_Questionsec;
    @FXML
    private TextField Rec_reponse;
    @FXML
    private TextField Rec_domaine;
    @FXML
    private TextField Rec_adresse;
    @FXML
    private TextField Rec_numero;
    @FXML
    private TextField Rec_datenaisss;
    private String rolee;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
     private Connection on;
    private Statement ste;

    public Signupetape5ConController (){
       on =  MyDB.getInstance().getConnection();
    }

    @FXML
    private void M_finaliser(ActionEvent event) {
        EnvoyerEmail test = new EnvoyerEmail();
        test.envoyer();
        if(event.getSource() == M_finaliser){
         insertuser();
             insertRoleee(rolee);
       
        }
       
             try {
Stage stage = (Stage) Rec_numero.getScene().getWindow();
                        stage.close();
                        
          Parent root=FXMLLoader.load(getClass().getResource("M_Login.fxml"));
			Scene scene = new Scene(root,840,600);
		
			stage.setScene(scene);
			stage.show();
                        
		} catch(Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    private void M_Back(ActionEvent event) {
       

    }
    
    
     public void Retourintous(String role100,String nom100,String prenom100,String mail100,String password100,String reponce100,String question100,String domaine100,String adresse100,String numero100){
     
     Rec_Role.setText(role100);
             Rec_Nom.setText(nom100);
             Rec_Prenom.setText(prenom100);
             
             Rec_Email.setText(mail100);
             Rec_Password.setText(password100);
             System.out.println(password100);
             Rec_Questionsec.setText(reponce100);
             Rec_reponse.setText(question100);
             Rec_domaine.setText(domaine100);
             Rec_adresse.setText(adresse100);
             Rec_numero.setText(numero100);
             
             
     
     
     
     }
        //////////////////////////////


        private void insertuser1() {
            /*
                String roleV1;
    String prenomV1;
    String mailV1;
    String nomV1;
        String passwordV1;
    String quesecV1;
    String responseV1;
    String domaineV1;
    String adresseV1;
    String numeroV1;
            roleV1=  Rec_Role.getText();
              prenomV1=Rec_Prenom.getText();
              mailV1=  Rec_Email.getText();
              nomV1= Rec_Nom.getText();
              passwordV1=  Rec_Password.getText();
              quesecV1= Rec_Questionsec.getText();
              responseV1=  Rec_reponse.getText();
              domaineV1=Rec_domaine.getText();
               adresseV1=  Rec_adresse.getText();
              numeroV1= Rec_numero.getText();
              
              
              
              String query = "INSERT INTO user (role,nom,prenom,email) VALUES ('" + roleV1 + "','" + nomV1 + "','" + prenomV1 + "','" + mailV1 + "')";
        
        executeQuery(query);
            */
        }
        /*    Encryptor encryptor = new Encryptor();*/

         private void insertuser() {
             
                String roleV1;
    String prenomV1;
    String mailV1;
    String nomV1;
        String passwordV1;
    String quesecV1;
    String responseV1;
    String domaineV1;
    String adresseV1;
    String numeroV1;
            roleV1=  Rec_Role.getText();
              prenomV1=Rec_Prenom.getText();
              mailV1=  Rec_Email.getText();
              nomV1= Rec_Nom.getText();
              passwordV1=  Rec_Password.getText();
              quesecV1= Rec_Questionsec.getText();
              responseV1=  Rec_reponse.getText();
              domaineV1=Rec_domaine.getText();
               adresseV1=  Rec_adresse.getText();
              numeroV1= Rec_numero.getText();
         
              
              char [] chars = passwordV1.toCharArray();
              
              for(char c : chars){
                  c+=5; 
                   
                   System.out.println(c);
              }
        
              
              String query = "INSERT INTO utilisateur (role,nom,prenom,email,mdp,questionSecu,reponseSecu,domaine,adresse,tel) VALUES ('" + roleV1 + "','" + nomV1 + "','" + prenomV1 + "','" + mailV1 + "','" + passwordV1 + "','" + quesecV1 + "','" + responseV1 + "','" + domaineV1 + "','" + adresseV1 + "','" + numeroV1 + "')";
        
        executeQuery(query);
             
        }
          private void insertRoleee(String rolee) {
         
        }
         
         ///////////////////
           
          private void executeQuery(String query) {
        Statement st;
        try{
            st = on.createStatement();
            st.executeUpdate(query);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
     
            
            
        
}
