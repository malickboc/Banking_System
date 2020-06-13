package DAOImpl;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import DAO.TRansactionDao;
import transaction.TRansaction;
import user.User;

public class TRansactionDAOImpl implements TRansactionDao {

	private final static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private final static String DATABASE_URL = "jdbc:mysql://localhost:3306/Malick_Table?"
			+ "autoReconnect=true&useSSL=false";;
	private final static String USERNAME = "root";
	private final static String PASSWORD = "Yacineadou";
	private static final TRansaction idTransaction1 = null;
	private static final java.sql.Date StartDate = null;
	private static final java.util.Date Date = null;
	private static final java.util.Date EndDate = null;
	private static final String TransactionType = null;
	private Connection connection;

	Statement statement = null;
	private String idTransaction;
	private DateTimeFormatter formatter;

	/**
	 * This function is to get connect between java and Mysql after creating
	 * downloading mysql and make and database table you will all those credential
	 * that you will be using by creating a connection.Also In the same function I'm
	 * selecting and printing all the values from my database table that created to
	 * make sure that it work perfectly. Inside JDBC client code it will be
	 * connected to driver and use that to perform operation against database.It is
	 * pretty much connect to DB , perform CRUD , PROCESS RESPONSE , Handle
	 * exception and so on.
	 */

