/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workbot_jobtn.gui;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import workbot_jobtn.entites.Candidat;
import workbot_jobtn.entites.User;
import workbot_jobtn.utils.MyDB;


/**
 *
 * @author fnmoh
 */

public class M_Listclient implements Initializable {
      @FXML
    private TextField M_id;
    @FXML
    private Button M_listclientLS;
    @FXML
    private TableView<User> M_tableLC;
    @FXML
    private TableColumn<User, String> M_roleLCC;
    @FXML
    private TableColumn<User, String> M_preLCC;
    @FXML
    private TableColumn<User, String> M_nomLCC;
    @FXML
    private TableColumn<User, String> M_emailLCC;
    @FXML
    private TableColumn<User, String> M_telLCC;
    @FXML
    private TableColumn<User, String> M_adresseLCC;
    @FXML
    private TableColumn<User, String> M_domaineCC;
    @FXML
    private Button M_rechercheLAA;
    @FXML
    private Button M_supprimLCC;
    
    
     void M_rechercheLAAA(ActionEvent event) {

    }
    //////////////
   private Connection on;
    private Statement ste;
public M_Listclient (){
       on =  MyDB.getInstance().getConnection();
    }
    
    ///////////
    
     public ObservableList<User> getClientList(){
    ObservableList<User> userList= FXCollections.observableArrayList();
 
    String query = "SELECT * FROM utilisateur where role = 'sociéte' ";
    Statement st;
    ResultSet rs;
    try{
        st=on.createStatement();
        rs=st.executeQuery(query);
        User user;
        while(rs.next()){
            user= new Candidat(rs.getString("nom"),rs.getString("prenom"),rs.getString("tel"),rs.getString("email"),rs.getString("adresse"),rs.getString("domaine"),rs.getString("role"));
            userList.add(user);
            
        }
    }     catch (SQLException ex) {
             ex.printStackTrace();
          }
   
    return userList;
     }
    public void showUser(){
        ObservableList<User> list = getClientList();
        
        M_roleLCC.setCellValueFactory (new PropertyValueFactory<User, String>("role"));
      M_preLCC .setCellValueFactory (new PropertyValueFactory<User, String>("prenom"));
        M_nomLCC.setCellValueFactory (new PropertyValueFactory<User, String>("nom"));
        M_emailLCC.setCellValueFactory ( new PropertyValueFactory<User, String>("email"));
        M_telLCC.setCellValueFactory (new PropertyValueFactory<User, String>("tel"));
        M_adresseLCC.setCellValueFactory (new PropertyValueFactory<User, String>("adresse"));
        M_domaineCC.setCellValueFactory (new PropertyValueFactory<User, String>("domaine"));
        M_tableLC.setItems(list);
        
}
    
    @FXML
    void M_listclientLS(ActionEvent event) {
      try {
			Stage stage = (Stage) M_listclientLS.getScene().getWindow();
                        stage.close();
                        
          Parent root=FXMLLoader.load(getClass().getResource("M_ListAdmin.fxml"));
			Scene scene = new Scene(root,840,600);
		
			stage.setScene(scene);
			stage.show();
                        
		} catch(Exception e) {
			e.printStackTrace();
		}
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       showUser();
       M_rechercheL();
    }

    @FXML
    private void M_supprimLCC(ActionEvent event) {
    }

    @FXML
    private void getSelected(MouseEvent event) {
    }
    
       void M_rechercheL() {
ObservableList<User> list = getClientList();
        
       showUser();
        
         FilteredList<User> filteredData = new FilteredList<>(list, b -> true);
		
		// 2. Set the filter Predicate whenever the filter changes.
		M_id.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(user -> {
				// If filter text is empty, display all persons.
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (user.getPrenom().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter prenom.
				} else if (user.getNom().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter nom.
				}
				else if (String.valueOf(user.getEmail()).indexOf(lowerCaseFilter)!=-1) {
				     return true;
                                }
                                
                                
				     else  
				    	 return false; // Does not match.
			});
		});
		
		// 3. Wrap the FilteredList in a SortedList. 
		SortedList<User> sortedData = new SortedList<>(filteredData);
		
		// 4. Bind the SortedList comparator to the TableView comparator.
		// 	  Otherwise, sorting the TableView would have no effect.
		sortedData.comparatorProperty().bind(M_tableLC.comparatorProperty());
		
		// 5. Add sorted (and filtered) data to the table.
		M_tableLC.setItems(sortedData);
               
        
    }    
}
    

