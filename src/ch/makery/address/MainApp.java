package ch.makery.address;

import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.prefs.Preferences;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import ch.makery.address.view.*;
import ch.makery.address.model.Person;

import javafx.collections.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainApp extends Application {

	private Stage primaryStage;
	private BorderPane rootLayout;
	private ObservableList<Person> personData = FXCollections.observableArrayList();



	
	public MainApp() {
		// Chargement des données de la BDD
		try (
				Connection connection = DriverManager.getConnection("jdbc:postgresql://192.168.4.142:5432/hothell", "postgres", "postgres")) {
	            System.out.println("Java JDBC PostgreSQL Example");
	            PreparedStatement stmt = connection.prepareStatement("SELECT cl.nom, cl.prenom, cl.mail, cl.telephone, cl.id as clientId, h.nom as nomHotel, ch.numeroChambre, r.dateDebut, r.datefin FROM Reservations as r INNER JOIN Clients AS cl ON cl.id = r.client INNER JOIN Chambres AS ch ON r.chambre = ch.numeroChambre INNER JOIN Hotels AS h ON r.hotel = h.id;"); 
	            System.out.println(stmt);
	            ResultSet Rs = stmt.executeQuery();
	    		while(Rs.next()){
	    			System.out.println(Rs.getString(1)+" "+Rs.getString(2)+" "+Rs.getString(3)+" "+Rs.getString(4)+" "+Rs.getInt(5)+" "+Rs.getString(6)+" "+Rs.getString(7)+" "+Rs.getString(8)+" "+Rs.getString(9));
	    			personData.add(new Person(Rs.getString(1), Rs.getString(2), Rs.getString(3), Rs.getString(4), Rs.getInt(5), Rs.getString(6), Rs.getString(7), Rs.getDate(8), Rs.getDate(9)));
	    		}
			}
	        catch (SQLException e) {
	        	System.out.println(e.getMessage());
			    e.printStackTrace();
			}
		
		
		
		
	}

	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("EseOtêl");

		// Logo et icon de l'application.
		this.primaryStage.getIcons().add(new Image("file:ressources/images/logo.png"));

		initRootLayout();

		showPersonOverview();
	}

	/**
	 * Initialise le rootLayout 
	 */
	public void initRootLayout() {
		try {

			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();


			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);

			RootLayoutController controller = loader.getController();
			controller.setMainApp(this);

			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}

		
	}

	/**
	 * Charge personOverview dans le rootLayout
	 */
	public void showPersonOverview() {
		try {

			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/PersonOverview.fxml"));
			AnchorPane personOverview = (AnchorPane) loader.load();
			rootLayout.setCenter(personOverview);
			PersonOverviewController controller = loader.getController();
			controller.setMainApp(this);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public static void main(String[] args) {
		launch(args);
	}

	public ObservableList<Person> getPersonData() {
		return personData;
	}

	/**
	 * Ouvre une fenetre d'edition d'une revervation, est aussi utilisé pour créer une nouvelle
	 * reservation. Si l'utilisateur clique sur ok, les changements sont sauvegardé.
	 * 
	 * @param la reservation
	 * @return true si OK, false sinon.
	 */
	public boolean showPersonEditDialog(Person person) {
		try {
			// Charge la fenetre d'edition
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/PersonEditDialog.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

		
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Editer la reservation");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			// Ajout de la reservation dans le controller
			PersonEditDialogController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setPerson(person);

			dialogStage.showAndWait();

			return controller.isOkClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}


   
}