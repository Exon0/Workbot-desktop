/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */



import java.net.*;
import java.util.Base64;
import java.io.*;

import com.mysql.cj.x.protobuf.MysqlxSession.Reset;
import java.net.ServerSocket;
import java.net.URL;
import static java.nio.channels.spi.AsynchronousChannelProvider.provider;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.net.ServerSocketFactory;
import javax.net.ssl.SSLServerSocketFactory;
import javax.swing.JOptionPane;
import workbot_jobtn.utils.MyDB;


/**
 * FXML Controller class
 *
 * @author fnmoh
 */
public class SmsmethodeRestoreController implements Initializable {
int randomCode;
    @FXML
    private TextField SmSReponseL;
    @FXML
    private TextField SmSMaiL;
    @FXML
    private TextField SmsNewPass;
    @FXML
    private Button ConfirmerPassparSMS;
    @FXML
    private TextField SmsNewPass1;
    @FXML
    private Button SendMail;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
  private Connection on;
    private Statement ste;

    public SmsmethodeRestoreController(){
       on =  MyDB.getInstance().getConnection();
    }
    ResultSet rs=null;
    PreparedStatement pst=null;
    
    
    
    @FXML
    
    private void ConfirmerSms(ActionEvent event) {
        
        if (Integer.valueOf(SmsNewPass1.getText())==randomCode)
        {
           Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                     alert.setTitle("Job TN:: Succes");
                     alert.setHeaderText(null);
                     alert.setContentText("on peut changer ton password");
                     alert.showAndWait(); 
            
        } else {
         Alert alert = new Alert(Alert.AlertType.ERROR);
                     alert.setTitle("Job TN:: Error Message");
                     alert.setHeaderText(null);
                     alert.setContentText("Verifier votre numero ");
                     alert.showAndWait(); 
        }
       
       
    }

    @FXML
    private void SendMail(ActionEvent event) throws AddressException {
        /*
          Random rand=new Random();
        randomCode=rand.nextInt(999999);
         System.out.println(randomCode);
        api ap = new api();
        String message ="Your reset code is "+randomCode;
        ap.sms("mohsenfennira", "Moh20100", SmsNewPass.getText(), message);
        
        
        */
        
    /*
        try{
            System.out.println("Preparing to send email");
        Random rand=new Random();
        randomCode=rand.nextInt(999999);
         System.out.println(randomCode);
        String host ="smtp.gmail.com";
        String user ="cleaningproducts.tn@gmail.com";
        String pass="23232206";
        String to = SmsNewPass.getText();
        String subject="Reseting Code";
        String message ="Your reset code is "+randomCode;
        Boolean sessionDebug = false;
        Properties props=System.getProperties();
        props.put("mail.smtp.starttls.enable", "true");
  //If you are not using gmail you may need to change the values
    props.put("mail.smtp.host", "smtp.gmail.com");
    props.put("mail.smtp.socketFactory.port", "465");
    props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.port", "465");
        System.out.println("3"+to);
      
         java.security.Security(new com.sun.net.ssl.internal.ssl.Provider());
         System.setProperty("javax.net.ssl.keyStore","mySrvKeystore");
System.setProperty("javax.net.ssl.keyStorePassword","123456");

ServerSocketFactory ssocketFactory = SSLServerSocketFactory.getDefault();
ServerSocket ssocket = null;
System.out.println("SSL_Server started");
         System.out.println("4"+to);
        Session mailSession = Session.getDefaultInstance(props, null);
        mailSession.setDebug(sessionDebug);
        Message msg = new MimeMessage(mailSession);
        msg.setFrom(new InternetAddress(user));
        InternetAddress [] address = {new InternetAddress(to)};
        msg.setRecipients(Message.RecipientType.TO, address);
        msg.setSubject(subject);
        msg.setText(message);
        Transport transport = mailSession.getTransport("smtp");
        transport.connect(host, user, pass);
        transport.sendMessage(msg, msg.getAllRecipients());
        transport.close();
        JOptionPane.showMessageDialog(null, "code has been send to this email");
        }
        catch(Exception e){
            e.printStackTrace();
        }
        */
        }
        
        /////////////////////////Sms
    
    
    
    
    
    
    
    }
       
       
    
    
