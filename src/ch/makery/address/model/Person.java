package ch.makery.address.model;

import java.time.LocalDate;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import ch.makery.address.util.*;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.DatePicker;

/**
 * Model class for a Person.
 *
 * @author Marco Jakob
 */
public class Person {

	private final StringProperty nom;
	private final StringProperty prenom;
	private final StringProperty mail;
	private final StringProperty mobile;
	private final IntegerProperty idClient;
	private final StringProperty hotel;
	private final StringProperty chambre;


	/**
	 * Default constructor.
	 */

	/**
	 * Constructor with some initial data.
	 * 
	 * @param nom
	 * @param prenom
	 */
	public Person(String nom, String prenom, String mail, String mobile, int idClient, String hotel, String chambre) {
		this.nom = new SimpleStringProperty(nom);
		this.prenom = new SimpleStringProperty(prenom);
		this.mail = new SimpleStringProperty(mail);
		this.mobile = new SimpleStringProperty(mobile);
		this.idClient = new SimpleIntegerProperty(idClient);
		this.hotel = new SimpleStringProperty(hotel);
		this.chambre = new SimpleStringProperty(chambre);

	}
	
	//Constructors

	public Person() {
		this(null, null, null, null, 00, null, null);
	}

	public Person(String nom, String prenom) {
		this(nom, prenom, null, null, 00, null, null);
	}
	
	

	//Getters and Setters
	
	public String getNom() {
		return nom.get();
	}

	public void setNom(String nom) {
		this.nom.set(nom);
	}

	public StringProperty nomProperty() {
		return nom;
	}

	///////////////////////////////

	public String getPrenom() {
		return prenom.get();
	}

	public void setPrenom(String prenom) {
		this.prenom.set(prenom);
	}

	public StringProperty prenomProperty() {
		return prenom;
	}

	////////////////////////////////

	public String getMail() {
		return mail.get();
	}

	public void setMail(String mail) {
		this.mail.set(mail);
	}

	public StringProperty mailProperty() {
		return mail;
	}

	////////////////////////////////

	public String getMobile() {
		return mobile.get();
	}

	public void setMobile(String mobile) {
		this.mobile.set(mobile);
	}

	public StringProperty mobileProperty() {
		return mobile;
	}

	////////////////////////////////

	public int getIdClient() {
		return idClient.get();
	}

	public void setIdClient(int idClient) {
		this.idClient.set(idClient);
	}

	public IntegerProperty idClientProperty() {
		return idClient;
	}

	////////////////////////////////

	public String getHotel() {
		return hotel.get();
	}

	public void setHotel(String hotel) {
		this.hotel.set(hotel);
	}

	public StringProperty hotelProperty() {
		return hotel;
	}

	//////////////////////////////// 

	public String getChambre() {
		return chambre.get();
	}

	public void setChambre(String chambre) {
		this.chambre.set(chambre);
	}

	public StringProperty chambreProperty() {
		return chambre;
	}
	


}