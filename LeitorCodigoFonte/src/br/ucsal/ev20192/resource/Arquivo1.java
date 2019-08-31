package br.ucsal.ev20192.resource;

public class Arquivo1 implements Comparable<Arquivo1> {

	private int idCircuito;
	private String refCircuito;
	private String nomeCircuito;
	private String local;
	private String pais;
	private String latitude;
	private String longitude;
	private String altitude;
	private String url;
	
	public Arquivo1(int idCircuito, String refCircuito, String nomeCircuito, String local, String pais, String latitude, String longitude, String altitude, String url) {
		this.idCircuito = idCircuito;
		this.refCircuito = refCircuito;
		this.nomeCircuito = nomeCircuito;
		this.local = local;
		this.pais = pais;
		this.latitude = latitude;
		this.longitude = longitude;
		this.altitude = altitude;
		this.url = url;
	}
	
	public int getIdCircuito() {
		return idCircuito;
	}
	
	public void setIdCircuito(int idCircuito) {
		this.idCircuito = idCircuito;
	}
	
	public String getRefCircuito() {
		return refCircuito;
	}
	
	public void setRefCircuito(String refCircuito) {
		this.refCircuito = refCircuito;
	}
	
	public String getNomeCircuito() {
		return nomeCircuito;
	}
	
	public void setNomeCircuito(String nomeCircuito) {
		this.nomeCircuito = nomeCircuito;
	}
	
	public String getLocal() {
		return local;
	}
	
	public void setLocal(String local) {
		this.local = local;
	}
	
	public String getPais() {
		return pais;
	}
	
	public void setPais(String pais) {
		this.pais = pais;
	}
	
	public String getLatitude() {
		return latitude;
	}
	
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	
	public String getLongitude() {
		return longitude;
	}
	
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	
	public String getAltitude() {
		return altitude;
	}
	
	public void setAltitude(String altitude) {
		this.altitude = altitude;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	@Override
	public String toString() {
		return "Circuito id= " + this.idCircuito + " Referencia: " + this.refCircuito + " Nome: " + this.nomeCircuito
				+ " Local: " + this.local + " Pais: " + this.pais + " Latitude: " + this.latitude + " Longitude: "
				+ this.longitude + " Altitude: " + this.altitude + " URL: " + this.url;
	}
	
	@Override
	public int compareTo(Arquivo1 c) {
		return this.getRefCircuito().compareTo(c.getRefCircuito());
	}
}