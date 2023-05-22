/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entites.Reclamation;
import Service.ServiceReclamation;
import Tools.DataSource;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author dell
 */
public class ModifierReclamationController implements Initializable {
  Connection cnx = DataSource.getInstance().getConnection();
  ServiceReclamation sr = new ServiceReclamation(cnx);
    @FXML
    private TextField NomRec;
    @FXML
    private TextField prenomRec;
    @FXML
    private TextField EmailRec;
    @FXML
    private TextField TelRec;
    @FXML
    private TextArea DescRec;
    @FXML
    private ComboBox<String> ServicereclameSel;
    @FXML
    private Label ErrNom;
    @FXML
    private Label ErrPrenom;
    @FXML
    private Label ErrEmail;
    @FXML
    private Label ErrTel;
    @FXML
    private Label ErrDesc;
    @FXML
    private Label ErrService;
        private String[] a = {"Service Article", "Service de vente", "Service Comminication","Service Avis"};

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      init();
      NomRec.setText(Main.rec.getNom());
      prenomRec.setText(Main.rec.getPrenom());
      EmailRec.setText(Main.rec.getEmail());
      TelRec.setText(Main.rec.getNumero_mobile());
      DescRec.setText(Main.rec.getDescription());
      ServicereclameSel.setValue(Main.rec.getNomServcie());
    }    

    @FXML
    private void retourReclamation(ActionEvent event) throws IOException {
               DescRec.getScene().getWindow().hide();
              Parent root = FXMLLoader.load(getClass().getResource("GestionReclamation.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
    }

    @FXML
    private void saveREclamation(ActionEvent event) throws IOException {
           init();
        
        int x = 0;
       if (NomRec.getText().equals("")){
              ErrNom.setVisible(true);
              ErrNom.setText("Champ Obligatoire");
        x=1;
        }
        if (prenomRec.getText().equals("")){
              ErrPrenom.setVisible(true);
              ErrPrenom.setText("Champ Obligatoire");
        x=1;
        }
         if (EmailRec.getText().equals("")){
              ErrEmail.setVisible(true);
              ErrEmail.setText("Champ Obligatoire");
        x=1;
        }
           if (TelRec.getText().equals("")){
              ErrTel.setVisible(true);
              ErrTel.setText("Champ Obligatoire");
        x=1;
        }
             if (DescRec.getText().equals("")){
              ErrDesc.setVisible(true);
              ErrDesc.setText("Champ Obligatoire");
        x=1;
        }
                   if (ServicereclameSel.getValue() == null){
              ErrService.setVisible(true);
              ErrService.setText("Selectinnée un service");
        x=1;
        }
                   
                   
                   if (x == 0 )
                   {
               LocalDateTime now = LocalDateTime.now(); 
              Date d2 = new Date(1999, 1, 1);
              Date d1 = new Date(now.getYear(), now.getMonthValue(), now.getDayOfMonth());
              Reclamation r = new Reclamation(Main.rec.getIdReclamation(),NomRec.getText(), prenomRec.getText(), EmailRec.getText(), "screenshoot", TelRec.getText(), d1, d2, DescRec.getText(), "Non traiter", ServicereclameSel.getValue());
              sr.modifier(r);
              DescRec.getScene().getWindow().hide();
              Parent root = FXMLLoader.load(getClass().getResource("GestionReclamation.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
                   }
    }
    
        public void init(){
            ErrNom.setVisible(false);
            ErrPrenom.setVisible(false);
            ErrEmail.setVisible(false);
            ErrTel.setVisible(false);
            ErrDesc.setVisible(false);
            ErrService.setVisible(false);
    }
    
}
