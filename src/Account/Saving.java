package Account;

import java.math.BigDecimal;
import java.util.List;

import user.User;

/**
 * 
 */

public class Saving extends Account {

	/**
	 * 
	 * Created a constructor for a Saving account which passed two values a String
	 * number and a BigDecimal Montant.
	 */

	public Saving(List<User> number, BigDecimal Montant) {
		super(number, Montant);
	}

	/**
	 * 
	 * I'm Overriding by implemented the withdraw class from an Account class. this
	 * withdraw class first check the user input then it withdraw able if the amount
	 * request by the user minus the balance is not same to zero by making a
	 * comparison.
	 * 
	 * 
	 */
	
	/**
	 * This function  Minimum_Balance   add a fee to a users
	 * @return
	 */
 
	
	public  BigDecimal  Minimum_Balance () {
		return new BigDecimal (5);
		
	}

	/**
	 * This function is to determine the  Over_Draf_Maximum  for a users
	 * @return
	 */
	  
	
	 public BigDecimal  Over_Draf_Minimum (){
			return new BigDecimal(5);
		 }

	 
	 
	 
	 /**
		 * 
		 * I'm Overriding by implemented the withdraw class from an Account class. this
		 * withdraw class first check the user input then it withdraw able if the amount
		 * request by the user minus the balance is not same to zero by making a
		 * comparison.
		 * 
		 * 
		 */
	 
	 
	@Override
	public BigDecimal withdraw(String amt) {

		BigDecimal amount = null;

		if (super.getValidAmount(amt) == null) {
			System.out.println("You entered invalid characters");
			return null;
		} else {
			amount = new BigDecimal(amt);
		}

		if (amount.compareTo(BigDecimal.ZERO) <= 0) {
			System.out.println("Can only withdraw positive amount");
		} else if (super.getBalance().subtract(amount).compareTo(Minimum_Balance ()) < 0) {
			System.out.println("Not enough found to withdraw");
		} else {

			super.setBalance(getBalance().subtract(amount));
		}
		return super.getBalance();
	}
	
	
	
	

	/**
	 * 
	 * I'm Overriding by implemented the Deposit class from an Account class. this
	 * Deposit class first check to see if user put correctly the amount .
	 * 
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
			System.out.println("The amount is not valide");

		} else {
			super.setBalance(getBalance().add(amount));
		}

		return super.getBalance();
	}

}
