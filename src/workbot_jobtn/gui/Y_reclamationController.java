/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package workbot_jobtn.gui;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import javafx.scene.control.DatePicker;
import java.time.LocalDate;
import java.sql.SQLException;
import java.util.List;
import javafx.scene.input.MouseEvent;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import workbot_jobtn.entites.*;
import workbot_jobtn.services.*;

/**
 * FXML Controller class
 *
 * @author youcef
 */
public class Y_reclamationController  implements Initializable {
    ServiceCategorie serv=new ServiceCategorie();
    ServiceReclamation serv2=new ServiceReclamation();
    Reclamation rec= new Reclamation();
    Reclamation rec1=new Reclamation();
    private Stage stage;
    private Scene scene;
    private Parent root;
    

            
            
            
    
    @FXML
    private TextField objet;
    @FXML
    private TextArea description;
    private final ObservableList<Reclamation> list = FXCollections.observableArrayList();
    @FXML
    private TableView<Reclamation> table_reclamation;
    @FXML
    private TableColumn<Reclamation, String> col_objet;
    @FXML
    private TableColumn<Reclamation, String> col_date;
    @FXML
    private TableColumn<Reclamation, String> col_description;
    @FXML
    private TableColumn<Reclamation, Integer> col_id;
    @FXML
    private TableColumn<Reclamation, String> col_categorie;
    @FXML
    private TableColumn<Reclamation, String> col_etat;
    @FXML
    private TextField tf_recherche;
    @FXML
    private ImageView recherchericon;
    @FXML
    private ImageView retouricon;
    @FXML
    private Button modifier;
    @FXML
    private Button annuler;
    @FXML
    private Button supprimer;
    @FXML
    private TextField tf_image;
    @FXML
    private ImageView iv_image;
    @FXML
    private Button button_upload;
    @FXML
    private TableColumn<Reclamation, String> col_image;
    @FXML
    private Label champ_obligatoire;
    @FXML
    private Label objet_obligatoire;
    @FXML
    private Label description_obligatoire;
    @FXML
    private Pane lb_confirmer_envoyer;
    @FXML
    private Pane lb_confirmer_supprimer;
    @FXML
    private Pane lb_confirmer_modifier;
    @FXML
    private Pane supprimer_confirmation;
    @FXML
    private Pane envoyer_confirmation;
    @FXML
    private Pane modifier_confirmation;
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
            ObservableList<Reclamation> liste = serv2.afficherTout();//we statically set the client id to just show his reclamations
            list.setAll(liste);
            
            
            col_date.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("date"));
            col_id.setCellValueFactory(new PropertyValueFactory<Reclamation, Integer>("id"));
            col_objet.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("objet"));
            col_description.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("description"));
            col_image.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("image"));
            col_categorie.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("categorie"));
            col_etat.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("etat"));
            
            table_reclamation.setItems(list);
        } catch (SQLException ex) {
        }
        
    }

    @FXML
    private void envoyer(ActionEvent event) throws SQLException {
        Categorie reclamation=serv.afficher(11);        
        User client=serv2.afficherUser(6);
        rec1.setUser(client);
        rec1.setCategorie(reclamation);
        rec1.setObjet(objet.getText());
        rec1.setDescription(description.getText());
        
        if(tf_image.getText()==null || tf_image.getText().equals("")){
            rec1.setImage("");}
        else{
            File file = new File(tf_image.getText());
            rec1.setImage(file.toURI().toString());
        }
        if(objet.getText().equals("")){
            objet_obligatoire.setVisible(true);
        }
        else{objet_obligatoire.setVisible(false);}
        
        if(description.getText().equals("")){
            description_obligatoire.setVisible(true);
        }
        else{description_obligatoire.setVisible(false);}
        if(objet.getText().equals("") || description.getText().equals("")){
            champ_obligatoire.setVisible(true);
        }
        else{
            champ_obligatoire.setVisible(false);
            lb_confirmer_envoyer.setVisible(true);
            
        }
        
    }

   

    @FXML
    private void supprimer(ActionEvent event) throws SQLException {
        lb_confirmer_supprimer.setVisible(true);
    }
    

   

    @FXML
    private void modifier(ActionEvent event) throws SQLException {
        
        rec.setObjet(objet.getText());
        rec.setDescription(description.getText());
        
        if(tf_image.getText()==null || tf_image.getText().equals("")){
            rec.setImage("");}
        else{
            File file = new File(tf_image.getText());
            rec.setImage(file.toURI().toString());
        }
        lb_confirmer_modifier.setVisible(true);
        
    }

    @FXML
    private void lineselected(MouseEvent event) {
        if(table_reclamation.getSelectionModel().getSelectedIndex()>=0){
        rec = table_reclamation.getItems().get(table_reclamation.getSelectionModel().getSelectedIndex());
        objet.setText(rec.getObjet());
        description.setText(rec.getDescription());
        modifier.setVisible(true);
        annuler.setVisible(true);
        supprimer.setVisible(true);
        tf_image.setText(rec.getImage());
        if(rec.getImage()!=null && !rec.getImage().equals(""))
        {
        Image image = new Image(rec.getImage());
        iv_image.setImage(image);
        }
        else{
            iv_image.setImage(null);
            }
        }
    }

   

    @FXML
    private void rechercher(ActionEvent event) throws SQLException {
        list.clear();
            rec = serv2.afficher(Integer.parseInt(tf_recherche.getText()));//we statically set the client id to just show his reclamations
            list.setAll(rec);
            
            
            col_date.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("date"));
            col_id.setCellValueFactory(new PropertyValueFactory<Reclamation, Integer>("id"));
            col_objet.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("objet"));
            col_description.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("description"));
            table_reclamation.setItems(list);
            retouricon.setVisible(true);
            rec=null;
            objet.setText("");
            description.setText("");
            tf_image.setText("");
            iv_image.setImage(null);
    }

    @FXML
    private void recherchericon(MouseEvent event) throws SQLException {
        list.clear();
            rec = serv2.afficher(Integer.parseInt(tf_recherche.getText()));//we statically set the client id to just show his reclamations
            list.setAll(rec);
            
            
            col_date.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("date"));
            col_id.setCellValueFactory(new PropertyValueFactory<Reclamation, Integer>("id"));
            col_objet.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("objet"));
            col_description.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("description"));
            
            table_reclamation.setItems(list);
            retouricon.setVisible(true);
            rec=null;
            objet.setText("");
            description.setText("");
            tf_image.setText("");
            iv_image.setImage(null);
    }

    @FXML
    private void retouricon(MouseEvent event) {
        showReclamations();
        retouricon.setVisible(false);
        tf_recherche.setText("");
    }


     {
    }

    @FXML
    private void annuler(ActionEvent event) {
        objet.setText("");
        description.setText("");
        tf_image.setText("");
        iv_image.setImage(null);
        modifier.setVisible(false);
        annuler.setVisible(false);
        supprimer.setVisible(false);
        rec=null;
        iv_image.setImage(null);
    }

    @FXML
    private void upload(ActionEvent event) {
        
        FileChooser fc = new FileChooser();
        try{
        String path = fc.showOpenDialog(button_upload.getScene().getWindow()).getPath();
        
        tf_image.setText(path);
        File file = new File(tf_image.getText());
        Image image = new Image(file.toURI().toString());
        iv_image.setImage(image);
        }
        catch(Exception ex){}
    }

    @FXML
    private void oui_envoyer(ActionEvent event) throws SQLException {
        serv2.ajouter(rec1);
        showReclamations();
        objet.setText("");
        description.setText("");
        tf_image.setText("");
        iv_image.setImage(null);
        lb_confirmer_envoyer.setVisible(false);
        envoyer_confirmation.setVisible(true);
        
    }

    @FXML
    private void non_envoyer(ActionEvent event) {
        lb_confirmer_envoyer.setVisible(false);
    }

    @FXML
    private void oui_supprimer(ActionEvent event) throws SQLException {
        serv2.supprimer(rec);
        rec=null;
        showReclamations();
        objet.setText("");
        description.setText("");
        tf_image.setText("");
        iv_image.setImage(null);
        modifier.setVisible(false);
        annuler.setVisible(false);
        supprimer.setVisible(false);
        lb_confirmer_supprimer.setVisible(false);
        supprimer_confirmation.setVisible(true);
    }

    @FXML
    private void non_supprimer(ActionEvent event) {
        lb_confirmer_supprimer.setVisible(false);
        
    }

    @FXML
    private void oui_modifier(ActionEvent event) throws SQLException {
        serv2.modifier(rec);
        objet.setText("");
        description.setText("");
        tf_image.setText("");
        iv_image.setImage(null);
        modifier.setVisible(false);
        annuler.setVisible(false);
        supprimer.setVisible(false);
        rec=null;
        showReclamations();
        lb_confirmer_modifier.setVisible(false);
        modifier_confirmation.setVisible(true);
    }

    @FXML
    private void non_modifier(ActionEvent event) {
        lb_confirmer_modifier.setVisible(false);
    }

    @FXML
    private void fermer_confirmation_supprimer(ActionEvent event) {
        supprimer_confirmation.setVisible(false);
    }

    @FXML
    private void fermer_confirmation_envoyer(ActionEvent event) {
        envoyer_confirmation.setVisible(false);
    }

    @FXML
    private void fermer_confirmation_modifier(ActionEvent event) {
        modifier_confirmation.setVisible(false);
    }
}


   
