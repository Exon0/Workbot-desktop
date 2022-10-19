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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import workbot_jobtn.entites.User;
import workbot_jobtn.utils.MyDB;


/**
 *
 * @author fnmoh
 */
public class M_Listadmin implements Initializable{
    @FXML
    private Button M_supprimer;

    
    @FXML
    private Button M_ImprimerLa;
    
    @FXML
    private TextField M_rechercheLA;
    
    
    
    @FXML
    private Button M_modifier;

    @FXML
    private TableView<User> M_tableLC;

    @FXML
    private TableColumn<User, Integer> M_idLC;

    @FXML
    private TableColumn<User, String> M_prenomLC;

    @FXML
    private TableColumn<User, String> M_nomLC;

    @FXML
    private TableColumn<User, String> M_emailLC;

    @FXML
    private TableColumn<User, String> m_passwordLC;

    
        @FXML
    private TextField M_id;
        
        
    @FXML
    private TextField M_nomLCtextfuild;

    @FXML
    private TextField M_prenomLCtextfuild;

    @FXML
    private TextField M_mailLCtextfuild;

    @FXML
    private Button M_logoutLAid;
    
    
    @FXML
    private Button M_ajouter;

    @FXML
    private TextField M_passwordLCtextfuild;
    
        @FXML
    private Button M_listclientLS;
    @FXML
    private Button M_actualiser;
    
   public void initialize(URL url,ResourceBundle rb){
      showAdmin();
      M_rechercheL();
 }
    @FXML
    void Add(ActionEvent event) {
 if(event.getSource() == M_ajouter){
            insertRecord();
       
        }
           
    }

    
      
    void M_rechercheL() {
ObservableList<User> list = getAdminList();
        
       showAdmin();
        
         FilteredList<User> filteredData = new FilteredList<>(list, b -> true);
		
		// 2. Set the filter Predicate whenever the filter changes.
		M_rechercheLA.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(admin -> {
				// If filter text is empty, display all persons.
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (admin.getPrenom().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter prenom.
				} else if (admin.getNom().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter nom.
				}
				else if (String.valueOf(admin.getEmail()).indexOf(lowerCaseFilter)!=-1) {
				     return true;
                                }
                                else if (String.valueOf(admin.getMdp()).indexOf(lowerCaseFilter)!=-1) 
				     return true;
                                
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
    
    
    
    
    
    @FXML
    void Delete(ActionEvent event) {
if(event.getSource() == M_supprimer){
            deleteButton();
            M_rechercheL();
        }
    }

    @FXML
    void Update(ActionEvent event) {
if(event.getSource() == M_modifier){
            updateRecord();
            M_rechercheL();
        }
    }

    
    
    
    
    
    
    int index=-1;
    
    
    
    ////////select user ////////
    @FXML
    void getSelected(MouseEvent event){
        index =  M_tableLC.getSelectionModel().getSelectedIndex();
        if(index <= -1){
            return;
        }
    M_id.setText(M_idLC.getCellData(index).toString());
    M_nomLCtextfuild.setText(M_nomLC.getCellData(index).toString());
    M_prenomLCtextfuild.setText( M_prenomLC.getCellData(index).toString());
    M_mailLCtextfuild.setText(M_emailLC.getCellData(index).toString());
    M_passwordLCtextfuild.setText(m_passwordLC.getCellData(index).toString());
    
    }
 
     @FXML
    void actualiserLCC(ActionEvent event) {
showAdmin();
M_rechercheL();
    }
    
    
    
    
    ////////////
    
    
    
   
     
    
       private Connection on;
    private Statement ste;

    public M_Listadmin (){
       on =  MyDB.getInstance().getConnection();
    }
String role ="Admin";
 public ObservableList<User> getAdminList(){
    ObservableList<User> adminList= FXCollections.observableArrayList();
   
    String query = "SELECT * FROM utilisateur where role ='Admin' ";
    Statement st;
    ResultSet rs;
    try{
        st=on.createStatement();
        rs=st.executeQuery(query);
        User user;
        while(rs.next()){
            user= new User(rs.getInt("id"),rs.getString("prenom"),rs.getString("nom"),rs.getString("email"),rs.getString("mdp"));
            adminList.add(user);
            
        }
    }     catch (SQLException ex) {
             ex.printStackTrace();
          }
   
    return adminList;
    
    
    }
///////////////////////////////////////

////////////////////////////////////////
    public void showAdmin(){
        ObservableList<User> list = getAdminList();
        
        M_idLC.setCellValueFactory(new PropertyValueFactory<User, Integer>("id"));
       M_nomLC .setCellValueFactory(new PropertyValueFactory<User, String>("prenom"));
        M_prenomLC.setCellValueFactory(new PropertyValueFactory<User, String>("nom"));
        M_emailLC.setCellValueFactory(new PropertyValueFactory<User, String>("email"));
        m_passwordLC.setCellValueFactory(new PropertyValueFactory<User, String>("mdp"));
        
        M_tableLC.setItems(list);
        
}
    
    ////////////////////////////////////////////
 private void insertRecord() {
        
        String query = "INSERT INTO utilisateur (prenom,nom,email,mdp,role) VALUES ('" + M_prenomLCtextfuild.getText() + "','" + M_nomLCtextfuild.getText() + "','" + M_mailLCtextfuild.getText() + "','"
                + M_passwordLCtextfuild.getText() + "','" + role + "')";
        
        executeQuery(query);
        showAdmin();
        
    }

 ///////////////////////////////////////////
    
    private void executeQuery(String query) {
        Statement st;
        try{
            st = on.createStatement();
            st.executeUpdate(query);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    //////////////////////////////////////////
    String prenom ;
      private void deleteButton(){
      
        String query = "DELETE FROM utilisateur WHERE id =" + M_id.getText() + "";
        executeQuery(query);
        showAdmin();
    }
      ///////////////////////////////////
  private void updateRecord(){
        String query = "UPDATE  utilisateur SET id ="+ M_id.getText()+",prenom = '" +M_prenomLCtextfuild .getText() + "', nom = '" + M_nomLCtextfuild.getText() + "', email = '" +
                M_mailLCtextfuild.getText() + "', mdp = '" +  M_passwordLCtextfuild.getText() + "' WHERE id = " + M_id.getText() + " ";
        executeQuery(query);
        showAdmin();
    }
  //////////////////////////////////////////////////////////////
  
 @FXML
    void  ListClient(ActionEvent event) { 
  try {
			Stage stage = (Stage) M_passwordLCtextfuild.getScene().getWindow();
                        stage.close();
                        
          Parent root=FXMLLoader.load(getClass().getResource("M_ListClient.fxml"));
			Scene scene = new Scene(root,840,600);
		
			stage.setScene(scene);
			stage.show();
                        
		} catch(Exception e) {
			e.printStackTrace();
		}
    }
    
    
    
    
    
    
    
    
    ////////////////////////
    
    
    @FXML
    void M_logoutLAaction(ActionEvent event) {
        try {
Stage stage = (Stage) M_passwordLCtextfuild.getScene().getWindow();
                        stage.close();
                        
          Parent root=FXMLLoader.load(getClass().getResource("M_Login.fxml"));
			Scene scene = new Scene(root,840,600);
		
			stage.setScene(scene);
			stage.show();
                        
		} catch(Exception e) {
			e.printStackTrace();
		}
    }
    
    //////////////////////
        @FXML
    void M_ImprimerLA(ActionEvent event)  {
        
        }
            
            //////////////////////
    
 
}
    
    
    


