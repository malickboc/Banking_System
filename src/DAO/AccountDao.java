package DAO;



import java.math.BigInteger;
import java.util.List;

import Account.Account;
import user.User;

public interface AccountDao {
	
	
	
	public  boolean addAccount(Account account);
	
	
	public void closeAccount (int accountNumber);
	
	public  List<Account>  getAccounts(String driversLicense);
	
	public  boolean updateAccount(Account account);


	public Account getAccount(String accountNumber);


	
	

}
