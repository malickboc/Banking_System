package transaction;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;

public class TRansaction {
	
	private BigInteger transactionNumber;
	private LocalDate Date;
	 private BigDecimal amount;
	 private TRansaction transactionType;
	 private LocalDate date;
	 
	 
	 
	public TRansaction(LocalDate date) {
		super();
		this.date = date;
	}



	public BigInteger getTransactionNumber() {
		return transactionNumber;
	}



	public void setTransactionNumber(BigInteger transactionNumber) {
		this.transactionNumber = transactionNumber;
	}



	public LocalDate getDate() {
		return Date;
	}



	public void setDate(LocalDate date) {
		this.Date =date  ;
	}



	public BigDecimal getAmount() {
		return amount;
	}



	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}



	public TRansaction getTransactionType() {
		return transactionType;
	}



	public void setTransactionType(TRansaction transactionType) {
		this.transactionType = transactionType;
	}



	public TRansaction(BigInteger transactionNumber, LocalDate date, BigDecimal amount,
			TRansaction transactionType) {
		super();
		this.transactionNumber = transactionNumber;
		Date = date;
		this.amount = amount;
		this.transactionType = transactionType;
		
		
		
	}



	public TRansaction(int int1, int int2, java.sql.Date date2, java.sql.Date date3, java.sql.Date date4, String string,
			String string2) {
		// TODO Auto-generated constructor stub
	}



	public TRansaction(int i, int j, String string, String string2, String string3, String string4) {
		// TODO Auto-generated constructor stub
	}



	public TRansaction(int int1, int int2, java.sql.Date date2, java.sql.Date date3, String string, String string2) {
		// TODO Auto-generated constructor stub
	}



	public TRansaction(int int1, double double1, double double2, double double3, double d, double e,
			double f, double g) {
		// TODO Auto-generated constructor stub
	}



	public TRansaction(int int1, double double1, double double2, double double3) {
		// TODO Auto-generated constructor stub
	}



	public char[] get(int i) {
		// TODO Auto-generated method stub
		return null;
	}





	 
	
	
	

}
