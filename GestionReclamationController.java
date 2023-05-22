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
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author dell
 */
public class GestionReclamationController implements Initializable {
  Connection cnx = DataSource.getInstance().getConnection();
  ServiceReclamation sr = new ServiceReclamation(cnx);
    @FXML
    private TableView<Reclamation> tabReclamation;
    @FXML
    private TableColumn<Reclamation, Integer> idRec;
    @FXML
    private TableColumn<Reclamation, String> nomRec;
    @FXML
    private TableColumn<Reclamation, String> prenomRec;
    @FXML
    private TableColumn<Reclamation, String> emailRec;
    @FXML
    private TableColumn<Reclamation, String> numeroRec;
    @FXML
    private TableColumn<Reclamation, Date> Date_creRec;
    @FXML
    private TableColumn<Reclamation, Date> date_traRec;
    @FXML
    private TableColumn<Reclamation, String> descRec;
    @FXML
    private TableColumn<Reclamation, String> statusRec;

    @FXML
    private TableColumn<Reclamation, String> servRec;
    @FXML
    private TextField searchRec;
    @FXML
    private Label ErrSel;
    @FXML
    private ImageView imageV;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        AfficherReclamation(sr.getAll());
    }    

    @FXML
    private void goAjouter(ActionEvent event) throws IOException {
        Main.role = "admin";
              searchRec.getScene().getWindow().hide();
              Parent root = FXMLLoader.load(getClass().getResource("AjouterREclamation.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
    }

    @FXML
    private void goModifeir(ActionEvent event) throws IOException {

                 try {
                  Main.rec = tabReclamation.getSelectionModel().getSelectedItem();
                  if (Main.rec != null) {
                 searchRec.getScene().getWindow().hide();
              Parent root = FXMLLoader.load(getClass().getResource("ModifierReclamation.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show(); 
            }
                  else
                       ErrSel.setText("Aucun Rec Selectionnée");
    
        } catch (Exception e) {
        }
    }

    @FXML
    private void goSupprimer(ActionEvent event) throws IOException {
                         try {
                  Main.rec = tabReclamation.getSelectionModel().getSelectedItem();
                  if (Main.rec != null) {
                 searchRec.getScene().getWindow().hide();
              Parent root = FXMLLoader.load(getClass().getResource("SupprimerReclamation.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show(); 
            }
                  else
                       ErrSel.setText("Aucun Rec Selectionnée");
    
        } catch (Exception e) {
        }
    }

    @FXML
    private void ChangerStatus(ActionEvent event) {
        
                         try {
                  Main.rec = tabReclamation.getSelectionModel().getSelectedItem();
                  if (Main.rec != null) {
                 searchRec.getScene().getWindow().hide();
              Parent root = FXMLLoader.load(getClass().getResource("StatusReclamation.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show(); 
            }
                  else
                       ErrSel.setText("Aucun Rec Selectionnée");
    
        } catch (Exception e) {
        }
    }
    
        void AfficherReclamation(ObservableList<Reclamation>  list){
           // ObservableList<Article>  list  = sa.getAll();
        idRec.setCellValueFactory(new PropertyValueFactory<Reclamation, Integer>("idReclamation"));
        nomRec.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("nom"));
        prenomRec.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("prenom"));
        emailRec.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("email"));
        numeroRec.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("numero_mobile"));
        Date_creRec.setCellValueFactory(new PropertyValueFactory<Reclamation, Date>("date_creation"));
        date_traRec.setCellValueFactory(new PropertyValueFactory<Reclamation, Date>("date_traitement"));
        descRec.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("description"));
        statusRec.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("status"));
        servRec.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("nomServcie"));

        tabReclamation.setItems(list);
        FilteredList<Reclamation> filteredData = new FilteredList<>(list, b -> true);
		// 2. Set the filter Predicate whenever the filter changes.
		searchRec.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(m -> {
				// If filter text is empty, display all persons.
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				String lowerCaseFilter = newValue.toLowerCase();
				if (m.getNom().toLowerCase().contains(lowerCaseFilter) ) {
					return true; }
                                else if (m.getPrenom().toLowerCase().contains(lowerCaseFilter)) {
					return true;}
                                else if (m.getStatus().toLowerCase().contains(lowerCaseFilter)) {
					return true;}
                                else if (m.getEmail().toLowerCase().contains(lowerCaseFilter)) {
					return true;}
                                else if (m.getDescription().toLowerCase().contains(lowerCaseFilter)) {
					return true;}
                                else if (m.getNomServcie().toLowerCase().contains(lowerCaseFilter)) {
					return true;}
				else return String.valueOf(m.getIdReclamation()).contains(lowerCaseFilter); // Does not match.           
	});
		});
                SortedList<Reclamation> sortedData = new SortedList<>(filteredData);
		
		// 4. Bind the SortedList comparator to the TableView comparator.
		// 	  Otherwise, sorting the TableView would have no effect.
		sortedData.comparatorProperty().bind(tabReclamation.comparatorProperty());
		
		// 5. Add sorted (and filtered) data to the table.
		tabReclamation.setItems(sortedData);
    
    }

    @FXML
    private void goavis(ActionEvent event) throws IOException {
        
                         searchRec.getScene().getWindow().hide();
              Parent root = FXMLLoader.load(getClass().getResource("GestionAvis.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show(); 
    }

    @FXML
    private void goReponse(ActionEvent event) throws IOException {
                      searchRec.getScene().getWindow().hide();
              Parent root = FXMLLoader.load(getClass().getResource("GestionReponse.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
    }

    @FXML
    private void imageget(ActionEvent event) {
        
        
          try {
                  Main.rec = tabReclamation.getSelectionModel().getSelectedItem();
                  if (Main.rec != null) {
                      Image img = new Image(Main.rec.getScreenshot());
              imageV.setImage(img);
            }
                  else
                       ErrSel.setText("Aucun Rec Selectionnée");
    
        } catch (Exception e) {
        }
        
        
    }

    @FXML
    private void goUser(ActionEvent event) throws IOException {
               searchRec.getScene().getWindow().hide();
              Parent root = FXMLLoader.load(getClass().getResource("EspaceUser.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
    }
    
}
