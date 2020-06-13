package DAOImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Account.Account;
import DAO.AccountDao;
import transaction.TRansaction;

public class BcheckingAccountDaoImpl implements AccountDao {

	private final static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private final static String DATABASE_URL = "jdbc:mysql://localhost:3306/Malick_Table?"
			+ "autoReconnect=true&useSSL=false";;
	private final static String USERNAME = "root";
	private final static String PASSWORD = "Yacineadou";
	private Connection connection;

	Statement statement = null;

	/**
	 * This function is to get connect between java and Mysql after creating
	 * downloading mysql and make and database table you will all those credential
	 * that you will be using by creating a connection.Also In the same function I'm
	 * selecting and printing all the values from my dabase table that created to
	 * make sure that it work perfectly. Inside JDBC client code it will be
	 * connected to driver and use that to perform operation against database.It is
	 * pretty much connect to DB , perform CRUD , PROCESS RESPONSE , Handle
	 * exception and so on.
	 */

	public void getConnection() {
		// Statement statement = null;

		try {

			// Register JDBC driver
			Class.forName(JDBC_DRIVER);

			// Open a connection
			connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
			statement = connection.createStatement();

			String sql = "select * from Malick_Table.CheckAccount3";

			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {

				int idCheckAccount3 = resultSet.getInt("idCheckAccount3");
				int Driverslicense = resultSet.getInt("Driverslicense");
				double Balance = resultSet.getDouble("Balance");
				double BusinessChecking = resultSet.getDouble("BusinessCheckingAc");

				System.out.println(idCheckAccount3 + "  " + Driverslicense + "  " + Balance + "  " + BusinessChecking);

			}
			resultSet.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * this function add account tom database
	 */

	@Override
	public boolean addAccount(Account account) {

		Scanner input = new Scanner(System.in);

		System.out.print("Enter idCheckingAccount:");

		int idCheckAccount3 = input.nextInt();

		System.out.print("Enter Driverslicense:");

		int Driverslicense = input.nextInt();

		System.out.print("Balance:");

		double Balance = input.nextDouble();

		System.out.print("BusinessCheckingAc:");

		double BusinessCheckingAc = input.nextDouble();

		try {

			statement = connection.createStatement();

			String sql = "INSERT INTO Malick_Table.CheckAccount3 values(?,?,?,?)";

			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, idCheckAccount3);
			statement.setDouble(2, Driverslicense);
			statement.setDouble(3, Balance);
			statement.setDouble(4, BusinessCheckingAc);

			int row = statement.executeUpdate();

			System.out.println(row + "one row Add!");

		}

		catch (SQLException e) {
			System.out.println("\nCrazy SQL Exception: " + e);

		}
		return false;

	}

	/**
	 * this fonction close account from our table database
	 */

	@Override
	public void closeAccount(int accountNumber) {

		Scanner input = new Scanner(System.in);
		System.out.println("enter Driver License Number to remove:");
		String idCheckAccount3 = input.nextLine();

		try {
			connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);

			String sql = "DELETE  from CheckAccount3 where idCheckAccount3= ?;";

			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setString(1, idCheckAccount3);
			int row = statement.executeUpdate();

			System.out.println(row + "one row Remove !");

		}

		catch (Exception e) {
			System.out.println("\nCrazy SQL Exception: " + e);

		}

	}

/**
 * this get all the list of account from database
 * 
 */
	@Override
	public List<Account> getAccounts(String driversLicense) {
		List<Account> ret = null;

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter driversLicense");

		int line = sc.nextInt();

		try {

			ret = new ArrayList<>();

			String sql = "select *from  Malick_table.CheckAccount3 Where idCheckAccount2 =" + line + ";";

			PreparedStatement statement = connection.prepareStatement(sql);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				ret.add(new TRansaction(rs.getInt("idCheckAccount3"), rs.getDouble("Driverslicense"),
						rs.getDouble("Balance"), rs.getDouble("BusinessCheckingAc")));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;

	}

	/**
	 * this update the account from database
	 */

	@Override
	public boolean updateAccount(Account account) {
		 boolean row1;
	      
		 Scanner input= new Scanner(System.in);
			
			System.out.print("Enter idCheckingAccount:");

			
			int idCheckAccount3= input.nextInt();
			

			System.out.print("Enter Driverslicense:");

	    int Driverslicense= input.nextInt();
	        
			System.out.print("Balance:");  
			
			double Balance= input.nextDouble();

			System.out.print("BusinessCheckingAc:");

			  double BusinessCheckingAc= input.nextDouble();
			

			
		
		try {
		
			connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
			



			String sql = "UPDATE  CheckAccount3 SET Driverslicense=?, Balance=?, BusinessCheckingAc=? Where idCheckAccount3=?;";
	
			
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setDouble(1,  Driverslicense);
			statement.setDouble(2,  Balance);
			statement.setDouble(3,  BusinessCheckingAc);
			statement.setInt(4, idCheckAccount3);
			
			 
		  int  row=statement.executeUpdate();
			
			    System.out.println(row+"one row Update!");
		
           
          
		
	} catch(Exception e) {
		 e.printStackTrace();
	}
		
		return false;

}

/**
 * this get a spefic range of account
 */

	@Override
	public Account getAccount(String accountNumber) {
		Scanner sc= new Scanner (System.in);
	      System.out.println("Enter accountNumber");
	      Account returnUser = null;
	      String driverLicense= sc.nextLine();
	      
	      
	    try {
	    
	      connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
			
			statement = connection.createStatement();
			
			String sql= ("SELECT * FROM  CheckAccount3  WHERE idCheckAccount3 ="+driverLicense+";");
	      
			PreparedStatement ps=connection.prepareStatement(sql);

			ResultSet rs=ps.executeQuery();
			
			while (rs.next()) {
				
				System.out.print(rs.getInt(1)+"  "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
	
				 
				System.out.println();
				
			}
			
			
			rs.close();

	
	}
	    catch (SQLException e) {
			System.out.println("\nCrazy SQL Exception: " + e);
		
			}
		
		
	return returnUser;
	
	}
	}
	
