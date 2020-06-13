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
import user.User;

public class StsavingAccountDaoImpl implements AccountDao {
	
	
	private final static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private final static String DATABASE_URL = "jdbc:mysql://localhost:------_Table?" + "autoReconnect=true&useSSL=false";;
	private final static String USERNAME = "root";
	private final static String PASSWORD = "-------";
	private Connection connection;
	
	Statement statement = null;
	
	
	/**
	 * This function is to get connect between java and Mysql after creating
	 * downloading mysql and make and database table you will all those credential that 
	 * you will be using by creating a connection.Also In the same function I'm selecting
	 * and printing all the values from my dabase table that created to make sure that it work perfectly.
	 * Inside JDBC client code it will be connected to driver and use that to perform operation against
	 * database.It is pretty much connect to DB , perform CRUD , PROCESS RESPONSE , Handle exception and so on.
	 */
	
	public void getConnection() {
		//Statement statement = null;

		try {

			// Register JDBC driver
			Class.forName(JDBC_DRIVER);

			// Open a connection
			connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
			statement = connection.createStatement();

			String sql = "select * from Malick_Table. SavingAccount2";
			

			ResultSet resultSet = statement.executeQuery(sql);
             
			while (resultSet.next()) {
				
				int idSavingAccount1 =resultSet.getInt("idCheckAccount1");
				int Driverslicense = resultSet.getInt("Driverslicense");
	           double Balance= resultSet.getDouble("Balance");
				double StudentSavingAc = resultSet.getDouble("StudentSavingAc");
				
				
				
				
				System.out.println(idSavingAccount1 +"  " +Driverslicense+"  "+ Balance + "  " +StudentSavingAc );
				
			}
			resultSet.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	
	
	/**
	 * This function add account to StsavingAccountDao I ask 
	 * user to give an account  that it would like to add to a database
	 * account .It is done by Insert into
	 */

	@Override

	public boolean addAccount(Account account) {

		 Scanner input= new Scanner(System.in);
			
			System.out.print("Enter idSavingAccount1:");

			
			int idSavingAccount1= input.nextInt();
			

			System.out.print("Enter Driverslicense:");

	    int Driverslicense= input.nextInt();
	        
			System.out.print("Balance:");  
			
			double Balance= input.nextDouble();

			System.out.print("StudentSavingAc:");

			  double StudentSavingAc= input.nextDouble();
			

			
			

			try {


				
				statement  = connection.createStatement();
			
				String sql = "INSERT INTO Malick_Table. SavingAccount2 values(?,?,?,?)";
						
										  
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setInt(1, idSavingAccount1);
				statement.setDouble(2,  Driverslicense);
				statement.setDouble(3,  Balance);
				statement.setDouble(4,  StudentSavingAc);
				
			  int  row=statement.executeUpdate();
				
				    System.out.println(row+"one row Add!");
			
		        
					    
						}
						 
					catch (SQLException e) {
					System.out.println("\nCrazy SQL Exception: " + e);
				
					}
			return false;

	}

	/**
	 * This closeAccount function get accountNumber and ask user
	 * to know which specific account number from a table it would like to deleted 
	 * that is done Delete from .
	 */
	
	@Override
	public void closeAccount(int accountNumber) {

		Scanner input = new Scanner(System.in);
		System.out.println("enter Driver License Number to remove:");
		String idSavingAccount1= input.nextLine();
		
		
		try {
			connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
			
			String sql= "DELETE  from  SavingAccount2 where idSavingAccount1= ?;";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			  
			statement.setString(1, idSavingAccount1);
			int row=statement.executeUpdate();
			
				 System.out.println(row+"one row Remove !");
				
			
		}

		 catch (Exception e) {
				System.out.println("\nCrazy SQL Exception: " + e);
			
				}
		
		
	}

	/**
	 * This getAccount Method get all the account by using driverslicense  number from 
	 * my database I did it by using query functionality  to select fromTable
	 */

	@Override
	public List<Account> getAccounts(String driversLicense) {
		List<Account> ret = null;

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter TransactionN");

		int line = sc.nextInt();

		try {

			ret = new ArrayList<>();

			String sql = "select *from  Malick_table.SavingAccount2 Where TransactionN =" + line + ";";

			PreparedStatement statement = connection.prepareStatement(sql);

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
	 * This updateAccount Method get all the transaction by  using account  from 
	 * my database and also I used update in my query to change the value to my DB
	 */


	@Override
	public boolean updateAccount(Account account) {
		
		boolean row1;
	      
		 Scanner input= new Scanner(System.in);
			
			System.out.print("Enter idCheckingAccount:");

			
			int idSavingAccount1= input.nextInt();
			

			System.out.print("Enter Driverslicense:");

	    int Driverslicense= input.nextInt();
	        
			System.out.print("Balance:");  
			
			double Balance= input.nextDouble();

			System.out.print("StudentSavingAc:");

			  double StudentSavingAc= input.nextDouble();
			

			
		
		try {
		
			connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
			



			String sql = "UPDATE   SavingAccount2 SET Driverslicense=?, Balance=?, StudentSavingAc=? Where idSavingAccount1=?;";
	
			
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setDouble(1,  Driverslicense);
			statement.setDouble(2,  Balance);
			statement.setDouble(3,  StudentSavingAc);
			statement.setInt(4, idSavingAccount1);
			
			 
		  int  row=statement.executeUpdate();
			
			    System.out.println(row+"one row Update!");
		
          
         
		
	} catch(Exception e) {
		 e.printStackTrace();
	}
		
		return false;

	}



	/**
	 * This getAccount Method get all the transaction by accountNumber number from 
	 * my database I did it by using query functionality  to select fromTable
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
			
			String sql= ("SELECT * FROM  SavingAccount2  WHERE idSavingAccount1 ="+driverLicense+";");
	      
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

