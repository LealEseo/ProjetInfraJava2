package ch.makery.address.model;


public class Hotel {

	private int idHotel;
	private String nom;
	private String adresse;
	private int nbChambre;

	
	public Hotel(int idHotel, String nom, String adresse, int nbChambre) {
		this.idHotel = idHotel;
		this.nom = nom;
		this.adresse = adresse;
		this.nbChambre = nbChambre;
	}
	
	public int getIdHotel() {
		return idHotel;
	}
	public void setIdHotel(int idHotel) {
		this.idHotel = idHotel;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public int getNbChambre() {
		return nbChambre;
	}
	public void setNbChambre(int nbChambre) {
		this.nbChambre = nbChambre;
	}
}
