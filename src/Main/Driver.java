package Main;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Account.Account;
import DAO.TRansactionDao;
import DAOImpl.AdressDaoImpl;
import DAOImpl.TRansactionDAOImpl;
import DAOImpl.UserDAOImpl;
import transaction.TRansaction;
import user.Adress;
import user.User;

/**
 * Main class
 * @Malick Bocoum            
	
 * Homework1
 * 
 */


public class Driver {


	public static void main(String[] args) throws ClassNotFoundException, SQLException, FileNotFoundException, ParseException {
	
UserDAOImpl users = new UserDAOImpl();
User us = new User("Tayr",0, "12324","Profesor","12");

users.getConnection();
		
users.addUser(us);
users.updateUser(us);
users.getUser(us.getLicense_number());
users.removeUser(us.getLicense_number());
		
		
AdressDaoImpl user = new AdressDaoImpl();
Adress us1 = new Adress("1","Tayr", "2",1);
		
user.getConnection();
		
user.removeAdress(us1);
user.updateAdress(us1);
user.addUser(us1);
user.getAdress1(us1.getDriversLicense());


TRansactionDAOImpl trans = new TRansactionDAOImpl();
TRansaction us2 = new TRansaction(1,1,"d","s","w","d");
		
trans.getConnection();
TRansaction ret = trans.getTransaction(us2.getTransactionNumber());
for (int i = 0; i < 5; i++)
{
   System.out.println(ret.get(i).toString());
 
}
 
trans.updateAdress(us2);
trans.updateTransaction(us2);
trans.writeTransaction(us2);
trans.getTransaction(us2.getTransactionNumber());
		
		
		


	}

}