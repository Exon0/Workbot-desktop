/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package workbot_jobtn.gui;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;
import workbot_jobtn.utils.MyDB;


/**
 *
 * @author fnmoh
 */
public class M_LoginUser implements Initializable {
    
    @FXML
    private Button M_loginidb;

    @FXML
    private Button M_restorepassword;

    @FXML
    private Button M_creecompte;
    @FXML
    private TextField M_Mail;
    @FXML
    private PasswordField M_password;
    @FXML
    private CheckBox M_Monterpa;
    @FXML
    private TextField passwordText_M;
    @FXML
    private ImageView imagedour;
    @FXML
    private ImageView eclipse;

    @FXML
    void M_creecompteactionB(ActionEvent event) {
        
        try {
Stage stage = (Stage) M_restorepassword.getScene().getWindow();
                        stage.close();
                        
          Parent root=FXMLLoader.load(getClass().getResource("M_Signup.fxml"));
			Scene scene = new Scene(root,840,600);
		
			stage.setScene(scene);
			stage.show();
                        
		} catch(Exception e) {
			e.printStackTrace();
		}
    }
       private Connection on;
    private Statement ste;

   
    @FXML
    private void M_loginidb(ActionEvent event) throws SQLException {
         
        ////////////5dhena 2 string w gatina fiha el textfuild
        String umail=M_Mail.getText();
        String password=M_password.getText();
        //////////
        /////////////ken el umail mt3 admin el kbir y7elo toul el application
        if (umail.equals("Job.tn@gmail.com") && password.equals("Admin"))
        {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                     alert.setTitle("Job tn :: Success Message");
                     alert.setHeaderText(null);
                     alert.setContentText("Bienvenu Admin");
                     alert.showAndWait();
               try {
			Stage stage = (Stage) M_Mail.getScene().getWindow();
                        stage.close();
                        
          Parent root=FXMLLoader.load(getClass().getResource("M_ListAdmin.fxml"));
			Scene scene = new Scene(root,840,600);
		
			stage.setScene(scene);
			stage.show();
                        
		} catch(Exception e) {
			e.printStackTrace();
		}
        }
        ///////////////ken el email wel password mawjoud fel data base y7elo el interface mmt3h 7aseb e role
        else {
            //
            on =  MyDB.getInstance().getConnection();
            String query="select role from utilisateur where email='"+M_Mail.getText()+"' and mdp='"+M_password.getText()+"'"; 
            System.out.println(query);
            PreparedStatement smt = on.prepareStatement(query);
            ResultSet rs= smt.executeQuery();
            String role="";
            while(rs.next())
            {
                role=rs.getString("role");
            }
            
            if (role.equals("candidat")){
               Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                     alert.setTitle("Job TN:: Success Message");
                     alert.setHeaderText(null);
                     alert.setContentText("Vous etes connecté condidat");
                     alert.showAndWait(); 
            }
            else if(role.equals("sociéte"))
            {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                     alert.setTitle("Job TN:: Success Message");
                     alert.setHeaderText(null);
                     alert.setContentText("Vous etes connecté societe");
                     alert.showAndWait(); 
            }
            else if(role.equals("Admin"))
            {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                     alert.setTitle("Job TN:: Success Message");
                     alert.setHeaderText(null);
                     alert.setContentText("Vous etes connecté Administrateur");
                     alert.showAndWait(); 
            }
            else 
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                     alert.setTitle("Job TN:: Error Message");
                     alert.setHeaderText(null);
                     alert.setContentText("Verifier Email et Password");
                     alert.showAndWait(); 
            }
        
        }

            }

    @FXML
    private void MonterPassword(ActionEvent event) {
        if (M_Monterpa.isSelected())
        {
            
             passwordText_M.setText(M_password.getText());
            passwordText_M.setVisible(true);
            M_password.setVisible(false);
            return;
        }
        M_password.setText(passwordText_M.getText());
            M_password.setVisible(true);
            passwordText_M.setVisible(false);
            
    
    }

    @FXML
    private void MonterPassword1(MouseEvent event) {
        
        
    }

    @FXML
    private void M_restorepasswordMethode(ActionEvent event) {
         try {
			Stage stage = (Stage) M_Mail.getScene().getWindow();
                        stage.close();
                        
          Parent root=FXMLLoader.load(getClass().getResource("ForgotPasswordMethode.fxml"));
			Scene scene = new Scene(root,840,600);
		
			stage.setScene(scene);
			stage.show();
                        
		} catch(Exception e) {
			e.printStackTrace();
		}
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        RotateTransition rotate = new RotateTransition();
       /* rotate.setDuration(Duration.millis(1000));
        rotate.setNode(imagedour);
        rotate.setAutoReverse(false);
        rotate.setToAngle(360);
        rotate.setCycleCount(100);
        rotate.play();*/
        rotate.setDuration(Duration.millis(10000));
        rotate.setNode(eclipse);
        rotate.setAutoReverse(false);
        rotate.setToAngle(360);
        rotate.setCycleCount(100);
        rotate.play();
        ScaleTransition scale = new ScaleTransition();
        scale.setNode(imagedour);
        scale.setByY(0.1);
        scale.setByX(0.1);
        scale.setCycleCount(1000);
        scale.setAutoReverse(true);
        scale.play();
        
    }
    
        }
    
             









    

