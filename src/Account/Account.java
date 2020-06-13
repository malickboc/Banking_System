package Account;

import java.math.BigDecimal;
import java.util.List;

import DAO.AccountDao;
import transaction.TRansaction;
import user.User;



/**
 * Malick Bocoum
**/

public abstract class Account {
	public static final String AccountDAO = null;

	/**
	 * Declaring instance variable and make it private
	 */
	private static int nextUniqueAccountNumber = 0;
	
	protected BigDecimal Balance;
	protected List<User> authorizedUsers;
	protected List<TRansaction> transactions;
	protected AccountDao AccountDao;
	
	public List<User> getAuthorizedUsers() {
		return authorizedUsers;
	}

	public void setAuthorizedUsers(List<User> authorizedUsers) {
		this.authorizedUsers = authorizedUsers;
	}


	protected User accountOwner;
	protected int accountNumber;
	protected AcountsState accountState;
	

	/**
	 * Constructor for Account used when creating a new Account.
	 * 
	 * @param accountBalance: The initial account balance.
	 * @param accountOwner:   The primary account owner.
	
	/**
	 * Constructor for Account used when loading from a database.
	 * 
	 * @param accountBalance: The most recent account balance.
	 * @param accountOwner:   The primary account owner.
	 * @param accountNumber:  The account number.
	 */
	public Account(BigDecimal accountBalance, List<User> authorizedUsers, User accountOwner, int accountNumber,AcountsState accountState) {
		this.Balance = accountBalance;
		this.accountOwner = accountOwner;
		this.accountNumber = accountNumber;
		this.accountState = accountState;
		this.authorizedUsers = authorizedUsers;
	
	}


	/**
	 * Constructor for Account used when loading from a database.
	 * 
	 * @param accountBalance: The most recent account balance.
	 * @param accountOwner:   The primary account owner.
	 * @param accountNumber:  The account number.
	 */
	

	public Account(List<User> users, BigDecimal balance) {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Created and abstract Method for Withdraw Account.Withdraws a valid amount
	 * from an account. The amount to withdraw passed from the command line
	 * 
	 * @return The updated account balance
	 * 
	 */
	public abstract BigDecimal withdraw(String amount);

	

	/**
	 * Created and abstract Method for Deposit account.Deposits a valid amount into
	 * an account. The amount to deposit passed from the command line
	 * 
	 * @return The updated account balance
	 */
	public abstract BigDecimal deposit(String amount);

	/**
	 * 
	 * 
	 * @return A BigDecimal representation of the amount
	 * @throws IllegalArgumentException if the amount is not in a valid form
	 * 
	 */

	public BigDecimal getValidAmount(String amount) {
		BigDecimal validamount = null;

		if ((amount.contains("[a-zA-Z]+") == false && amount.length() > 0)) {
			validamount = new BigDecimal(amount);
		}

		return validamount;
	}
	
	
	/**
	 * Gets the next available account number with no duplicates.
	 * 
	 * @return: The next unique account id.
	 */
	static int getNextAccountNumber() {
		nextUniqueAccountNumber++;
		return nextUniqueAccountNumber;
	}

	
	public int compareTo(Account other) {
		return other.getBalance().compareTo(this.getBalance());
	}

	/**
	 * 
	 * Printing the output in the string format
	 */
	

	@Override
	public String toString() {
		return "Account [balance=" + Balance + ", AccountOwner=" + accountOwner + "]";
	}


	public BigDecimal getBalance() {
		return Balance;
	}


	public void setBalance(BigDecimal balance) {
		this.Balance = balance;
	}


	public User getAccountOwner() {
		return accountOwner;
	}


	public void setAccountOwner(List<String> accountOwner) {
		accountOwner = accountOwner;
	}

	public void setAcountsState(AcountsState notOverdrawn) {
		// TODO Auto-generated method stub
		
	}

	public AcountsState getAccountState() {
		return accountState;
	}

	
	public void setAccountState(AcountsState accountState) {
		this.accountState = accountState;
	}

	public boolean canOpen() {
		// TODO Auto-generated method stub
		return false;
	}


}
