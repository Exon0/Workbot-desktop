/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workbot_jobtn.gui;

import workbot_jobtn.services.CondidatureService;
import workbot_jobtn.services.ContratService;
import workbot_jobtn.entites.Candidature;
import workbot_jobtn.entites.Contrat;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author Administrateur
 */
public class ContratCreationController implements Initializable {
private Label label;
    @FXML
    private DatePicker datedebut;
    @FXML
    private DatePicker debutfin;
    @FXML
    private ComboBox<String> inputtypecontrat;
    @FXML
    private TextField inputsalaire;
    @FXML
    private TextField inputlien;
    @FXML
    private Button ajouter;
    @FXML
    private Hyperlink prec;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        inputtypecontrat.getItems().addAll("Stage", "Alternance", "CDD", "CDI");

    }

    @FXML
    private void insert(ActionEvent event) throws IOException, SQLException {
        ContratService productService = new ContratService();
 System.out.println(inputsalaire.getText().matches("[0-9.]"));

        if (inputsalaire.getText().equals("")) {
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setContentText("Veuillez saisir tous les champs ");
            a.setHeaderText(null);
            a.showAndWait();
        } 
        
        else if(!inputsalaire.getText().matches("[0-9.]+")==true) {
            
                    Alert a = new Alert(Alert.AlertType.WARNING);
            a.setContentText("le salaire doit etre un nombre ");
            a.setHeaderText(null);
            a.showAndWait();
            
        }
        else {
            // Date Ajourd'hui
            Date date = new Date(System.currentTimeMillis());
            java.sql.Date sqlDate2 = new java.sql.Date(date.getTime());

            //date debut 
            java.util.Date date2 = java.util.Date.from(this.datedebut.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
            java.sql.Date sqlDatedebut = new java.sql.Date(date2.getTime());

            //date fin
            java.util.Date date3 = java.util.Date.from(this.debutfin.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
            java.sql.Date sqlDateFin = new java.sql.Date(date3.getTime());

            Contrat ccc = new Contrat(inputtypecontrat.getValue(), sqlDatedebut, inputsalaire.getText(),
                    sqlDateFin, inputlien.getText(), 0, sqlDate2
            );

            
            
               Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
      alert.setTitle("Confirmer ");
      alert.setHeaderText("Confirmer");
      alert.setContentText(" ");
            Optional<ButtonType> option = alert.showAndWait();

      if (option.get() == null) {
       
      } else if (option.get() == ButtonType.OK) {
          productService.AjouterContrat(ccc);
          
                TrayNotification tray = new TrayNotification();
            AnimationType type = AnimationType.SLIDE;
            tray.setAnimationType(type);
            tray.setTitle("Contrat ajouté avec succées");
            tray.setMessage("Contrat ajouté avec succées");
            tray.setNotificationType(NotificationType.SUCCESS);
            tray.showAndDismiss(Duration.millis(3000));
          
            Parent page1 = FXMLLoader.load(getClass().getResource("ContratList.fxml"));
            Scene scene = new Scene(page1);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
       
      } else if (option.get() == ButtonType.CANCEL) {
      
      } else {
         this.label.setText("-");
      }
            
            
            
            
            

          

        };

    }

    @FXML
    private void prec(ActionEvent event) throws IOException {
        
               Parent page1 = FXMLLoader.load(getClass().getResource("ContratList.fxml"));
        Scene scene = new Scene(page1);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
        
    }

}
