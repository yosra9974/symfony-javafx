/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entites.Avis;
import Entites.Reclamation;
import Service.ServiceAvis;
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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author dell
 */
public class GestionAvisController implements Initializable {
  Connection cnx = DataSource.getInstance().getConnection();
    ServiceAvis sa = new ServiceAvis(cnx);
    @FXML
    private TableView<Avis> tabAvis;
    @FXML
    private TableColumn<Avis, Integer> idAvis;
    @FXML
    private TableColumn<Avis, String> detailsAvis;
    @FXML
    private TableColumn<Avis, Integer> noteAvis;
    @FXML
    private TableColumn<Avis, Integer> ArticleAvis;
    @FXML
    private TableColumn<Avis, Integer> userAvis;
    @FXML
    private ComboBox<Integer> selAvis;
    @FXML
    private TextField searchavis;
    @FXML
    private Label ErrSel;
        private Integer[] a = {1,2,3,4};
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        selAvis.getItems().setAll(a);
        AfficherAvis(sa.getAll());
    }    

    @FXML
    private void retourAvvis(ActionEvent event) throws IOException {
                 searchavis.getScene().getWindow().hide();
              Parent root = FXMLLoader.load(getClass().getResource("GestionReclamation.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
    }

    @FXML
    private void ajouterAvis(ActionEvent event) throws IOException {
        Main.role = "admin";
                     searchavis.getScene().getWindow().hide();
              Parent root = FXMLLoader.load(getClass().getResource("AjouterAvis.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show(); 
    }

    @FXML
    private void ModifierAvis(ActionEvent event) {
                                 try {
                  Main.avis = tabAvis.getSelectionModel().getSelectedItem();
                  if (Main.avis != null) {
                 searchavis.getScene().getWindow().hide();
              Parent root = FXMLLoader.load(getClass().getResource("ModifeirAvis.fxml"));
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
    private void SuppAvis(ActionEvent event) {
                             try {
                  Main.avis = tabAvis.getSelectionModel().getSelectedItem();
                  if (Main.avis != null) {
                 searchavis.getScene().getWindow().hide();
              Parent root = FXMLLoader.load(getClass().getResource("SupprimerAvis.fxml"));
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
    private void AvisArt(ActionEvent event) {
        AfficherAvis(sa.getAllArticle(selAvis.getValue()));
    }
    

            void AfficherAvis(ObservableList<Avis>  list){
           // ObservableList<Article>  list  = sa.getAll();
        idAvis.setCellValueFactory(new PropertyValueFactory<Avis, Integer>("idAvis"));
        detailsAvis.setCellValueFactory(new PropertyValueFactory<Avis, String>("detailAvisService"));
        noteAvis.setCellValueFactory(new PropertyValueFactory<Avis, Integer>("noteService"));
        ArticleAvis.setCellValueFactory(new PropertyValueFactory<Avis, Integer>("idArticle"));
        userAvis.setCellValueFactory(new PropertyValueFactory<Avis, Integer>("idUser"));
              tabAvis.setItems(list);
        FilteredList<Avis> filteredData = new FilteredList<>(list, b -> true);
		// 2. Set the filter Predicate whenever the filter changes.
		searchavis.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(m -> {
				// If filter text is empty, display all persons.
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				String lowerCaseFilter = newValue.toLowerCase();
				if (m.getDetailAvisService().toLowerCase().contains(lowerCaseFilter) ) {
					return true; }
                  
				else return String.valueOf(m.getNoteService()).contains(lowerCaseFilter); // Does not match.           
	});
		});
                SortedList<Avis> sortedData = new SortedList<>(filteredData);
		
		// 4. Bind the SortedList comparator to the TableView comparator.
		// 	  Otherwise, sorting the TableView would have no effect.
		sortedData.comparatorProperty().bind(tabAvis.comparatorProperty());
		
		// 5. Add sorted (and filtered) data to the table.
		tabAvis.setItems(sortedData);
    
    }

    @FXML
    private void acualiser(ActionEvent event) {
        AfficherAvis(sa.getAll());
    }
    
}
