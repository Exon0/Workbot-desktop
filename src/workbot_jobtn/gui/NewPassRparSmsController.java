/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.sql.Connection;
import java.sql.Statement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import workbot_jobtn.utils.MyDB;


/**
 *
 * @author fnmoh
 */
public class NewPassRparSmsController {
 private Connection on;
    private Statement ste;

    public NewPassRparSmsController (){
       on =  MyDB.getInstance().getConnection();
    }
    @FXML
    private TextField SmsNewPass;
    @FXML
    private Button ConfirmerPassparSMS;
    @FXML
    private TextField SmSReponseL;
    @FXML
    private TextField SmSMaiL;

    @FXML
    private void ConfirmerPassparSMSM(ActionEvent event) {
        
        
        updateRecord();
        
        
    }
     public void RetourPassword(String mailSms,String ReponseSms){
     SmSMaiL.setText(mailSms);
             SmSReponseL.setText(ReponseSms);
            
             
         }
///////////////////////////////////
  private void updateRecord(){
        String query = "UPDATE  user SET  mdp = '" + SmsNewPass.getText() + "' WHERE email = '" + SmSMaiL.getText() + "' ";
        executeQuery(query);
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                     alert.setTitle("JobTn :: Information correct");
                     alert.setHeaderText(null);
                     alert.setContentText("ton motpasse changée avec succes");
                     alert.showAndWait();
                     try {
Stage stage = (Stage)  SmsNewPass.getScene().getWindow();
                        stage.close();
                        
          Parent root=FXMLLoader.load(getClass().getResource("M_Login.fxml"));
			Scene scene = new Scene(root,840,600);
		
			stage.setScene(scene);
			stage.show();
                        
		} catch(Exception e) {
			e.printStackTrace();
		}
        
    }
  //////////////////////////////////////////////////////////////
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
