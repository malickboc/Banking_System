package Controller;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.List;

import DAO.TRansactionDao;
import DAO.UserDAO;
import DAOImpl.TRansactionDAOImpl;
import DAOImpl.UserDAOImpl;
import transaction.TRansaction;
import user.User;

public class transactionService {
	
	TRansactionDao dao = new TRansactionDAOImpl();

	/**
	 * Add Transaction to DAtabase
	 * 
	 * @throws Exception
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */

	public boolean writeTransaction(TRansaction transaction) throws ClassNotFoundException, SQLException, Exception {

		return dao.writeTransaction(transaction);

	}

	/**
	 * 
	 * Get the list of  transaction from Database
	 * 
	 * @throws ParseException
	 * @throws FileNotFoundException
	 * 
	 */

	public List<TRansaction> getTransaction(int accountNumber) throws FileNotFoundException, ParseException {

		return dao.getTransactions( accountNumber);
	}

	/**
	 * 
	 * update transaction from Database
	 * 
	 */

	public boolean updateTransaction(TRansaction transaction) {

		return dao.updateTransaction(transaction);
	}

	/**
	 * 
	 * get the list of Transaction from Database
	 * 
	 */

	public List<TRansaction> getTransactions(LocalDate startdate,LocalDate endDate) {
		return dao.getTransactions(1, startdate,endDate);
	}

}
