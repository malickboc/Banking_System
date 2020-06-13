package Account;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import user.User;



public class businessCheckinAccount extends Checking{
	
	private  int  Over_Draft_FEE = 35;
	private int  Over_Draf_Maximum = -7500;
	private int Minimum_Balance =0;
	private  int  MONTHLY_FEE =25;
	private final Boolean canOverdraft;

	

	/**
	 * 
	 * Created a constructor  a passed 3 values which are
	 * number and a BigDecimal Montant and Boolean canOverdraft
	 */

	
	
	public businessCheckinAccount(List<User> number, java.math.BigDecimal amount, Boolean canOverdraft) {
		super(number, amount);
		
		this.canOverdraft = canOverdraft;
	
	
	
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
	
	

	/**
	 * This function is Overriding base class and ADD the Over_Draft_FEE  to account
	 * 
	 * @return
	 */
	
	

    @Override
    

	public BigDecimal  Over_Draft_FEE () {
		return new BigDecimal(35);
	}
	  
    /**
  	 * This function is Overriding base class and ADD the  Over_Draf_Maximum  to account
  	 * 
  	 * @return
  	 */
    
    
    
    @Override
    
	 public BigDecimal  Over_Draf_Maximum (){
		return new BigDecimal(-7500);
	 }
    
    
    

    /**
     * If the number of transactions exceeds 100 per month,  there will .25 fee to account
     * The Method control The canOverdraft and must opt-in to over-drafting  of the customers. 
     * It check to see if the balance  is less then zero . 
     *     
     * 
     */
    
    @Override
    
	public java.math.BigDecimal withdraw(String amt) {
    	
    	if(super.TRansaction.length() >= 100 ) {
    		super.Balance.subtract(new BigDecimal(.25));
    	}
		
		BigDecimal amount = super.getValidAmount(amt);
		
		double newBalance = super.Balance.doubleValue() - amount.doubleValue();
		
		if(newBalance < 0) {
			if(canOverdraft) {
				super.withdraw(amt);
			}
		}
		
		return super.withdraw(amt);
	}


	



}