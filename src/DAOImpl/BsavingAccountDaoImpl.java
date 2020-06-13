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

public class BsavingAccountDaoImpl implements AccountDao{

	private final static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private final static String DATABASE_URL = "jdbc:mysql://localhost:3306/Malick_Table?" + "autoReconnect=true&useSSL=false";;
	private final static String USERNAME = "root";
	private final static String PASSWORD = "Yacineadou";
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

			String sql = "select * from Malick_Table.SavingAccount3";
			

			ResultSet resultSet = statement.executeQuery(sql);
             
			while (resultSet.next()) {
				
				int idSavingAccount2 =resultSet.getInt("idSavingAccount2");
				int Driverslicense = resultSet.getInt("Driverslicense");
	           double Balance= resultSet.getDouble("Balance");
				double BusinessSavingAc = resultSet.getDouble("BusinessSavingAc");
				
				
				
				
				System.out.println(idSavingAccount2 +"  " +Driverslicense+"  "+ Balance + "  " +BusinessSavingAc );
				
			}
			resultSet.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	
	/**
	 * this function add account o our database table
	 */
	

	@Override
	public boolean addAccount(Account account) {
		
       Scanner input= new Scanner(System.in);
		
		System.out.print("EnteridSavingAccount2:");

		
		int idSavingAccount2= input.nextInt();
		

		System.out.print("Enter Driverslicense:");

    int Driverslicense= input.nextInt();
        
		System.out.print("Balance:");  
		
		double Balance= input.nextDouble();

		System.out.print("BusinessSavingAc:");

		  double BusinessSavingAc= input.nextDouble();
		

		
		

		try {


			
			statement  = connection.createStatement();
		
			String sql = "INSERT INTO Malick_Table.SavingAccount3 values(?,?,?,?)";
					
									  
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, idSavingAccount2);
			statement.setDouble(2,  Driverslicense);
			statement.setDouble(3,  Balance);
			statement.setDouble(4,  BusinessSavingAc);
			
		  int  row=statement.executeUpdate();
			
			    System.out.println(row+"one row Add!");
		 
				    
					}
					 
				catch (SQLException e) {
				System.out.println("\nCrazy SQL Exception: " + e);
			
				}
		return false;
	
	}
	
	/**
	 * this method close the record of user from database
	 */

	@Override
	public void closeAccount(int accountNumber) {
		
		Scanner input = new Scanner(System.in);
		System.out.println("enter Driver License Number to remove:");
		String idSavinAccount2= input.nextLine();
		
		
		try {
			connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
			
			String sql= "DELETE  from SavingAccount3 where idSavingAccount2= ?;";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			  
			statement.setString(1, idSavinAccount2);
			int row=statement.executeUpdate();
			
				 System.out.println(row+"one row Remove !");
				
			
		}

		 catch (Exception e) {
				System.out.println("\nCrazy SQL Exception: " + e);
			
				}
		
		
	}
	/**
	 * this account get all the account record from DB
	 */

	@Override
	public List<Account> getAccounts(String driversLicense) {
		List<Account> ret = null;

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter driversLicense");

		int line = sc.nextInt();

		try {

			ret = new ArrayList<>();

			String sql = "select *from  Malick_table.SavingAccount3 Where idSavingAccount2 =" + line + ";";

			PreparedStatement statement = connection.prepareStatement(sql);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				ret.add(new TRansaction(rs.getInt("idCheckAccount3"), rs.getDouble("Driverslicense"),
						rs.getDouble("Balance"), rs.getDouble("BusinessSavingAc")));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
		
	}
	
	/**
	 * this method update the records by having the new information
	 */

	@Override
	public boolean updateAccount(Account account) {
		 boolean row1;
	      
		 Scanner input= new Scanner(System.in);
			
			System.out.print("Enter idSavingAccount2:");

			
			int idSavingAccount2= input.nextInt();
			

			System.out.print("Enter Driverslicense:");

	    int Driverslicense= input.nextInt();
	        
			System.out.print("Balance:");  
			
			double Balance= input.nextDouble();

			System.out.print("BusinessSavingAc:");

			  double BusinessSavingAc= input.nextDouble();
			

			
		
		try {
		
			connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
			



			String sql = "UPDATE  SavingAccount3 SET Driverslicense=?, Balance=?, BusinessSavingAc=? Where idSavingAccount2=?;";
	
			
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setDouble(1,  Driverslicense);
			statement.setDouble(2,  Balance);
			statement.setDouble(3,  BusinessSavingAc);
			statement.setInt(4, idSavingAccount2);
			
			 
		  int  row=statement.executeUpdate();
			
			    System.out.println(row+"one row Update!");
		
           
          
		
	} catch(Exception e) {
		 e.printStackTrace();
	}
		
		return false;

}


/**
 * this method get a specific range of account that user will aske.
 * after using a driverlicense number it will select the speceific account.
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
			
			String sql= ("SELECT * FROM  SavingAccount3  WHERE idSavingAccount2 ="+driverLicense+";");
	      
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
