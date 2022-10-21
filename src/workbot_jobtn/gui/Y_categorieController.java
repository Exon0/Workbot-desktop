/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package workbot_jobtn.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import workbot_jobtn.entites.Categorie;
import workbot_jobtn.entites.NomCategorie;
import static workbot_jobtn.entites.NomCategorie.Avis;
import static workbot_jobtn.entites.NomCategorie.Reclamation;
import workbot_jobtn.entites.ReclamationAvis;
import workbot_jobtn.services.ServiceReclamationAvis;



/**
 * FXML Controller class
 *
 * @author youcef
 */
public class Y_categorieController implements Initializable {
 private Stage stage;
 private Scene scene;
 private Parent root;
 int x=0;
  
        
    @FXML
    private ToggleGroup categorie;

    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    
        
    @FXML
    private RadioButton avis;
    @FXML
    private RadioButton reclamation;
    
   @FXML
    private void getcategorie(ActionEvent event) {
        if(avis.isSelected()){x=1;}
        if(reclamation.isSelected()) {x=2;}
    }

    @FXML
    private void continuer(ActionEvent event) throws IOException {
       
      if(x==2){
  root = FXMLLoader.load(getClass().getResource("y_reclamationtechnique.fxml"));
  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
  scene = new Scene(root);
  stage.setScene(scene);
  stage.show();
      }
      
 
        }

    
        
    }
    
