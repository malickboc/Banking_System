package Account;


import java.math.BigDecimal;
import java.util.List;

import user.User;

/**
 * 
 *
 */

public class Checking extends Account {

	public static final String TRansactions = null;
	public static final String TRansaction = null;
	private AcountsState isOver;
	private BigDecimal BigDecimal;

	/**
	 * 
	 * Created a constructor for a Checking account which passed two values a String
	 * number and a BigDecimal Montant.
	 */

	public Checking(List<User> users, BigDecimal amount) {
		super(users, amount);
		this.isOver = AcountsState.NOT_OVERDRAWN;

	}

	

	/**
	 * This Over_Draft_FEE function help the child class to change
	 * the value in this class
	 * @return
	 */
	
	public BigDecimal  Over_Draft_FEE () {
		return new BigDecimal(1000);
	}
	
	/**
	 * This function is to determine the  Over_Draf_Maximum  for a users
	 * @return
	 */
	  
	 public BigDecimal  Over_Draf_Maximum (){
		return new BigDecimal(-1000);
	 }
	 
	 /**
		 * This function   MONTHLY_FEE add a fee to a users
		 * @return
		 */
	 
	 public BigDecimal  MONTHLY_FEE () {
		 return new BigDecimal(100);
		 
	 }
	 
	 
	 
	 
	 /**
		 * 
		 * 
		 * I'm Overriding by implemented the withdraw class from an Account class. this
		 * withdraw class check first to see if the user enter values are correct or not
		 * .After check to see if the value withdraw from the account give a negative
		 * balance or not. then if if the Account result a negative balance to set the
		 * account status to OVERDRAWN OR NOT_OVERDRAWN by using enum. and a fees .Also
		 * it allow the user to only overdraft up to 1000.
		 * 
		 */
	 
   @Override
   

	public BigDecimal withdraw(String amt) {

		BigDecimal amount = super.getValidAmount(amt);

		if (amount == null) {
			System.out.println("You entered invalid characters");
			return null;
		}

		if (amount.compareTo(BigDecimal.ZERO) <= 0) {

			System.out.println("You can only withdraw a positive amount");

		} else if (super.getBalance().subtract(amount).compareTo(Over_Draf_Maximum()) < 0) {

			System.out.println("Insufficient amount");

		} else if (super.getBalance().subtract(amount).compareTo(BigDecimal.ZERO) < 0) {

			setAccountState(AcountsState.OVERDRAWN);

			setBalance(super.getBalance().subtract(amount).subtract((Over_Draft_FEE ())));

			System.out.println("Account was overdrawn");

		} 
		else if (super.getBalance().subtract(amount).compareTo(BigDecimal.ZERO) > 0) {
			setAccountState(AcountsState.NOT_OVERDRAWN);

			setBalance(super.getBalance().subtract(amount));
		}
		return super.getBalance();
	}
	

	
	



	/**
	 * 
	 * I'm Overriding by implemented the Deposit class from an Account class. this
	 * Deposit class check first to see if the amount enter by the user is correct.
	 * Then It will let the user know that it can only Make a deposit of a positive
	 * amount. At the end if the balance add to amount make account Overdrawn to
	 * set the account state to Active.
	 */
	
	@Override
	public BigDecimal deposit(String amt) {

		BigDecimal amount = null;

		if (super.getValidAmount(amt) == null) {
			System.out.println("You entered invalid characters");
			return null;
		} else {
			amount = new BigDecimal(amt);
		}

		if (amount.compareTo(BigDecimal.ZERO) <= 0) {

			System.out.println("You can only deposit positive amount");
		}

		else {
			super.setBalance(getBalance().add(amount));

			if (super.getAccountState() == AcountsState.OVERDRAWN
					&& super.getBalance().compareTo(BigDecimal.ZERO) > 0) {

				super.setAcountsState(AcountsState.NOT_OVERDRAWN);

			}
			super.setBalance(getBalance().add(amount));

			

		}

		return super.getBalance();
	}
}
