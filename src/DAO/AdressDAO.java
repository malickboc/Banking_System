package DAO;

import java.io.FileNotFoundException;

import user.Adress;
import user.User;

public interface AdressDAO {
	
	public boolean addUser(Adress Adress);
	
	public Adress getAdress1 (int driverslicense) throws FileNotFoundException;
	
	public boolean updateAdress (Adress Address);
	
	public boolean removeAdress(Adress Adress);

	

}
