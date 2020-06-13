package Account;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import user.User;

public class studentSavingAccount extends Saving {

	private int Minimum_Balance = 5;
	private int MONTHLY_FEE = 5;
	
	
	/**
	 * 
	 * Created a constructor  a passed 3 values which are
	 * number and a BigDecimal Montant and Boolean b
	 */

	
	

	public studentSavingAccount(List<User> number, BigDecimal Montant, boolean b) {
		super(number, Montant);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * This method is To check the open condition to see if the accountOwner can
	 * open the account . the customer must be greater or eagle the ages of 17 – 23
	 * or above 12 with an additional user above 18.
	 * 
	 */

	public boolean canOpen() {

		if (super.accountOwner.getAge() >= 17 || super.accountOwner.getAge() <= 23) {
			return true;
		}

		if (super.accountOwner.getAge() >= 12) {

			for (User u : super.authorizedUsers) {
				if (u.getAge() >= 18) {
					return true;
				}
			}

		}
		return false;
	}

	/**
	 * This function is for Adding the Monthly fee to account
	 * 
	 * @return
	 */
	public BigDecimal MONTHLY_FEE() {
		return new BigDecimal(5);

	}

	/**
	 * 
	 * I'm Calendar object in this function to calculate the date and if the date is
	 * the last day of the month and the balance is less then 250 so the fee will be
	 * apply to account
	 */

	public void chargeMinimumBalanceFeeAtEndOfMonth() {

		Calendar c = Calendar.getInstance();

		int lastDay = c.getActualMaximum(Calendar.DAY_OF_MONTH);

		if (Calendar.DAY_OF_MONTH == lastDay && (super.Balance.doubleValue() < 250)) {
			super.Balance.subtract(new BigDecimal("25"));
		}

	}

	/**
	 * This Minimum Balance is overriding the parent by Changing The Minimum Balance
	 * amount
	 */

	@Override
	public BigDecimal Minimum_Balance() {
		return new BigDecimal(5);

	}

}
