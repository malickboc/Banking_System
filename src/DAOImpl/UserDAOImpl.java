package DAOImpl;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

import DAO.UserDAO;
import user.User;


public  class UserDAOImpl implements UserDAO {

	
	private final static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private final static String DATABASE_URL = "jdbc:mysql://localhost:------_Table?" + "autoReconnect=true&useSSL=false";;
	private final static String USERNAME = "root";
	private final static String PASSWORD = "-------";
	private Connection connection;
	
	Statement statement = null;
	
public void getConnection() {
		//Statement statement = null;

		try {

			// Register JDBC driver
			Class.forName(JDBC_DRIVER);

			// Open a connection
			connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
			statement = connection.createStatement();

			String sql = "select * from user2";
			

			ResultSet resultSet = statement.executeQuery(sql);
             
			while (resultSet.next()) {
				
				int id =resultSet.getInt("id");
				String lastname = resultSet.getString("lastname");
				String firstname= resultSet.getString("firstname");
				int BirthDate = resultSet.getInt("BirthDate");
				int LicenseN= resultSet.getInt("LicenseN");
				String Occupation = resultSet.getString("Occupation");
				
				System.out.println(id +"-" +lastname+"-"+ firstname + "-" +BirthDate + "-" + LicenseN + "-" + Occupation);
				
			}
			resultSet.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	

	
@Override
public boolean addUser(User user) throws ClassNotFoundException, SQLException {

	Scanner input = new Scanner(System.in);
	
	
	
	System.out.print("Enter id:");

	int id= input.nextInt();
	

	System.out.print("Enter lastName:");

	String lastname= input.next();


	System.out.print("Enter FisrtName:");

	String firstname= input.next();
	

	System.out.print("Enter birthDate:");

	int BirthDate = input.nextInt();
	

	System.out.print("Enter LicenseN:");

	String LicenseN = input.next();
	

	System.out.print("Enter Occupation:");

	String Occupation = input.next();

	

	try {


		statement  = connection.createStatement();
	
		String sql = "INSERT INTO Malick_table.user2 values(?,?,?,?,?,?)";
				
								  
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, id);
		statement.setString(2, lastname);
		statement.setString(3,firstname);
		statement.setInt(4, BirthDate);
		statement.setString(5,LicenseN);
		statement.setString(6,Occupation);
	
	
		 
		 
	  int  row=statement.executeUpdate();
		
		    System.out.println(row+"one row Add!");
	
        
			    
				}
				 
			catch (SQLException e) {
			System.out.println("\nCrazy SQL Exception: " + e);
		
			}
	return false;
	
}




			
	@Override
	public boolean updateUser(User user) {
		
		boolean row1;
		
		Scanner input = new Scanner(System.in);
		
		
		
		System.out.print("Enter id:");

		int id= input.nextInt();
		

		System.out.print("Enter lastName:");

		String lastname= input.next();


		System.out.print("Enter FisrtName:");

		String firstname= input.next();
		

		System.out.print("Enter birthDate:");

		int BirthDate = input.nextInt();
		

		System.out.print("Enter LicenseN:");

		String LicenseN = input.next();
		

		System.out.print("Enter Occupation:");

		String Occupation = input.next();
	
		
		try {
			connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
			
			//statement = connection.createStatement();

			


			String sql = "UPDATE  user2 SET lastname=?, firstname=?, BirthDate=?, LicenseN=?,Occupation=? Where id=?;";
	
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1, lastname);
			statement.setString(2,firstname);
			statement.setInt(3, BirthDate);
			statement.setString(4,LicenseN);
			statement.setString(5,Occupation);
			statement.setInt(6, id);
		
			
			 
			 
		  int  row=statement.executeUpdate();
			
			    System.out.println(row+"one row Update!");
		
            
           
		
	} catch(Exception e) {
		 e.printStackTrace();
	}
		
		return false;

	}
	


	@Override
	public User getUser(String driversLicense) throws FileNotFoundException, ParseException {
		
	      Scanner sc= new Scanner (System.in);
	      System.out.println("Enter user drivers License");
	      User returnUser = null;
	      String driverLicense= sc.nextLine();
	      
	      
	    try {
	    
	      connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
			
			statement = connection.createStatement();
			
			String sql= ("SELECT * FROM user2 WHERE LicenseN ="+driverLicense+";");
	      
			PreparedStatement ps=connection.prepareStatement(sql);

			ResultSet rs=ps.executeQuery();
			
			while (rs.next()) {
				
				System.out.print(rs.getInt(1)+"  "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6));
	
				 
				System.out.println();
				
			}
			
			
			rs.close();

	
	}
	    catch (SQLException e) {
			System.out.println("\nCrazy SQL Exception: " + e);
		
			}
		return returnUser;



     
	}





	public void removeUser (String driversLicense) {
		
		Scanner input = new Scanner(System.in);
		System.out.println("enter Driver License Number to remove:");
		String driversL= input.nextLine();
		
		
		try {
			connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
			
			String sql= "DELETE  from user2 where LicenseN= ?;";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			  
			statement.setString(1, driversL);
			int row=statement.executeUpdate();
			
				 System.out.println(row+"one row Remove !");
				
			
		}
		
		
		
		 catch (Exception e) {
				System.out.println("\nCrazy SQL Exception: " + e);
			
				}
		

		
		
		
		
	}








}