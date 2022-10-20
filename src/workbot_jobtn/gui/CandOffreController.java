/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package workbot_jobtn.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
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
import javafx.util.Callback;
import workbot_jobtn.entites.DTOCandidature_Offre;
import workbot_jobtn.services.OffreService;

/**
 * FXML Controller class
 *
 * @author Exon
 */
public class CandOffreController implements Initializable {

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
    private Button fb;
    @FXML
    private Button fb1;
    @FXML
    private Button fb2;
    @FXML
    private Pane s;
    @FXML
    private TextField inputsearch;
    @FXML
    private Button btnUser;
    @FXML
    private Button settings;
     @FXML
    private TableView<DTOCandidature_Offre> table;
    @FXML
    private TableColumn<DTOCandidature_Offre, String> NomCand;
    @FXML
    private TableColumn<DTOCandidature_Offre, String> emailCand;
    @FXML
    private TableColumn<DTOCandidature_Offre, String> NoteTest;
    @FXML
    private TableColumn<DTOCandidature_Offre, String> actionTest;
    @FXML
    private TableColumn<DTOCandidature_Offre, String> statut;
    @FXML
    private TableColumn<DTOCandidature_Offre, String> actionStatut;
    @FXML
    private TableColumn<DTOCandidature_Offre, String> dateAjout;
    @FXML
    private Button btnAjouter;
    @FXML
    private Button btnSupp;
    @FXML
    private Label offreLab;
    
        OffreService offreService= new OffreService();
    int id_passed;

//     int idOff=Integer.parseInt(offreLab.getText());
             

       public void setId_offre(int id){
     
     ObservableList<DTOCandidature_Offre> list = offreService.candidatures_Offre(id);

           displaytabview(list);
}
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }      
    
    public void displaytabview(ObservableList<DTOCandidature_Offre> list ){
       NomCand.setCellValueFactory(new PropertyValueFactory<>("nomCandidat"));
       emailCand.setCellValueFactory(new PropertyValueFactory<>("email"));
       NoteTest.setCellValueFactory(new PropertyValueFactory<>("noteTest"));
              actionTest.setCellValueFactory(new PropertyValueFactory<>("button"));
       statut.setCellValueFactory(new PropertyValueFactory<>("statut"));
              actionStatut.setCellValueFactory(new PropertyValueFactory<>("button"));
                     dateAjout.setCellValueFactory(new PropertyValueFactory<>("dateAjout"));


      // nbTab.setCellValueFactory(new PropertyValueFactory<Offre,String>("dateAjout"));
     
           Callback<TableColumn<DTOCandidature_Offre, String>, TableCell<DTOCandidature_Offre, String>> cellFactory
                =                 //
       (final TableColumn<DTOCandidature_Offre, String> param) -> {
           final TableCell<DTOCandidature_Offre, String> cell = new TableCell<DTOCandidature_Offre, String>() {
               
               final Button btn = new Button("Noter");
               
               @Override
               public void updateItem(String item, boolean empty) {
                   super.updateItem(item, empty);
                   if (empty) {
                       setGraphic(null);
                       setText(null);
                   } else {
                       btn.setOnAction(event -> {
                           DTOCandidature_Offre Offre = getTableView().getItems().get(getIndex());
                           
                       });
                       setGraphic(btn);
                       setText(null);
                   }
               }
           };
           return cell;
       };
              actionTest.setCellFactory(cellFactory);
              
              
                        Callback<TableColumn<DTOCandidature_Offre, String>, TableCell<DTOCandidature_Offre, String>> cellFactory2
                =                 //
       (final TableColumn<DTOCandidature_Offre, String> param) -> {
           final TableCell<DTOCandidature_Offre, String> cell = new TableCell<DTOCandidature_Offre, String>() {
               
               final Button btn = new Button("Changer");
               
               @Override
               public void updateItem(String item, boolean empty) {
                   super.updateItem(item, empty);
                   if (empty) {
                       setGraphic(null);
                       setText(null);
                   } else {
                       btn.setOnAction(event -> {
                           DTOCandidature_Offre Offre = getTableView().getItems().get(getIndex());
                           
                       });
                       setGraphic(btn);
                       setText(null);
                   }
               }
           };
           return cell;
       };
              actionStatut.setCellFactory(cellFactory2);

      
        FilteredList<DTOCandidature_Offre> filteredList = new FilteredList<>(list, b -> true);
        
        inputsearch.textProperty().addListener((observable, oldValue, newValue) ->{
            filteredList.setPredicate(Offre -> {
                   if(newValue == null ||  newValue.isEmpty()) return true;
         String lowerCaseFilter = newValue.toLowerCase(); 
         if(       Offre.getNomCandidat().toLowerCase().contains(lowerCaseFilter)) return true;
         else return false;
            });
    });
        
        SortedList<DTOCandidature_Offre> sortedList = new SortedList<>(filteredList);
        sortedList.comparatorProperty().bind(table.comparatorProperty());
        
        table.setItems(sortedList);
        // TODO
    }

    @FXML
    private void onclick_dash(ActionEvent event)throws IOException{
                Parent fXMLLoader = FXMLLoader.load(getClass().getResource("HomeSociete.fxml"));
        Scene stage=new Scene(fXMLLoader);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(stage);
        window.show();
    }

    @FXML
    private void onClicked_menuOffre(ActionEvent event) throws IOException{
               Parent fXMLLoader = FXMLLoader.load(getClass().getResource("Offre.fxml"));
        Scene stage=new Scene(fXMLLoader);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(stage);
        window.show();
    }

    @FXML
    private void OnClicked_menuEvent(ActionEvent event) {
    }

    @FXML
    private void OnClicked_menuEntretiens(ActionEvent event) {
    }

    @FXML
    private void Onclicked_fb(ActionEvent event) {
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
    private void AjouterOffre(ActionEvent event) {
    }

    @FXML
    private void supprimerOffre(ActionEvent event) {
    }
      
 
}
