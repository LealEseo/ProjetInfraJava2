package ch.makery.address.model;

import java.sql.Timestamp;

public class Reservation {

	private int id;
	private Hotel hotel;
	private Chambre chambre;
	private Person client;
	private Timestamp dateDebut;
	private Timestamp dateFin;

	
	public Reservation(int id, Hotel hotel, Chambre chambre, Person client, Timestamp dateDebut, Timestamp dateFin){
		this.id = id;
		this.hotel = hotel;
		this.chambre = chambre;
		this.client = client;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
	}
	
	public Hotel getHotel() {
		return this.hotel;
	}

	public int getId() {
		return id;
	}

	public Chambre getChambre() {
		return chambre;
	}

	public Person getClient() {
		return client;
	}

	public Timestamp getDateDebut() {
		return dateDebut;
	}

	public Timestamp getDateFin() {
		return dateFin;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public void setChambre(Chambre chambre) {
		this.chambre = chambre;
	}

	public void setClient(Person client) {
		this.client = client;
	}

	public void setDateDebut(Timestamp dateDebut) {
		this.dateDebut = dateDebut;
	}

	public void setDateFin(Timestamp dateFin) {
		this.dateFin = dateFin;
	}
	
}
