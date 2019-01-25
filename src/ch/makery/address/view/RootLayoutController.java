package ch.makery.address.view;

import java.io.File;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.FileChooser;
import ch.makery.address.MainApp;

/**
 * Controlleur du rootLayout

 */
public class RootLayoutController {


    private MainApp mainApp;


    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    /**
     * Efface toutes les reservations
     */
    @FXML
    private void handleNew() {
        mainApp.getPersonData().clear();
        
        
    }



    /**
     * Ferme l'application
     */
    @FXML
    private void handleExit() {
        System.exit(0);
    }
    
    
}