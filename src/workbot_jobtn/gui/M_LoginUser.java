/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workbot_jobtn.gui;

import java.io.IOException;
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
import javafx.scene.Node;
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
import workbot_jobtn.utils.SessionManager;

/**
 *
 * @author fnmoh
 */
public class M_LoginUser implements Initializable {

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
    private Button M_loginidb;
    @FXML
    private Button m_map;
    @FXML
    private ImageView eclipse2;
    @FXML
    private ImageView eclipse3;
    @FXML
    private ImageView icon1;
    @FXML
    private ImageView icon2;
    @FXML
    private ImageView icon;

    @FXML
    void M_creecompteactionB(ActionEvent event) {

        try {

            Parent root = FXMLLoader.load(getClass().getResource("Captcha.fxml"));

            Scene stage = new Scene(root);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(stage);
            window.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
        /*
        Parent root = FXMLLoader.load(getClass().getResource("M_Signup.fxml"));
        Scene stage=new Scene(root,840,600);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(stage);
        window.show();
         */
    }
    private Connection on;
    private Statement ste;

    @FXML
    private void M_loginidb(ActionEvent event) throws SQLException, IOException {

            
        ////////////5dhena 2 string w gatina fiha el textfuild
        String umail = M_Mail.getText();
        String password = M_password.getText();
        SessionManager.setEmail(umail);

        
        //////////
        /////////////ken el umail mt3 admin el kbir y7elo toul el application
        if (umail.equals("Job.tn@gmail.com") && (password.equals("Admin") || passwordText_M.getText().equals("Admin"))) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Job tn :: Success Message");
            alert.setHeaderText(null);
            alert.setContentText("Bienvenu Admin");
            alert.showAndWait();

            try {

                Parent root = FXMLLoader.load(getClass().getResource("M_ListAdmin.fxml"));

                Scene stage = new Scene(root);
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window.setScene(stage);
                window.show();
            } catch (Exception e) {
                e.printStackTrace();
            }

        } ///////////////ken el email wel password mawjoud fel data base y7elo el interface mmt3h 7aseb e role
        else {
            //
            on = MyDB.getInstance().getConnection();
            String query = "select id,role,nom,prenom,tel,photo,domaine from utilisateur where email='" + M_Mail.getText() + "' and mdp='" + M_password.getText() + "'or mdp='" + passwordText_M.getText() + "'";
            System.out.println(query);
            PreparedStatement smt = on.prepareStatement(query);
            ResultSet rs = smt.executeQuery();
            String role = "";
            int ids = 0;
            String noms = "";
            String prenoms = "";
            String tels = "";
            String photos = "";
            String domaine="";
            while (rs.next()) {
                role = rs.getString("role");
                ids = rs.getInt("id");
                noms = rs.getString("nom");
                prenoms = rs.getString("prenom");
                tels = rs.getString("tel");
                photos = rs.getString("photo");
                 domaine=rs.getString("domaine");
            }
            SessionManager.setId(ids);
            SessionManager.setNom(noms);
            SessionManager.setPhoto(photos);
            SessionManager.setTel(tels);
            SessionManager.setPrenom(prenoms);
            SessionManager.setDomaine(domaine);

            System.out.println(SessionManager.getId() + " "
                    + SessionManager.getNom() + " "
                    + SessionManager.getPhoto() + " "
                    + SessionManager.getTel() + " "
                    + SessionManager.getPrenom()+" "
                    + SessionManager.getDomaine());

            if (role.equals("candidat")) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Job TN:: Success Message");
                alert.setHeaderText(null);
                alert.setContentText("Vous etes connecté condidat");
                alert.showAndWait();
                SessionManager.setRole("candidat");
                    
            } else if (role.equals("sociéte")) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Job TN:: Success Message");
                alert.setHeaderText(null);
                alert.setContentText("Vous etes connecté societe");
                alert.showAndWait();
                SessionManager.setRole("sociéte");
                    Parent root = FXMLLoader.load(getClass().getResource("HomeSociete.fxml"));
                    Scene stage = new Scene(root);
                    Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    window.setScene(stage);
                    window.show();
            } else if (role.equals("Admin")) {
                SessionManager.setRole("Admin");
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Job TN:: Success Message");
                alert.setHeaderText(null);
                alert.setContentText("Vous etes connecté Administrateur");
                alert.showAndWait();

                try {

                    Parent root = FXMLLoader.load(getClass().getResource("M_ListAdmin.fxml"));

                    Scene stage = new Scene(root);
                    Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    window.setScene(stage);
                    window.show();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Job TN:: Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Verifier Email et Password");
                alert.showAndWait();
            }

        }
        System.out.println(SessionManager.getRole());
        
 
    }

    @FXML
    private void MonterPassword(ActionEvent event) {
        if (M_Monterpa.isSelected()) {

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
    private void M_restorepasswordMethode(ActionEvent event) {

        try {

            Parent root = FXMLLoader.load(getClass().getResource("ForgotPasswordMethode.fxml"));

            Scene stage = new Scene(root);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(stage);
            window.show();
        } catch (Exception e) {
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
        eclipse2();
        eclipse3();
        icon1();
        icon();
        icon2();
        rotate.setDuration(Duration.millis(10000));
        rotate.setNode(eclipse);
        rotate.setAutoReverse(false);
        rotate.setToAngle(360);
        rotate.setCycleCount(100);
        rotate.play();

        ScaleTransition scale = new ScaleTransition();
        scale.setNode(imagedour);
        scale.setByY(0.06);
        scale.setByX(0.06);
        scale.setCycleCount(1000);
        scale.setAutoReverse(true);
        scale.play();

    }

    public void eclipse2() {
        RotateTransition rotate = new RotateTransition();
        rotate.setDuration(Duration.millis(10000));
        rotate.setNode(eclipse2);
        rotate.setAutoReverse(false);
        rotate.setToAngle(360);
        rotate.setCycleCount(100);
        rotate.play();
    }

    public void eclipse3() {
        RotateTransition rotate = new RotateTransition();
        rotate.setDuration(Duration.millis(10000));
        rotate.setNode(eclipse3);
        rotate.setAutoReverse(false);
        rotate.setToAngle(360);
        rotate.setCycleCount(100);
        rotate.play();
    }

    public void icon1() {
        ScaleTransition scale = new ScaleTransition();
        scale.setNode(icon1);
        scale.setByY(0.02);
        scale.setByX(0.02);
        scale.setCycleCount(1000);
        scale.setAutoReverse(true);
        scale.play();
    }

    public void icon2() {
        ScaleTransition scale = new ScaleTransition();
        scale.setNode(icon2);
        scale.setByY(0.02);
        scale.setByX(0.02);
        scale.setCycleCount(1000);
        scale.setAutoReverse(true);
        scale.play();
    }

    public void icon() {
        ScaleTransition scale = new ScaleTransition();
        scale.setNode(icon);
        scale.setByY(0.02);
        scale.setByX(0.02);
        scale.setCycleCount(1000);
        scale.setAutoReverse(true);
        scale.play();
    }

    @FXML
    private void MonterPassword1(MouseEvent event) {
    }

    @FXML
    private void m_map(ActionEvent event) {
        try {
            Stage stage=new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("mappa.fxml"));
            Scene scene = new Scene(root, 900, 550);

            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
