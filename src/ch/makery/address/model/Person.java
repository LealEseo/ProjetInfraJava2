package ch.makery.address.model;

import java.time.LocalDate;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import ch.makery.address.util.*;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

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
	// private final ObjectProperty<LocalDate> birthday;

	/**
	 * Default constructor.
	 */
	public Person() {
		this(null, null, null, null, (Integer) null);
	}
	
	public Person(String nom, String prenom) {
		this(nom, prenom, null, null, (Integer) null);
	}


		
	/**
	 * Constructor with some initial data.
	 * 
	 * @param nom
	 * @param prenom
	 */
	public Person(String nom, String prenom, String mail, String mobile, int idClient) {
		this.nom = new SimpleStringProperty(nom);
		this.prenom = new SimpleStringProperty(prenom);
		this.mail = new SimpleStringProperty(mail);
		this.mobile = new SimpleStringProperty(mobile);
		this.idClient = new SimpleIntegerProperty(idClient);
	}

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

}