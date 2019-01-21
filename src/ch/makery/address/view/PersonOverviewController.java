package ch.makery.address.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.time.LocalDate;

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

    // Reference to the main application.
    private MainApp mainApp;

    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public PersonOverviewController() {
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
        // Initialize the person table with the two columns.
        firstNameColumn.setCellValueFactory(
                cellData -> cellData.getValue().nomProperty());
        lastNameColumn.setCellValueFactory(
                cellData -> cellData.getValue().prenomProperty());

        // Clear person details.
        showPersonDetails(null);

        // Listen for selection changes and show the person details when changed.
        personTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showPersonDetails(newValue));
    }

    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

        // Add observable list data to the table
        personTable.setItems(mainApp.getPersonData());
    }
    
    
    
    
    
    /**
     * Fills all text fields to show details about the person.
     * If the specified person is null, all text fields are cleared.
     * 
     * @param person the person or null
     */
    private void showPersonDetails(Person person) {
        if (person != null) {
            // Fill the labels with info from the person object.
            nomLabel.setText(person.getNom());
            prenomLabel.setText(person.getPrenom());
            mailLabel.setText(person.getMail());
            mobileLabel.setText(person.getMobile());
            idClientLabel.setText(Integer.toString(person.getIdClient()));
            hotelLabel.setText(person.getHotel());
            chambreLabel.setText(person.getChambre());
            dateDebutLabel.setValue(person.getDateDebut());
            

            
        } else {
            // Person is null, remove all the text.
            nomLabel.setText("");
            prenomLabel.setText("");
            mailLabel.setText("");
            mobileLabel.setText("");
            idClientLabel.setText("");
            hotelLabel.setText("");
            chambreLabel.setText("");
            dateDebutLabel.setValue(null);
            
        }
    }
    
    
    /**
     * Called when the user clicks on the delete button.
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
     * Called when the user clicks the new button. Opens a dialog to edit
     * details for a new person.
     */
    @FXML
    private void handleNewPerson() {
        Person tempPerson = new Person();
        boolean okClicked = mainApp.showPersonEditDialog(tempPerson);
        if (okClicked) {
            mainApp.getPersonData().add(tempPerson);
        }
    }

    /**
     * Called when the user clicks the edit button. Opens a dialog to edit
     * details for the selected person.
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
            // Nothing selected.
            Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("Pas de réservation sélectionnée");
            alert.setContentText("Sélectionnez une réservation.");
            alert.showAndWait();
        }
    }
    
    
}