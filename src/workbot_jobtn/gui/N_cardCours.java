/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package workbot_jobtn.gui;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import workbot_jobtn.entites.Cours;
import static workbot_jobtn.gui.N_AfficheController.co;

/**
 * FXML Controller class
 *
 * @author ADMIN
 */
public class N_cardCours  {

    @FXML
    private ImageView coursImage;
    @FXML
    private Label CoursName;
    @FXML
    private VBox box;

    /**
     * Initializes the controller class.
     */
    Cours c=new Cours();
    public void setData(Cours cours) {
        System.out.println("hello");
                Image image = new Image(getClass().getResourceAsStream("cours\\"+cours.getTitre()+".png"));
                coursImage.setImage(image);
                CoursName.setText(cours.getTitre());
                c.setChemin(cours.getChemin());
                

    }    

    @FXML
    private void N_Consulter_Cours(MouseEvent event) throws IOException {
        
                
                
        co.setChemin(c.getChemin());
        Parent fXMLLoader = FXMLLoader.load(getClass().getResource("N_CoursHtml.fxml"));
        Scene stage=new Scene(fXMLLoader);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(stage);
        window.show();
    }
    
}
