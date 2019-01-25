package ch.makery.address.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.time.LocalDate;
import java.util.Calendar;
import java.sql.Date;

import ch.makery.address.MainApp;
import ch.makery.address.model.Person;
import ch.makery.address.util.*;

public class PersonOverviewController {
    @FXML
    private TableView<Person> personTable;
    @FXML
    private TableColumn<Person, String> firstNameColumn;
    @FXML
    private TableColumn<Person, String> lastNameColumn;
    @FXML
    private Label nomLabel;
    @FXML
    private Label prenomLabel;
    @FXML
    private Label mailLabel;
    @FXML
    private Label mobileLabel; 
    @FXML
    private Label idClientLabel;
    @FXML
    private DatePicker dateDebutLabel;
    @FXML
    private DatePicker dateFinLabel;
    @FXML
    private Label hotelLabel;
    @FXML
    private Label chambreLabel;

    private MainApp mainApp;
    
    
    Date date1 = new Date (2019,1,1);
    Date date2 = new Date (2019,1,1);

    /**
     * The constructeur
     * 
     */
    public PersonOverviewController() {
    }

    /**
     * Initialise la classe controlleur
     */
    @FXML
    private void initialize() {
        // Initialise la table de reservation avec deux colonnes
        firstNameColumn.setCellValueFactory(
                cellData -> cellData.getValue().nomProperty());
        lastNameColumn.setCellValueFactory(
                cellData -> cellData.getValue().prenomProperty());

        // Efface les details de la reservation.
        showPersonDetails(null);

        // Chercher les changements et monre les détails de la reservation quand changé.
        personTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showPersonDetails(newValue));
    }

    
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

        // Ajout d'une liste de personnes
        personTable.setItems(mainApp.getPersonData());
    }
    
    
    
    
    
    
    private void showPersonDetails(Person person) {
        if (person != null) {
            // On remplit les labels avec les détails de Person
            nomLabel.setText(person.getNom());
            prenomLabel.setText(person.getPrenom());
            mailLabel.setText(person.getMail());
            mobileLabel.setText(person.getMobile());
            idClientLabel.setText(Integer.toString(person.getIdClient()));
            hotelLabel.setText(person.getHotel());
            chambreLabel.setText(person.getChambre());
            dateDebutLabel.setValue(person.getDateDebut());
            dateFinLabel.setValue(person.getDateFin());
            

            
        } else {
            // Pas de détails sur la reservation
            nomLabel.setText("");
            prenomLabel.setText("");
            mailLabel.setText("");
            mobileLabel.setText("");
            idClientLabel.setText("");
            hotelLabel.setText("");
            chambreLabel.setText("");
            dateDebutLabel.setValue(null);
            dateFinLabel.setValue(null);
            
        }
    }
    
    
    /**
     * Appelé quand l'utilisateur clique sur supprimer reservation
     */
    @FXML
    private void handleDeletePerson() {
        int selectedIndex = personTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            personTable.getItems().remove(selectedIndex);
        } else {
            // Nothing selected.
            Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("Pas de réservation selectionnée");
            alert.setHeaderText("Pas de selection");
            alert.setContentText("Sélectionnez une réservation.");
            alert.showAndWait();
        }
    }
    
    
    
    /**
     * Appelé quand l'utilisateur clique sur nouvelle reservation
     */
    @FXML
    private void handleNewPerson() {
    	
        Person tempPerson = new Person(date1, date2);
        boolean okClicked = mainApp.showPersonEditDialog(tempPerson);
        if (okClicked) {
            mainApp.getPersonData().add(tempPerson);
        }
    }

    /**
 * Appelé quand l'utilisateur clique sur le bouton edit
     */
    @FXML
    private void handleEditPerson() {
        Person selectedPerson = personTable.getSelectionModel().getSelectedItem();
        if (selectedPerson != null) {
            boolean okClicked = mainApp.showPersonEditDialog(selectedPerson);
            if (okClicked) {
                showPersonDetails(selectedPerson);
            }

        } else {
            // quand rien n'est selectionné
            Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("Pas de réservation sélectionnée");
            alert.setContentText("Sélectionnez une réservation.");
            alert.showAndWait();
        }
    }
    
    
}