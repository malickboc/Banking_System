package user;
import java.time.Year;
import java.util.Date;
import java.util.List;

import Account.Account;

public class User {
    private  String F_name;
	private String midle_name;
	private String Last_name;
	private int Birth_date;
	private String license_number;
	private String Occupation;
	private List<Account> accounts;
	private Adress address;
	private int id;
	


	public User(String f_name, String midle_name, String last_name, int birth_date, String license_number,
			String occupation, List<Account> accounts, Adress address, int id) {
		super();
		F_name = f_name;
		this.midle_name = midle_name;
		Last_name = last_name;
		Birth_date = birth_date;
		this.license_number = license_number;
		Occupation = occupation;
		this.accounts = accounts;
		this.address = address;
		this.id = id;
	}


	public User(Adress address) {
		this.address = address;
	}

	


	public User(String string, int i, String string2, String string3, String string4) {
		// TODO Auto-generated constructor stub
	}


	public int getAge() {
		return Year.now().getValue() - this.Birth_date;
	}

	public String getMidle_name() {
		return midle_name;
	}

	public void setMidle_name(String midle_name) {
		this.midle_name = midle_name;
	}

	public String getLast_name() {
		return Last_name;
	}

	public void setLast_name(String last_name) {
		Last_name = last_name;
	}

	public int getBirth_date() {
		return Birth_date;
	}

	public void setBirth_date(int birth_date) {
		Birth_date = birth_date;
	}

	public String getLicense_number() {
		return license_number;
	}

	public void setLicense_number(String i) {
		this.license_number = i;
	}

	public String getOccupation() {
		return Occupation;
	}

	public void setOccupation(String occupation) {
		this.Occupation = occupation;
	}

	public Adress getAddress() {
		return address;
	}

	public void setAddress(Adress address) {
		this.address = address;
	}
	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
		
	}
	public List<Account> getAccounts() {
		return accounts;
	}




	public String getF_name() {
		return F_name;
	}


	public void setF_name(String f_name) {
		F_name = f_name;
	}




	@Override
	public String toString() {
		return "User [F_name=" + F_name + ", midle_name=" + midle_name + ", Last_name=" + Last_name + ", Birth_date="
				+ Birth_date + ", license_number=" + license_number + ", occupation=" + Occupation + ", accounts="
				+ accounts + "]";
	}



	


}
