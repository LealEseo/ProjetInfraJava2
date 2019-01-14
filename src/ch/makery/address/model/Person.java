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

	private final StringProperty firstName;
	private final StringProperty lastName;
	private final StringProperty mail;
	private final StringProperty mobile;
	private final IntegerProperty idClient;
	// private final ObjectProperty<LocalDate> birthday;

	/**
	 * Default constructor.
	 */
	@SuppressWarnings("null")
	public Person() {
		this(null, null, null, null, (Integer) null);
	}


		
	/**
	 * Constructor with some initial data.
	 * 
	 * @param firstName
	 * @param lastName
	 */
	public Person(String firstName, String lastName, String mail, String mobile, int idClient) {
		this.firstName = new SimpleStringProperty(firstName);
		this.lastName = new SimpleStringProperty(lastName);
		this.mail = new SimpleStringProperty(mail);
		this.mobile = new SimpleStringProperty(mobile);
		this.idClient = new SimpleIntegerProperty(idClient);
	}

	public String getFirstName() {
		return firstName.get();
	}

	public void setFirstName(String firstName) {
		this.firstName.set(firstName);
	}

	public StringProperty firstNameProperty() {
		return firstName;
	}

	///////////////////////////////

	public String getLastName() {
		return lastName.get();
	}

	public void setLastName(String lastName) {
		this.lastName.set(lastName);
	}

	public StringProperty lastNameProperty() {
		return lastName;
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