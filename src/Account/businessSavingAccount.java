package Account;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import user.User;

public class businessSavingAccount extends Saving {
	
	
	private  int Minimum_Balance =250;
	private  int  MONTHLY_FEE =25;
	
	
	/**
	 * 
	 * Created a constructor  a passed 3 values which are
	 * number and a BigDecimal Montant and Boolean b
	 */

	
	public businessSavingAccount(List<User> number, BigDecimal Montant, boolean b) {
		super(number, Montant);
		// TODO Auto-generated constructor stub
	}

	
	/**
	 * This Minimum Balance is overriding the parent by Changing The Minimum Balance
	 * amount
	 */

	@Override
	public  BigDecimal  Minimum_Balance () {
		return new BigDecimal (250);
		
	}
	
	
	/**
	 * 
	 * I'm Calendar object in this function to calculate the date and if the date is
	 * the last day of the month and the balance is less then 250 so the fee will be
	 * apply to account
	 */
	
	public void chargeMinimumBalanceFeeAtEndOfMonth() {
		
		Calendar c =  Calendar.getInstance();
		
		int lastDay = c.getActualMaximum(Calendar.DAY_OF_MONTH);
		
		if(Calendar.DAY_OF_MONTH == lastDay  && (super.Balance.doubleValue() < 2500)) {
			super.Balance.subtract(new BigDecimal("25"));
		}
	}
	
	
}
	
	