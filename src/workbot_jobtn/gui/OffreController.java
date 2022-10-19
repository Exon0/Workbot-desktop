/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package workbot_jobtn.gui;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import workbot_jobtn.entites.Offre;
import workbot_jobtn.services.OffreService;

/**
 * FXML Controller class
 *
 * @author Exon
 */
public class OffreController implements Initializable {

    @FXML
    private HBox root;
    @FXML
    private VBox menu;
    @FXML
    private AnchorPane side_anker;
    @FXML
    private Button btnDashboard;
    @FXML
    private Button btnMenuOffre;
    @FXML
    private Button btnMenuEvent;
    @FXML
    private Button btnMenuEntretien;
    @FXML
    private Pane s;
    @FXML
    private TextField inputsearch;
    @FXML
    private Button btnUser;
    @FXML
    private Button settings;
    @FXML
    private TableView<Offre> table;
    @FXML
    private TableColumn<Offre, String> OffreTab;
    @FXML
    private TableColumn<Offre, String> dateTab;
    @FXML
    private TableColumn<Offre, String> typeTab;
    @FXML
    private TableColumn<Offre, String> totCandTab;
    @FXML
    private TableColumn<Offre,Button> btnsTab;
    
      OffreService offreService= new OffreService();
    
    ObservableList<Offre> list = FXCollections.observableArrayList(offreService.readAll());
    @FXML
    private Button btnAjouter;
    @FXML
    private Button btnModif;
    @FXML
    private Button btnSupp;
    @FXML
    private Button fb;
    @FXML
    private Button fb1;
    @FXML
    private Button fb2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
       OffreTab.setCellValueFactory(new PropertyValueFactory<>("titre"));
       dateTab.setCellValueFactory(new PropertyValueFactory<>("domaine"));
       typeTab.setCellValueFactory(new PropertyValueFactory<>("modeTravail"));
      // nbTab.setCellValueFactory(new PropertyValueFactory<Offre,String>("titre"));
     
        FilteredList<Offre> filteredList = new FilteredList<>(list, b -> true);
        
        inputsearch.textProperty().addListener((observable, oldValue, newValue) ->{
            filteredList.setPredicate(Offre -> {
                   if(newValue == null ||  newValue.isEmpty()) return true;
         String lowerCaseFilter = newValue.toLowerCase(); 
         if(       Offre.getTitre().toLowerCase().contains(lowerCaseFilter)) return true;
         else return false;
            });
    });
        
        SortedList<Offre> sortedList = new SortedList<>(filteredList);
        sortedList.comparatorProperty().bind(table.comparatorProperty());
        
        table.setItems(sortedList);
    }    

    @FXML
    private void onClicked_menuOffre(ActionEvent event) {
    }

    @FXML
    private void OnClicked_menuEvent(ActionEvent event) {
    }

    @FXML
    private void OnClicked_menuEntretiens(ActionEvent event) {
    }

    @FXML
    private void onKeyRealeased_showSearchPropositions(KeyEvent event) {
    }

    @FXML
    private void OnClick_UserIcon(ActionEvent event) {
    }

    @FXML
    private void OnClick_settings(ActionEvent event) {
    }

    @FXML
    private void AjouterOffre(ActionEvent event) throws IOException {
             Parent fXMLLoader = FXMLLoader.load(getClass().getResource("AjouterOffre.fxml"));
        Scene stage=new Scene(fXMLLoader);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(stage);
        window.show();
    }

    @FXML
    private void modifierOffre(ActionEvent event) {
    }
    
    
    @FXML
    private void supprimerOffre(ActionEvent event) {
         Alert Atc=new Alert(Alert.AlertType.CONFIRMATION);
            Atc.setHeaderText("Alert");
            Atc.setContentText("Confirmerla suppression");
           Optional<ButtonType> result= Atc.showAndWait();
               if(result.get()== ButtonType.OK){
        ObservableList<Offre> offreSelected=table.getSelectionModel().getSelectedItems();
        offreService.delete(offreSelected.get(0));
            ObservableList<Offre> list = FXCollections.observableArrayList(offreService.readAll());
    OffreTab.setCellValueFactory(new PropertyValueFactory<>("titre"));
       dateTab.setCellValueFactory(new PropertyValueFactory<>("domaine"));
       typeTab.setCellValueFactory(new PropertyValueFactory<>("modeTravail"));
      // nbTab.setCellValueFactory(new PropertyValueFactory<Offre,String>("titre"));
     
        FilteredList<Offre> filteredList = new FilteredList<>(list, b -> true);
        
        inputsearch.textProperty().addListener((observable, oldValue, newValue) ->{
            filteredList.setPredicate(Offre -> {
                   if(newValue == null ||  newValue.isEmpty()) return true;
         String lowerCaseFilter = newValue.toLowerCase(); 
         if(       Offre.getTitre().toLowerCase().contains(lowerCaseFilter)) return true;
         else return false;
            });
    });
        
        SortedList<Offre> sortedList = new SortedList<>(filteredList);
        sortedList.comparatorProperty().bind(table.comparatorProperty());
        
        table.setItems(sortedList);
               }
               else
                   Atc.close();
        
    }



    @FXML
    private void onclick_dash(ActionEvent event) throws IOException {
              Parent fXMLLoader = FXMLLoader.load(getClass().getResource("HomeSociete.fxml"));
        Scene stage=new Scene(fXMLLoader);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(stage);
        window.show();
    }

    @FXML
    private void Onclicked_fb(ActionEvent event) {
    }
    
}
