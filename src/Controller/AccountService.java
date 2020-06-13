package Controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

import Account.Account;
import Account.businessCheckinAccount;
import Account.businessSavingAccount;
import Account.personalCheckinAccount;
import Account.personalSavingAccount;
import Account.studentCheckinAccount;
import Account.studentSavingAccount;
import DAO.AccountDao;
import DAOImpl.AccountDaoImpl;
import user.User;

public class AccountService {

	AccountDao dao = new AccountDaoImpl();

	/**
	 * Close account from Database
	 * 
	 */

	public void closeAccount(int accountNumber) {

		dao.closeAccount(accountNumber);

	}

	
	
	public Account getAccount(String accountNumber) {
		
		return dao.getAccount(accountNumber);
	}
	/**
	 * 
	 * Get the list Account from Database
	 * 
	 */

	public List<Account> getAccounts(String driversLicense) {

		return dao.getAccounts(driversLicense);

	}

	/**
	 * 
	 * update account from database
	 * 
	 */
	public boolean updateAccount(Account account) {

		return dao.updateAccount(account);

	}
	
	
	
	/**
	 * This addAccount provide to users the chance to choose 
	 * between an account that it would like to perform.
	 * @param users
	 * @return
	 */

	public  boolean addAccount(List<User> users) {
		Scanner stdin = new Scanner(System.in);
		System.out.println("Enter type of account: ");
		String input = stdin.nextLine();
		Account acc = null;
		switch(input) {
		
		
			case "studentcheckingAccount":
				AccountDao dao = new AccountDaoImpl();
				if(acc.canOpen()) {
					acc = new studentCheckinAccount(users, BigDecimal.ZERO, true);
					dao.addAccount(acc);	
			    } 
				break;
		
			case "studentSavingAccount":
				AccountDao Dao = new AccountDaoImpl();
				if(acc.canOpen()) {
					acc = new studentSavingAccount(users, BigDecimal.ZERO, true);
					Dao.addAccount(acc);	
				} 	
				break;
	           
			case "PersonalcheckingAccount":
				AccountDao Dao1 = new AccountDaoImpl();
				if(acc.canOpen()) {
					acc = new personalCheckinAccount(users, BigDecimal.ZERO, true);
					Dao1.addAccount(acc);	
				} 	
				
				break;
				
			case "PersonalsavingAccount":
				AccountDao Dao2 = new AccountDaoImpl();
				if(acc.canOpen()) {
					acc = new personalSavingAccount(users, BigDecimal.ZERO, true);
					Dao2.addAccount(acc);	
				} 	
				break;
				
				   
			case "studentCheckingAccount":
				
					AccountDao Dao3 = new AccountDaoImpl();
					if(acc.canOpen()) {
					acc = new businessCheckinAccount(users, BigDecimal.ZERO, true);
					Dao3.addAccount(acc);	
					} 	
								
					break;
								
			case "businessSavingAccount":
				
				AccountDao Dao4 = new AccountDaoImpl();
				if(acc.canOpen()) {
				acc = new businessSavingAccount(users, BigDecimal.ZERO, true);
				Dao4.addAccount(acc);		
				}
					 break;
								
				     default:
				    	 
					break;
						    	   
		}
		return true;
	}
	
	}

