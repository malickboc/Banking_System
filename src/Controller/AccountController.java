package Controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import Account.Account;
import DAO.AccountDao;
import DAO.TRansactionDao;
import user.User;

import DAOImpl.AccountDaoImpl;
import DAOImpl.TRansactionDAOImpl;
import transaction.TRansaction;

public class AccountController {
	
	AccountService accountService = new AccountService();

	Scanner sc = new Scanner(System.in);

	private List<User> accountNumber;
	
	
	
	/**
	 * I'm checking to see if users can open account which
	 * mean if users already exits to a system.
	 * @param account
	 */

	public void addUser(Account account) {

		if (userExists(Account.AccountDAO)) {

			System.out.println("User already exists");

		} else {
			System.out.println("Enter new user");
		}
	}

	
	/**
	 * 
	 * If user already exist this will return false
	 * @return
	 */

	private boolean userExists(String accountdao) {
		return false;
	}
	
	/**
	 * 
	 * This addAccount will add user  to account by providing a drivers license
	 * @param driverslicense
	 * @return
	 */

	public boolean AddAccount(String driverslicense) {
		return Account.AccountDAO.contains(driverslicense);	
	}
	

	/**
	 * 
	 * This addAccount will add user to account after getting a list of users 
	 * @return
	 */
	
	public void addAccount(List<User> users) {
		accountService.addAccount(users);
	}
	
	

	/**
	 * 
	 * This  will close a user  account by using a the account NUmber
	 * @param driverslicense
	 * @return
	 */
	   public void  closeAccount( int accountNumber) {
		accountService.closeAccount(accountNumber);
	}
	   
	   
	   /**
		 * 
		 * this function  withdraw allow user to get account number and 
		 * from that account the withdraw function is process and write to
		 * the transactionDao database.
		 * @param 
		 * @return
		 */
	   
	   
	public void withdraw(String accountNumber, String amount) {
		AccountDao dao = new AccountDaoImpl();
		TRansactionDao transDAO = new TRansactionDAOImpl();
		Account account = dao.getAccount(accountNumber);
		account.withdraw(amount);
		transDAO.writeTransaction(new TRansaction(LocalDate.now()));
	}
	
	
	
	
	/**
	 * 
	 * this function deposit  allow user to get account number and 
	 * from that account the deposit function is process and write to
	 * the transactionDao database.
	 * @param 
	 * @return
	 */
   
	public void deposit(String accountNumber, String amount) {
		AccountDao dao = new AccountDaoImpl();
		TRansactionDao transDAO = new TRansactionDAOImpl();
		Account account = dao.getAccount(accountNumber);
		account.deposit(amount);
		transDAO.writeTransaction(new TRansaction(LocalDate.now()));
	}
	
	
	
	
	/**
	 * 
	 * this function viewTransaction allow user to view 
	 * all the transaction which include deposit and withdraw
	 * @param 
	 * @return
	 */
	public void viewTransaction (String accountNumber, String amount) {
		AccountDao dao = new AccountDaoImpl();
		Account account = dao.getAccount(accountNumber);
		account.deposit(amount);
		account.withdraw(amount);
		
	}
	

}