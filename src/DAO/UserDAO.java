package DAO;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.text.ParseException;

import user.User;

public interface UserDAO {
	
	
	public boolean addUser (User user) throws ClassNotFoundException, SQLException, Exception;
	
	
	public User getUser(String driversLicense) throws FileNotFoundException, ParseException;
	
	
	public  boolean updateUser (User user);
	
	public void removeUser (String driversLicense);

}
