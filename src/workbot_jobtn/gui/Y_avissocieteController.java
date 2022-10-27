/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workbot_jobtn.gui;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import workbot_jobtn.entites.*;
import workbot_jobtn.services.ServiceCategorie;
import workbot_jobtn.services.ServiceReclamationAvis;

/**
 * FXML Controller class
 *
 * @author youcef
 */
public class Y_avissocieteController implements Initializable {
    ServiceCategorie serv=new ServiceCategorie();
    ServiceReclamationAvis serv2=new ServiceReclamationAvis();
    DTOavis_societe dtoavis= new DTOavis_societe();
    DTOavis_societe dtoavis1=new DTOavis_societe();
    ReclamationAvis avis= new ReclamationAvis();
    ReclamationAvis avis1=new ReclamationAvis();
    int id=2;
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextArea tf_avis;
    @FXML
    private TextField tf_note;
    @FXML
    private Label tf_societe;
    @FXML
    private TextField tf_recherche;
    @FXML
    private ImageView recherchericon;
    @FXML
    private ImageView retouricon;
    @FXML
    private ImageView retour1icon;
    @FXML
    private TableColumn<DTOavis_societe, String> col_societe;
    @FXML
    private TableColumn<DTOavis_societe, Integer> col_notmoy;
    @FXML
    private TableColumn<DTOavis_societe, Integer> col_note;
    @FXML
    private TableColumn<DTOavis_societe, String> col_avis;
    @FXML
    private TableView<DTOavis_societe> table_avis;
    private final ObservableList<DTOavis_societe> list = FXCollections.observableArrayList();
    @FXML
    private Button envoyer;
    @FXML
    private Button supprimer;
    @FXML
    private Button modifier;
    @FXML
    private Button annuler;
    @FXML
    private Pane lb_confirmer_envoyer;
    @FXML
    private Pane envoyer_confirmation;
    @FXML
    private Pane lb_confirmer_modifier;
    @FXML
    private Pane lb_confirmer_supprimer;
    @FXML
    private Pane modifier_confirmation;
    @FXML
    private Pane supprimer_confirmation;
    @FXML
    private Label champ_obligatoire;
    @FXML
    private Label note_obligatoire;
    @FXML
    private Label societe_obligatoire;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        showReclamations();
    }    
    
    public void showReclamations(){
        
        try {
            list.clear();
            ObservableList<DTOavis_societe> liste = serv2.afficherToutAvisSociete(id);//we statically set the client id to just show his reclamations
            list.setAll(liste);
            
            
            col_societe.setCellValueFactory(new PropertyValueFactory<DTOavis_societe, String>("nom"));
            col_notmoy.setCellValueFactory(new PropertyValueFactory<DTOavis_societe, Integer>("note_moy"));
            col_note.setCellValueFactory(new PropertyValueFactory<DTOavis_societe, Integer>("note"));
            col_avis.setCellValueFactory(new PropertyValueFactory<DTOavis_societe, String>("desc"));
            
            table_avis.setItems(list);
        } catch (SQLException ex) {
        }
        
    }


    @FXML
    private void envoyer_avis(ActionEvent event) throws SQLException {
        if(tf_societe.getText().equals("")){
            societe_obligatoire.setVisible(true);
        }
        else{
            societe_obligatoire.setVisible(false);
        
        Categorie av=serv.afficher(11);        
        avis1.setCategorie(av);
        avis1.setDescription(tf_avis.getText());
        avis1.setNote(Integer.parseInt(tf_note.getText()));
        avis1.setSociete(serv2.afficheruser2(tf_societe.getText()));
        avis1.setUser(serv2.afficheruser1(id));
        if(tf_note.getText().equals("")){
            note_obligatoire.setVisible(true);
            champ_obligatoire.setVisible(true);
        }
            
        
        else{
            note_obligatoire.setVisible(false);
            champ_obligatoire.setVisible(false);
            lb_confirmer_envoyer.setVisible(true);
        }
        }

    }

    @FXML
    private void modifier_avis(ActionEvent event) throws SQLException {
        Categorie av=serv.afficher(11);        
        avis.setCategorie(av);
        avis.setDescription(tf_avis.getText());
        avis.setNote(Integer.parseInt(tf_note.getText()));
        avis.setSociete(serv2.afficheruser2(tf_societe.getText()));
        avis.setUser(serv2.afficheruser1(id));
        if(tf_note.getText().equals("")){
            note_obligatoire.setVisible(true);
            champ_obligatoire.setVisible(true);
        }
            
        
        else{
            note_obligatoire.setVisible(false);
            champ_obligatoire.setVisible(false);
            lb_confirmer_modifier.setVisible(true);
        }
    }

    @FXML
    private void anuler_edit(ActionEvent event) {
        tf_societe.setText("");
        tf_avis.setText("");
        tf_note.setText("");
        modifier.setVisible(false);
        annuler.setVisible(false);
        supprimer.setVisible(false);
        dtoavis=null;
    }

    @FXML
    private void rechercher(ActionEvent event) throws SQLException {
        list.clear();
            dtoavis= serv2.afficherAvisSociete(tf_recherche.getText(),id);//we statically set the client id to just show his reclamations
            list.setAll(dtoavis);
            
            
            col_societe.setCellValueFactory(new PropertyValueFactory<DTOavis_societe, String>("nom"));
            col_notmoy.setCellValueFactory(new PropertyValueFactory<DTOavis_societe, Integer>("note_moy"));
            col_note.setCellValueFactory(new PropertyValueFactory<DTOavis_societe, Integer>("note"));
            col_avis.setCellValueFactory(new PropertyValueFactory<DTOavis_societe, String>("desc"));
            
            table_avis.setItems(list);
            retouricon.setVisible(true);
            dtoavis=null;
            tf_societe.setText("");
            tf_avis.setText("");
            tf_note.setText("");
    }

    @FXML
    private void recherchericon(MouseEvent event) throws SQLException {
        list.clear();
            dtoavis= serv2.afficherAvisSociete(tf_recherche.getText(),id);//we statically set the client id to just show his reclamations
            list.setAll(dtoavis);
            
            
            col_societe.setCellValueFactory(new PropertyValueFactory<DTOavis_societe, String>("nom"));
            col_notmoy.setCellValueFactory(new PropertyValueFactory<DTOavis_societe, Integer>("note_moy"));
            col_note.setCellValueFactory(new PropertyValueFactory<DTOavis_societe, Integer>("note"));
            col_avis.setCellValueFactory(new PropertyValueFactory<DTOavis_societe, String>("desc"));
            
            table_avis.setItems(list);
            retouricon.setVisible(true);
            dtoavis=null;
            tf_societe.setText("");
            tf_avis.setText("");
            tf_note.setText("");
    }

    @FXML
    private void retouricon(MouseEvent event) {
        showReclamations();
        retouricon.setVisible(false);
        tf_recherche.setText("");
    }

    @FXML
    private void supprimer_avis(ActionEvent event) throws SQLException {
        Categorie av=serv.afficher(11);        
        avis.setCategorie(av);
        avis.setDescription(tf_avis.getText());
        avis.setNote(Integer.parseInt(tf_note.getText()));
        avis.setSociete(serv2.afficheruser2(tf_societe.getText()));
        avis.setUser(serv2.afficheruser1(id));
        lb_confirmer_supprimer.setVisible(true);
    }

    @FXML
    private void retour1icon(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("y_categorie.fxml"));
  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
  scene = new Scene(root);
  stage.setScene(scene);
  stage.show();
    }

    @FXML
    private void lineselected(MouseEvent event) {
        if(table_avis.getSelectionModel().getSelectedIndex()>=0){
        dtoavis = table_avis.getItems().get(table_avis.getSelectionModel().getSelectedIndex());
        tf_societe.setText(dtoavis.getNom());
        tf_avis.setText(dtoavis.getDesc());
        tf_note.setText(String.valueOf(dtoavis.getNote()));
        
        if(dtoavis.getNote()!=0){
            modifier.setVisible(true);
        annuler.setVisible(true);
        supprimer.setVisible(true);
        }
        } 
    }

    @FXML
    private void oui_envoyer(ActionEvent event) throws SQLException {
        serv2.ajouterAvis(avis1);
        showReclamations();
        tf_societe.setText("");
        tf_avis.setText("");
        tf_note.setText("");
        lb_confirmer_envoyer.setVisible(false);
        envoyer_confirmation.setVisible(true);
    }

    @FXML
    private void non_envoyer(ActionEvent event) {
        lb_confirmer_envoyer.setVisible(false);
    }

    @FXML
    private void fermer_confirmation_envoyer(ActionEvent event) {
        envoyer_confirmation.setVisible(false);
    }

    @FXML
    private void oui_modifier(ActionEvent event) throws SQLException {
        serv2.modifierAvis(avis);
        showReclamations();
        avis=null;
        tf_societe.setText("");
        tf_avis.setText("");
        tf_note.setText("");
        modifier.setVisible(false);
        annuler.setVisible(false);
        supprimer.setVisible(false);
        lb_confirmer_modifier.setVisible(false);
        modifier_confirmation.setVisible(true);
    }

    @FXML
    private void non_modifier(ActionEvent event) {
        lb_confirmer_modifier.setVisible(false);
    }

    @FXML
    private void oui_supprimer(ActionEvent event) throws SQLException {
        serv2.supprimerAvis(avis);
        showReclamations();
        avis=null;
        tf_societe.setText("");
        tf_avis.setText("");
        tf_note.setText("");
        lb_confirmer_supprimer.setVisible(false);
        supprimer_confirmation.setVisible(true);
    }

    @FXML
    private void non_supprimer(ActionEvent event) {
        lb_confirmer_supprimer.setVisible(false);
    }

    @FXML
    private void fermer_confirmation_modifier(ActionEvent event) {
        modifier_confirmation.setVisible(false);
    }

    @FXML
    private void fermer_confirmation_supprimer(ActionEvent event) {
        supprimer_confirmation.setVisible(false);
        
    }
    
}