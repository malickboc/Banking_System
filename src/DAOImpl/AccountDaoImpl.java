package DAOImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import Account.Account;
import DAO.AccountDao;
import transaction.TRansaction;

public class AccountDaoImpl implements AccountDao {
	
	
	
	private final static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private final static String DATABASE_URL = "jdbc:mysql://localhost:............?" + "autoReconnect=true&useSSL=false";;
	private final static String USERNAME = "root";
	private final static String PASSWORD = "";
	private static final TRansaction idTransaction1 = null;
	private Connection connection;
	
	Statement statement = null;
	private String idTransaction;
	private java.util.Date formatter;
	
	
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

			String sql = "select * from Malick_Table.GenerateTransaction";
			

			ResultSet resultSet = statement.executeQuery(sql);
             
			while (resultSet.next()) {
				
				int idGenerateTransaction =resultSet.getInt("idGenerateTransaction");
				int Balance = resultSet.getInt("Balance");
	           double businessSavingAc= resultSet.getDouble("businessSavingAc");
				double StudentCheckingAc = resultSet.getDouble("StudentCheckingAc");
				double PersonalCheckingAc= resultSet.getDouble("PersonalCheckingAc");
				double BusinessCheckingAc = resultSet.getDouble("BusinessCheckingAc");
				double StudentSavingAc = resultSet.getDouble("StudentSavingAc");
				double personalSavingAc = resultSet.getDouble("personalSavingAc");
				
				
				
				System.out.println(idGenerateTransaction +"  " +Balance+"  "+ businessSavingAc + "  " +StudentCheckingAc + "  " + PersonalCheckingAc + "  " + BusinessCheckingAc+"  "+StudentSavingAc+" "+personalSavingAc);
				
			}
			resultSet.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	
	/**
	 * 
	 * this add a new account to a database it is done by insert into
	 */

	@Override
	public boolean addAccount(Account account) {
		
		Scanner input= new Scanner(System.in);
		
		System.out.print("Enter idGenerateTransaction:");

		
		int idGenerateTransaction= input.nextInt();
		

		System.out.print("Enter Balance:");

       double Balance= input.nextDouble();

        
        
		System.out.print("businessSavingAc:");  
		
		double businessSavingAc= input.nextDouble();

		System.out.print("StudentCheckingAc:");

		  double StudentCheckingAc= input.nextDouble();
		

		System.out.print("PersonalCheckingAc");
		
		  double PersonalCheckingAc= input.nextDouble();
		

		System.out.print("Enter BusinessCheckingAc:");

		  double BusinessCheckingAc= input.nextDouble();
     
		System.out.print("Enter StudentSavingAc:");

		  double StudentSavingAc= input.nextDouble();
		  
		  System.out.print("Enter personalSavingAc:");

		  double personalSavingAc= input.nextDouble();
		

		try {


			
			statement  = connection.createStatement();
		
			String sql = "INSERT INTO Malick_Table.GenerateTransaction values(?,?,?,?,?,?,?,?)";
					
									  
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, idGenerateTransaction);
			statement.setDouble(2,  Balance);
			statement.setDouble(3,  businessSavingAc);
			statement.setDouble(4,  StudentCheckingAc);
			statement.setDouble(5,  PersonalCheckingAc);
			statement.setDouble(6,  BusinessCheckingAc);
			statement.setDouble(7,  StudentSavingAc);
			statement.setDouble(8,  personalSavingAc);
			
			
			
		  int  row=statement.executeUpdate();
			
			    System.out.println(row+"one row Add!");
		
	        
				    
					}
					 