	public void getConnection() {
		// Statement statement = null;

		try {

			Class.forName(JDBC_DRIVER);

			connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);

			statement = connection.createStatement();

			String sql = "select * from Transaction1";

			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {

				int idTransaction1 = resultSet.getInt("idTransaction1");
				int TransactionN = resultSet.getInt("TransactionN");
				Date Date = resultSet.getDate("Date");
				java.sql.Date StartDate = resultSet.getDate("StartDate");
				Date EndDate = resultSet.getDate("EndDate");
				String TransactionType = resultSet.getString("TransactionType");
				String amount = resultSet.getString("amount");

				System.out.println(idTransaction1 + "  " + TransactionN + "  " + Date + "  " + StartDate + "  "
						+ EndDate + "  " + TransactionType + "  " + amount);

			}
			resultSet.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
	
	
	/**
	 * This getTransaction Method get all the transaction by transaction number from 
	 * my database I did it by using query functionality  to select fromTable
	 */

	@Override
	public List<TRansaction> getTransactions(int TransactionN) {

		List<TRansaction> ret = null;

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter TransactionN");

		int line = sc.nextInt();

		try {

			ret = new ArrayList<>();

			String sql = "select *from  Malick_table.Transaction1 Where TransactionN =" + line + ";";

			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setDate(1, (java.sql.Date) Date);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				ret.add(new TRansaction(rs.getInt("idTransaction1"), rs.getInt("TransactionN"), rs.getDate("StartDate"),
						rs.getDate("EndDate"), rs.getString("TransactionType"), rs.getString("amount")));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;

	}
	
	/**
	 * This getTransaction Method get all the transaction by transaction number from 
	 * my database I did it by using query functionality  to select fromTable
	 */

	@Override
	public List<TRansaction> getTransactions(int accountNum, LocalDate startdate, LocalDate endDate) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

	/**
	 * This updateTransaction Method get all the transaction by  using transactionN  from 
	 * my database and also I used update in my query to change the value to my DB
	 */

	@Override
	public boolean updateTransaction(TRansaction transationN) {

		boolean row1;

		Scanner input = new Scanner(System.in);

		System.out.print("Enter idTransaction1:");

		int idTransaction1 = input.nextInt();

		System.out.print("Enter TransactionN:");

		int TransactionN = input.nextInt();

		// int Date=input.nextInt();
		System.out.print("date:");
		int Date = input.nextInt();

		System.out.print("StartDate:");

		// java.sql.Date StartDate = input.nextInt();

		System.out.print("EndDate");

		// int EndDate = input.nextInt();

		System.out.print("Enter TransactionType:");

		String TransactionType = input.next();

		System.out.print("Enter Amount:");

		double Amount = input.nextDouble();

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
		Date date = null;

		try {
			connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);

			// statement = connection.createStatement();

			String sql = "UPDATE  Malick_table.Transaction1 SET  TransactionN=?, Date=?, StartDate=?,EndDate=?,TransactionType=?,amount=? Where idTransaction1=?;";

			PreparedStatement statement = connection.prepareStatement(sql);
			// statement.setInt(7, idTransaction1);
			statement.setInt(1, TransactionN);
			statement.setDate(2, Date());
			statement.setDate(3, Date());
			statement.setDate(4, Date());
			statement.setString(5, TransactionType);
			statement.setDouble(6, Amount);
			statement.setInt(7, idTransaction1);

			int row = statement.executeUpdate();

			System.out.println(row + "one row Update!");

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;

	}
	
	
	

	/**
	 * This writeTransaction Method allow to write the transaction by  using transactionN  from 
	 * my database and also I used Insert into in my sql to change the value to my DB
	 */

	@Override
	public boolean writeTransaction(TRansaction transactionN) {

		DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
		System.out.println("Enter date in the format yyyy-MM-d");
		System.out.println("For example, it is now " + format.format(new Date()));

		boolean row1;

		Scanner input = new Scanner(System.in);

		System.out.print("Enter idTransaction1:");

		int idTransaction1 = input.nextInt();

		System.out.print("Enter TransactionN:");

		int TransactionN = input.nextInt();

		System.out.print("date:");
		String Date = input.next();

		System.out.print("StartDate:");

		String StartDate = input.next();

		System.out.print("EndDate");

		String EndDate = input.next();

		System.out.print("Enter TransactionType:");

		String TransactionType = input.next();

		System.out.print("Enter Amount:");

		double Amount = input.nextDouble();

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
		Date date = null;

		try {
			LocalDate localdate1 = LocalDate.parse(Date);

			LocalDate localdate2 = LocalDate.parse(StartDate);

			LocalDate localdate3 = LocalDate.parse(EndDate);

			statement = connection.createStatement();

			String sql = "INSERT INTO Malick_table.Transaction1 values(?,?,?,?,?,?,?)";

			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setInt(1, idTransaction1);
			statement.setInt(2, TransactionN);
			statement.setDate(3, Date());
			statement.setDate(4, Date());
			statement.setDate(5, Date());
			statement.setString(6, TransactionType);
			statement.setDouble(7, Amount);

			int row = statement.executeUpdate();

			System.out.println(row + "one row Add!");

		}

		catch (SQLException e) {
			System.out.println("\nCrazy SQL Exception: " + e);

		}
		return false;

	}
	
	/**
	 * This getTransaction Method get all the transaction by transaction number from 
	 * my database I did it by using query functionality  to select fromTable
	 */

	@Override
	public TRansaction getTransaction(BigInteger transactionN) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter transactionN");
		TRansaction returnUser = null;
		String transactionN1 = sc.nextLine();

		try {

			connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);

			statement = connection.createStatement();

			String sql = ("SELECT * FROM Transaction1 WHERE transactionN =" + transactionN1 + ";");

			PreparedStatement ps = connection.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				System.out.print(rs.getInt(1) + "  " + rs.getInt(2) + " " + rs.getDate(3) + " " + rs.getDate(4) + " "
						+ rs.getDate(5) + " " + rs.getString(6) + rs.getDouble(7));

				System.out.println();

			}

			rs.close();

		} catch (SQLException e) {
			System.out.println("\nCrazy SQL Exception: " + e);

		}
		return returnUser;

	}

	

	/**
	 * this for helping change  date from java to mysql
	 * @return
	 */
	public static java.sql.Date Date() {
		java.util.Date today = new java.util.Date();
		return new java.sql.Date(today.getTime());
	}



	public void updateAdress(TRansaction us2) {
		// TODO Auto-generated method stub
		
	}

}