package ch.makery.address.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ch.makery.address.model.Person;
import ch.makery.address.util.DateUtil;


public class PersonEditDialogController {

    @FXML
    private TextField nomField;
    @FXML
    private TextField prenomField;
    @FXML
    private TextField mailField;
    @FXML
    private TextField mobileField;
    @FXML
    private TextField idClientField;
    @FXML
    private TextField hotelField;
    @FXML
    private TextField chambreField;
    @FXML
    private DatePicker dateDebutField;
    @FXML
    private DatePicker dateFinField;


    private Stage dialogStage;
    private Person person;
    private boolean okClicked = false;

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
    }

    /**
     * Sets the stage of this dialog.
     * 
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    /**
     * Sets the person to be edited in the dialog.
     * 
     * @param person
     */
    public void setPerson(Person person) {
        this.person = person;
        nomField.setText(person.getNom());
        prenomField.setText(person.getPrenom());
        mailField.setText(person.getMail());
        idClientField.setText(Integer.toString(person.getIdClient()));
        mobileField.setText(person.getMobile());
        hotelField.setText(person.getHotel());
        chambreField.setText(person.getChambre());
        dateDebutField.setValue(person.getDateDebut());
        dateFinField.setValue(person.getDateFin());
    }

    /**
     * Returns true if the user clicked OK, false otherwise.
     * 
     * @return
     */
    public boolean isOkClicked() {
        return okClicked;
    }

    /**
     * Called when the user clicks ok.
     */
    @FXML
    private void handleOk() {
        if (isInputValid()) {
        	try (
    				Connection connection = DriverManager.getConnection("jdbc:postgresql://192.168.4.142:5432/hothell", "postgres", "postgres")) {
    	            PreparedStatement stmt = connection.prepareStatement("UPDATE clients SET nom = '"+nomField.getText()+"', "
    	            		+ "prenom = '"+prenomField.getText()+"', "
    	            		+ "mail = '"+mailField.getText()+"', "
    	    	            + "telephone = '"+mobileField.getText()+"' "
    	            		+ "WHERE id = "+idClientField.getText());
    	            stmt.executeUpdate();
    	            stmt = connection.prepareStatement("UPDATE reservations SET datedebut = '"+dateDebutField.getValue()+"', "
    	            		+ "datefin = '"+dateFinField.getValue()+"' "
    	            		+ "WHERE client = "+idClientField.getText());
    	            stmt.executeUpdate();
    			}
    	        catch (SQLException e) {
    	        	System.out.println(e.getMessage());
    			    e.printStackTrace();
    			}
            person.setNom(nomField.getText());
            person.setPrenom(prenomField.getText());
            person.setMail(mailField.getText());
            person.setIdClient(Integer.parseInt(idClientField.getText()));
            person.setMobile(mobileField.getText());
            person.setHotel(hotelField.getText());
            person.setChambre(chambreField.getText());
            person.setDateDebut(dateDebutField.getValue());
            person.setDateFin(dateFinField.getValue());
            okClicked = true;
            dialogStage.close();
        }
    }

    /**
     * Called when the user clicks cancel.
     */
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    /**
     * Validates the user input in the text fields.
     * 
     * @return true if the input is valid
     */
    private boolean isInputValid() {
        String errorMessage = "";

        if (nomField.getText() == null || nomField.getText().length() == 0) {
            errorMessage += "Nom invalide !\n"; 
        }
        if (prenomField.getText() == null || prenomField.getText().length() == 0) {
            errorMessage += "Prenom invalide!\n"; 
        }
        if (mailField.getText() == null || mailField.getText().length() == 0) {
            errorMessage += "Mail invalide!\n"; 
        }

        if (idClientField.getText() == null || idClientField.getText().length() == 0) {
            errorMessage += "Identifiant client invalide!\n"; 
        } else {
            // try to parse the postal code into an int. 
            try {
                Integer.parseInt(idClientField.getText());
            } catch (NumberFormatException e) {
                errorMessage += "Idenfiant invalide (entrez un nombre)!\n"; 
            }
        }

        if (mobileField.getText() == null || mobileField.getText().length() == 0) {
            errorMessage += "Numero de telephone invalide!\n"; 
        }
        
        if (hotelField.getText() == null || hotelField.getText().length() == 0) {
            errorMessage += "Hotel invalide !\n"; 
        }
        
        if (chambreField.getText() == null || chambreField.getText().length() == 0) {
            errorMessage += "Chambre invalide !\n"; 
        }
        
        if(dateDebutField.getValue().isAfter(dateFinField.getValue())) {
        	errorMessage += "Date de fin antérieur à la date de debut !";
        }
        
        

        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Champs invalide");
            alert.setHeaderText("Corrigez les champs invalides");
            alert.setContentText(errorMessage);
            alert.showAndWait();
            return false;
        }
    }
}