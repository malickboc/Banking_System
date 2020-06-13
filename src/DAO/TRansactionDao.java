package DAO;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;

import transaction.TRansaction;

public interface TRansactionDao {
	
	public TRansaction getTransaction(BigInteger transactionNumber);

	
	public List<TRansaction> getTransactions(int accountNum);
	
	
	public List<TRansaction> getTransactions(int accountNum, LocalDate startdate , LocalDate endDate);
	
	
	public boolean  updateTransaction(TRansaction transation);
	
	
	public boolean writeTransaction ( TRansaction transaction);


	


	


	

	
	
	

}
