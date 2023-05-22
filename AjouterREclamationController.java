/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entites.Reclamation;
import Service.ServiceReclamation;
import Tools.DataSource;
import java.awt.image.BufferedImage;
import java.io.File;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ResourceBundle;
import javafx.embed.swing.SwingFXUtils;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;

/**
 * FXML Controller class
 *
 * @author dell
 */
public class AjouterREclamationController implements Initializable {
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
    
        private String[] a = {"Service Article", "Service de vente", "Service Comminication","Service Avis"};
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
    @FXML
    private ImageView imageV;
    /**
     * Initializes the controller class.
     */
    String imageeget = "pas d'image";
    @FXML
    private TextField imageText;
    @FXML
    private Label ErrImage;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       ServicereclameSel.getItems().setAll(a);
       init();
       
    }    

    @FXML
    private void retourReclamation(ActionEvent event) throws IOException {
        
                
                
                        if(Main.role == "admin"){
            DescRec.getScene().getWindow().hide();
              Parent root = FXMLLoader.load(getClass().getResource("GestionReclamation.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
        }
        else
        {
 DescRec.getScene().getWindow().hide();
              Parent root = FXMLLoader.load(getClass().getResource("EspaceUser.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
        
        }
    }

    @FXML
    private void saveREclamation(ActionEvent event) throws IOException {
        init();
        
        int x = 0;
        try {
            Integer.parseInt(TelRec.getText());
        } catch (Exception e) {
             ErrTel.setVisible(true);
              ErrTel.setText("Invalide numero");
        }
        
        
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
              if (imageText.getText().equals("")){
              ErrImage.setVisible(true);
              ErrImage.setText("Champ Obligatoire");
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
                       Date d1 = new Date(now.getYear()-1901, now.getMonthValue()+1, now.getDayOfMonth());
                       Reclamation r = new Reclamation(NomRec.getText(), prenomRec.getText(), EmailRec.getText(), imageeget, TelRec.getText(), d1, d2, DescRec.getText(), "Non traiter", ServicereclameSel.getValue());
                       sr.ajouter(r);
                                    if(Main.role == "admin"){
            DescRec.getScene().getWindow().hide();
              Parent root = FXMLLoader.load(getClass().getResource("GestionReclamation.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
        }
        else
        {
 DescRec.getScene().getWindow().hide();
              Parent root = FXMLLoader.load(getClass().getResource("EspaceUser.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
        
        }
                   }
    }
    
    public void init(){
            ErrNom.setVisible(false);
            ErrPrenom.setVisible(false);
            ErrEmail.setVisible(false);
            ErrTel.setVisible(false);
            ErrDesc.setVisible(false);
            ErrService.setVisible(false);
            ErrImage.setVisible(false);
    }

    @FXML
    private void file(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Pick a banner file!");
        fileChooser.setInitialDirectory(new File("\\"));
        Stage stage = new Stage();
        fileChooser.getExtensionFilters().addAll(
        new FileChooser.ExtensionFilter("JPG", "*.jpg"),
        new FileChooser.ExtensionFilter("JPEG", "*.jpeg"),   
        new FileChooser.ExtensionFilter("PNG", "*.png")
        );
        File file = fileChooser.showOpenDialog(stage);
        try {
        BufferedImage bufferedImage = ImageIO.read(file);
        Image img = SwingFXUtils.toFXImage(bufferedImage, null);
            System.out.println(file.getAbsolutePath());
            imageeget = file.toURI().toURL().toString();
                        System.out.println(imageeget);

            imageV.setImage(img);
//            Image image = new Image(file.getAbsolutePath());
            imageText.setText( file.getAbsolutePath().toString());
       //     image_modifier1.setImage(image);
        } catch (IOException ex) {
        System.out.println("could not get the image");
        }
    }
    
}
