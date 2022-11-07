/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workbot_jobtn.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import workbot_jobtn.services.OffreService;

/**
 * FXML Controller class
 *
 * @author Administrateur
 */
public class HomeController implements Initializable {

    @FXML
    private Button Home;
    @FXML
    private Button gotooffre;
    @FXML
    private Button N_BMHome1;
    @FXML
    private Button gotocontrats;
    @FXML
    private PieChart tabchart;
    @FXML
    private WebView N_AdsView;
    private WebEngine e;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO Auto-generated method stub  
         e=N_AdsView.getEngine();
         e.load("https://www.profitablegatetocontent.com/d38ziwqqhm?key=833e83d5b619c6162602e331d6104cd1");
        OffreService of=new OffreService();
        tabchart.getData().add(new PieChart.Data("Offres",of.totNbCandOfrre()));
        tabchart.getData().add(new PieChart.Data("Taches ",of.totNbCandbyCandidat()));
        
        // TODO
    }    

  
    @FXML
    private void gotooffre(ActionEvent event) throws IOException {
        Parent page1 = FXMLLoader.load(getClass().getResource("Offre_1.fxml"));
        Scene scene = new Scene(page1);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void candidature_menu(ActionEvent event) throws IOException {
        Parent page1 = FXMLLoader.load(getClass().getResource("CandidatureList.fxml"));
        Scene scene = new Scene(page1);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    private void gotocontact(ActionEvent event) throws IOException {
            Parent page1 = FXMLLoader.load(getClass().getResource("ContratCreation.fxml"));
        Scene scene = new Scene(page1);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
        
        
    }

    @FXML
    private void Home(ActionEvent event) throws IOException {
            Parent page1 = FXMLLoader.load(getClass().getResource("Home.fxml"));
        Scene scene = new Scene(page1);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();   
        
    }

    @FXML
    private void gotocontrats(ActionEvent event) throws IOException {
        Parent page1 = FXMLLoader.load(getClass().getResource("ContratList.fxml"));
        Scene scene = new Scene(page1);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void evennement_menu(ActionEvent event) throws IOException {
        Parent page1 = FXMLLoader.load(getClass().getResource("firstparticip.fxml"));
        Scene scene = new Scene(page1);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void Cours_window(ActionEvent event) throws IOException {
        Parent page1 = FXMLLoader.load(getClass().getResource("N_Home.fxml"));
        Scene scene = new Scene(page1);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void reclam(ActionEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("Y_categorie.fxml"));
            Scene stage = new Scene(root);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(stage);
            window.show();
    }
}
