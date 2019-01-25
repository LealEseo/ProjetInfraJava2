package ch.makery.address.model;

import java.sql.Date;
import java.time.LocalDate;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import ch.makery.address.util.*;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class Person {

	private final StringProperty nom;
	private final StringProperty prenom;
	private final StringProperty mail;
	private final StringProperty mobile;
	private final IntegerProperty idClient;
	private final StringProperty hotel;
	private final StringProperty chambre;
	private final ObjectProperty<LocalDate> dateDebut;
	private final ObjectProperty<LocalDate> dateFin;

	/**
	 * Default constructor.
	 */

	/**
	 * Constructor with some initial data.
	 * 
	 * @param nom
	 * @param prenom
	 */
	public Person(String nom, String prenom, String mail, String mobile, int idClient, String hotel, String chambre, Date dateDebut, Date dateFin) {
		this.nom = new SimpleStringProperty(nom);
		this.prenom = new SimpleStringProperty(prenom);
		this.mail = new SimpleStringProperty(mail);
		this.mobile = new SimpleStringProperty(mobile);
		this.idClient = new SimpleIntegerProperty(idClient);
		this.hotel = new SimpleStringProperty(hotel);
		this.chambre = new SimpleStringProperty(chambre);
		this.dateDebut = new SimpleObjectProperty<LocalDate>(dateDebut.toLocalDate());
		this.dateFin = new SimpleObjectProperty<LocalDate>(dateFin.toLocalDate()); // LocalDate.of(1999, 2, 21)

	}

	// Constructors

	public Person() {
		this(null, null, null, null, 00, null, null,null,null);
	}

	public Person(String nom, String prenom) {
		this(nom, prenom, null, null, 00, null, null,null,null);
	}

	// Getters and Setters

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
	
	public int getHotelId(){
		int idhotel = -1;
		if(hotel.equals("Tothell")){
        	idhotel = 1; 

        }
        else if (hotel.equals("Hekel")){
        	idhotel = 2;
        }
        else if (hotel.equals("Otello")){
        	idhotel = 3;
        }    	            
        else if (hotel.equals("Hothell")){
        	idhotel = 4;
        }
        else{
        	idhotel = -1; 
        } 
		return idhotel;
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

	
	////////////////////////////////

	@XmlJavaTypeAdapter(LocalDateAdapter.class)
	public LocalDate getDateDebut() {
		return dateDebut.get();
	}

	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut.set(dateDebut);
	}

	public ObjectProperty<LocalDate> dateDebutProperty() {
		return dateDebut;
	}

	////////////////////////////////

	@XmlJavaTypeAdapter(LocalDateAdapter.class)
	public LocalDate getDateFin() {
		return dateFin.get();
	}

	public void setDateFin(LocalDate dateFin) {
		this.dateFin.set(dateFin);
	}

	public ObjectProperty<LocalDate> dateFinProperty() {
		return dateFin;
	}

}