				catch (SQLException e) {
				System.out.println("\nCrazy SQL Exception: " + e);
			
				}
		return false;
		

	}
	

	/**
	 * This close the account by using user accountNymber
	 */

	

	@Override
	public void closeAccount(int accountNumber) {
		Scanner input = new Scanner(System.in);
		System.out.println("enter Driver License Number to remove:");
		String idGenerateTrans= input.nextLine();
		
		
		try {
			connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
			
			String sql= "DELETE  from GenerateTransaction where idGenerateTransaction= ?;";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			  
			statement.setString(1, idGenerateTrans);
			int row=statement.executeUpdate();
			
				 System.out.println(row+"one row Remove !");
				
			
		}
		
		
		
		 catch (Exception e) {
				System.out.println("\nCrazy SQL Exception: " + e);
			
				}
		

		
		
		
		
	}

	
	
	/**
	 * 
	 * this get account by usind driverlicense number
	 */
	@Override
	public List<Account> getAccounts(String driversLicense) {
		
		
		
		
		
		
		List<Account> AC = null;
	     
	      Scanner sc= new Scanner (System.in);
	      System.out.println("Enter TransactionN");
	      
	    	  
	     
	    	int line = sc.nextInt();
	   
	      
	    	  
	    	 
	    try {
	    	
	    	
	    	   AC = new ArrayList<>();
	    	 
	    	    String sql = "select *from  Malick_table.Transaction1 Where idGenerateTransaction ="+ line+";" ;
	    	    
	    	    PreparedStatement statement = connection.prepareStatement(sql);
	    	   
	    	    java.sql.Date Date;
				statement.setDate(1,(java.sql.Date) Date);
	    	    ResultSet rs = statement.executeQuery();
	    	    
	    	    while(rs.next()) {
	    	    	
	    	   AC.add(new Account(rs.getInt("idGenerateTransaction"),rs.getDouble("Balance"),rs.getDouble("businessSavingAc"),rs.getDouble("StudentCheckingAc"),rs.getDouble("PersonalCheckingAc"),rs.getDouble("BusinessCheckingAc"),rs.getDouble("StudentSavingAc"),rs.getDouble("personalSavingAc")));
	    	    
	    	    }
	    }
	    catch(Exception e) {
			 e.printStackTrace();
		}
	    
	    
		return AC;
		
		
		
	}
	
	
	

	/**
	 * this update account to a new values
	 */
	@Override
		public boolean updateAccount(Account account) {
	      boolean row1;
	      
	      Scanner input= new Scanner(System.in);
			
			System.out.print("Enter idGenerateTransaction:");

			
			int idGenerateTransaction= input.nextInt();
			

			System.out.print("Enter Balance:");

	       double Balance= input.nextDouble();

	        
			System.out.print("businessSavingAc:");  
			
			double businessSavingAc= input.nextDouble();

			System.out.print("StudentCheckingAc:");

			  double StudentCheckingAc= input.nextDouble();
			

			System.out.print("PersonalCheckingAc");
			
			  double PersonalCheckingAc= input.nextDouble();
			

			System.out.print("Enter BusinessCheckingAc:");

			  double BusinessCheckingAc= input.nextDouble();
	     
			System.out.print("Enter StudentSavingAc:");

			  double StudentSavingAc= input.nextDouble();
			  
			  System.out.print("Enter personalSavingAc:");

			  double personalSavingAc= input.nextDouble();
		
                 
	
		
		try {
		
			connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
			



			String sql = "UPDATE  idGenerateTransaction SET Balance=?, businessSavingAc=?, StudentCheckingAc=?, PersonalCheckingAc=?,BusinessCheckingAc=?,StudentSavingAc=?, personalSavingAc=? Where idGenerateTransaction=?;";
	
			
			PreparedStatement statement = connection.prepareStatement(sql);
		
			statement.setDouble(1,  Balance);
			statement.setDouble(2,  businessSavingAc);
			statement.setDouble(3,  StudentCheckingAc);
			statement.setDouble(4,  PersonalCheckingAc);
			statement.setDouble(5,  BusinessCheckingAc);
			statement.setDouble(6,  StudentSavingAc);
			statement.setDouble(7,  personalSavingAc);
			statement.setInt(8, idGenerateTransaction);
			 
			 
		  int  row=statement.executeUpdate();
			
			    System.out.println(row+"one row Update!");
		
            
           
		
	} catch(Exception e) {
		 e.printStackTrace();
	}
		
		return false;

}



	/**
	 * this get a specific account  by using select
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
			
			String sql= ("SELECT * FROM  GenerateTransaction  WHERE idGenerateTransaction ="+driverLicense+";");
	      
			PreparedStatement ps=connection.prepareStatement(sql);

			ResultSet rs=ps.executeQuery();
			
			while (rs.next()) {
				
				System.out.print(rs.getInt(1)+"  "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+rs.getString(5)+rs.getString(6)+rs.getString(7)+rs.getString(8));
	
				 
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
