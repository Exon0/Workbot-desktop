/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package workbot_jobtn.gui;

import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import workbot_jobtn.entites.DTOCandidature_Offre;
import workbot_jobtn.services.OffreService;
import workbot_jobtn.utils.Mail;

/**
 * FXML Controller class
 *
 * @author Exon
 */
public class EntretienController implements Initializable {

    @FXML
    private DatePicker dateMeet;
    @FXML
    private TextField lienMeet;
    @FXML
    private Button envoyerMail;
    @FXML
    private Spinner<Integer> heureMeet;
    
    int id_passed;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        SpinnerValueFactory<Integer> valuefactory=
                new SpinnerValueFactory.IntegerSpinnerValueFactory(00, 23, 00, 01);
        
                valuefactory.setValue(8);
                heureMeet.setValueFactory(valuefactory);
       
    }    
    OffreService OffreService=new OffreService();
    @FXML
    private void onclickEnvoyerMail(ActionEvent event) {
         Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText("Confirmation");
            alert.setContentText("Vous etes sur des information saisie?");
           Optional<ButtonType> result= alert.showAndWait();
               if(result.get()== ButtonType.OK){
        
        Integer heure=heureMeet.getValue();
        String date=dateMeet.getValue().format(DateTimeFormatter.ISO_DATE);
        String meet=lienMeet.getText();
        
        DTOCandidature_Offre dto=OffreService.candidatures_Offre(id_passed).get(0);
             Mail mail=new Mail();
                        mail.envoyerMailEntretien(heure,date,meet,dto.getEmail());
    }
               else 
                   alert.close();
    }
    
    public void setId(int id){
        
       id_passed=id; 
       
    }
    
}
