package Controller;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import Account.Account;
import DAO.UserDAO;
import DAOImpl.UserDAOImpl;
import user.User;

public class UserService {

	UserDAO dao = new UserDAOImpl();

	/**
	 * Add user to DAtabase
	 * 
	 * @throws Exception
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */

	public boolean addUser(User user) throws ClassNotFoundException, SQLException, Exception {

		return dao.addUser(user);

	}

	/**
	 * 
	 * Get the user from Database
	 * 
	 * @throws ParseException
	 * @throws FileNotFoundException
	 * 
	 */

	public User getUser(String driversLicense) throws FileNotFoundException, ParseException {

		return dao.getUser(driversLicense);
	}

	/**
	 * 
	 * update user from Database
	 * 
	 */

	public boolean updateUser(User user) {

		return dao.updateUser(user);
	}

	/**
	 * 
	 * remove user from Database
	 * 
	 */

	public void removeUser(String driversLicense) {

		dao.removeUser(driversLicense);
	}
}
