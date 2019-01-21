package ch.makery.address.model;

public class Chambre {

	private int idChambre;
	private int idHotel;
	private int nbLitSimple;
	private int nbLitDouble;
	private int prix;
	private String gammeChambre;
	private int etage;
	
	public Chambre(int idChambre, int idHotel, int nbLitSimple, int nbLitDouble, int prix, String gammeChambre,
			int etage) {
		this.idChambre = idChambre;
		this.idHotel = idHotel;
		this.nbLitSimple = nbLitSimple;
		this.nbLitDouble = nbLitDouble;
		this.prix = prix;
		this.gammeChambre = gammeChambre;
		this.etage = etage;
	}
	
	public int getIdChambre() {
		return idChambre;
	}
	public void setIdChambre(int idChambre) {
		this.idChambre = idChambre;
	}
	public int getIdHotel() {
		return idHotel;
	}
	public void setIdHotel(int idHotel) {
		this.idHotel = idHotel;
	}
	public int getNbLitSimple() {
		return nbLitSimple;
	}
	public void setNbLitSimple(int nbLitSimple) {
		this.nbLitSimple = nbLitSimple;
	}
	public int getNbLitDouble() {
		return nbLitDouble;
	}
	public void setNbLitDouble(int nbLitDouble) {
		this.nbLitDouble = nbLitDouble;
	}
	public int getPrix() {
		return prix;
	}
	public void setPrix(int prix) {
		this.prix = prix;
	}
	public String getGammeChambre() {
		return gammeChambre;
	}
	public void setGammeChambre(String gammeChambre) {
		this.gammeChambre = gammeChambre;
	}
	public int getEtage() {
		return etage;
	}
	public void setEtage(int etage) {
		this.etage = etage;
	}
	
	
	
	
}
