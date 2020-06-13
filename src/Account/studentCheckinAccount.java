package Account;

import java.math.BigDecimal;
import java.util.List;

import user.User;



public class studentCheckinAccount extends Checking {
	
	
	

	
	private  int  Over_Draft_FEE = 35;
	private  int Over_Draf_Maximum = -500;
	private  int  Minimum_Balance = 0;
	private int  MONTHLY_FEE =0;
	private  Boolean canOverdraft;
	
	/**
	 * 
	 * Created a constructor  a passed 3 values which are
	 * number and a BigDecimal Montant and Boolean canOverdraft
	 */

	
	
	public studentCheckinAccount(List<User> users, java.math.BigDecimal amount, Boolean canOverdraft) {
		super(users, amount);
		this.canOverdraft = canOverdraft;
	}
	
	
	/**
	 * 
	 * This method is To check the open condition to see if the accountOwner can
	 * open the account . the customer must be greater or eagle the ages of 17 – 23
	 * or above 12 with an additional user above 18.
	 * 
	 */
	
	public boolean canOpen() {
		
		if(super.accountOwner.getAge() >= 17 || super.accountOwner.getAge() <= 23) {
			return true;
		}
		
		
		if(super.accountOwner.getAge() >= 12) {
			
			for(User u: super.authorizedUsers) {
				if(u.getAge() >= 18) {
					return true;
				}
			}
			
		}
		return false;
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
 		return new BigDecimal(-500);
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

	
	

