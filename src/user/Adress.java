package user;

import java.time.LocalDate;

public class Adress {
	private int driversLicense ;
	
	
	private String street;
	private String state;
	private String zip;
	
	public Adress(String street, String city, String zip, int driversLicense) {
		this.street = street;
		this.state = city;
		this.zip = zip;
		this.driversLicense = driversLicense;
	}
	public Adress(String[] temp) {
		// TODO Auto-generated constructor stub
	}
	public Adress(int i, String string, int j, String string2, String string3) {
		// TODO Auto-generated constructor stub
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getstate() {
		return state;
	}
	public void setCity(String city) {
		this.state = city;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	
	public int getDriversLicense() {
		return driversLicense;
	}
	
	
}

