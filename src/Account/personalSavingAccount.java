package Account;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import user.User;

public class personalSavingAccount extends Saving {
	

	private  int  Minimum_Balance =25;
	private  int  MONTHLY_FEE =10;
	

	/**
	 * 
	 * Created a constructor  a passed 3 values which are
	 * number and a BigDecimal Montant and Boolean b
	 */

	public personalSavingAccount(List<User> number, BigDecimal Montant, boolean b) {
		super(number, Montant);
		// TODO Auto-generated constructor stub
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
		
		if(Calendar.DAY_OF_MONTH == lastDay  && (super.Balance.doubleValue() < 500)) {
			super.Balance.subtract(new BigDecimal("10"));
		}
		
	}
	
	
	/**
 	 * This function is Overriding base class and ADD the Minimum_Balance to account
 	 * 
 	 * @return
 	 */

	@Override
	public  BigDecimal  Minimum_Balance () {
		return new BigDecimal (25);
		
	}
	
	}
	
