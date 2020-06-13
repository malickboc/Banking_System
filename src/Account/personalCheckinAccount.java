package Account;

import java.util.List;

import user.User;

import java.math.BigDecimal;
import java.util.List;


public class personalCheckinAccount extends Checking {
	
	

	
	
	private  int Over_Draft_FEE = 35;
	private  int Over_Draf_Maximum = -1500;
	private int MONTHLY_FEE =10;
	private boolean canOverdraft;
	

	
	/**
	 * 
	 * Created a constructor  a passed 3 values which are
	 * number and a BigDecimal Montant and Boolean b
	 */

	 
    public personalCheckinAccount(List<User> users, java.math.BigDecimal amount, boolean b) {
		super(users, amount);
		// TODO Auto-generated constructor stub
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
 		return new BigDecimal(-1500);
 	 }
     
     

     
     /**
  	 * This function is  class and ADD the   MONTHLY_FEE  to account
  	 * 
  	 * @return
  	 */
     
     public BigDecimal  MONTHLY_FEE () {
		 return new BigDecimal(10);
		 
	 }
     
     
     
     
     /**
      * 
      * The Method control The canOverdraft and must opt-in to over-drafting  of the customers. 
      * It check to see if the balance  is less then zero . 
      *     
      * 
      */
     @Override
     
 	public java.math.BigDecimal withdraw(String amt) {
 		
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

	


	
	

