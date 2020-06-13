package DAOImpl;


import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import DAO.AdressDAO;
import user.Adress;
import user.User;

public class AdressDaoImpl implements AdressDAO {

	private final static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private final static String DATABASE_URL = "jdbc:mysql://localhost:3306/Malick_Table?"
			+ "autoReconnect=true&useSSL=false";;
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
		// Statement statement = null;

		try {

			// Register JDBC driver
			Class.forName(JDBC_DRIVER);

			// Open a connection
			connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
			statement = connection.createStatement();

			String sql = "select * from Adress1";

			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String Street = resultSet.getString("street");
				String State = resultSet.getString("state");
				int zip = resultSet.getInt("zip");
				int Driverslicense = resultSet.getInt("Driverslicense");
				

				System.out.println(
						id + "-" + Street + "-" + State + "-" + zip +"-"+Driverslicense );

			}
			resultSet.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * this function get address from database
	 */

	@Override
	public Adress getAdress1 (int driverslicense) throws FileNotFoundException {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter user drivers License");
		Adress returnUser = null;
		String driverLicense = sc.nextLine();

		try {

			connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);

			statement = connection.createStatement();

			String sql = ("SELECT * FROM Adress1 WHERE driverslicense =" + driverLicense + ";");

			PreparedStatement ps = connection.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				System.out.print(rs.getInt(1) + "  " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4)
						+ " " + rs.getString(5));

				System.out.println();

			}

			rs.close();

		} catch (SQLException e) {
			System.out.println("\nCrazy SQL Exception: " + e);

		}
		return returnUser;

	}
	
	/**
	 * this will update the adress record from database by using update from
	 * in stoer to sql
	 */

	@Override
	public boolean updateAdress(Adress Address) {
		boolean row1;

		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter id :");

		int id = input.nextInt();

		System.out.print("Enter Street :");

		String Street = input.next();

		System.out.print("Enter State:");

		String State = input.next();

		System.out.print("Enter Zip:");

		int Zip = input.nextInt();

		System.out.print("Enter DriversLicense:");

		int Driverslicense = input.nextInt();

		
		
		try {
			connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);

			// statement = connection.createStatement();

			String sql = "UPDATE  Malick_Table.Adress1 SET Street=?, State=?, Zip=?, Driverslicense=? Where id=?;";

			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1, Street);
			statement.setString(2,State);
			statement.setInt(3, Zip);
			statement.setInt(4, Driverslicense);
			statement.setInt(5, id);

			int row = statement.executeUpdate();

			System.out.println(row + "one row Update!");

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;

	}

	
	/**
	 * this functionremove the record from ours system. It use delete from to
	 * delete from database
	 */
	@Override
	public boolean removeAdress(Adress Adress) {
		
		Scanner input = new Scanner(System.in);
		System.out.println("enter Driver Driverslicense to remove:");
		String driversL = input.nextLine();

		try {
			connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);

			String sql = "DELETE from  Adress1 where Driverslicense= ?;";

			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setString(1, driversL);
			int row = statement.executeUpdate();

			System.out.println(row + "one row Remove !");

		}

		catch (Exception e) {
			System.out.println("\nCrazy SQL Exception: " + e);

		}
		return false;

	}
	
	
	/**
	 * this add a new user to a system or databasse
	 */
	
	public boolean addUser(Adress Adress) {

		
		
		
		boolean row1;

		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter id :");

		int id = input.nextInt();

		System.out.print("Enter Street :");

		String Street = input.next();

		System.out.print("Enter State:");

		String State = input.next();

		System.out.print("Enter Zip:");

		int Zip = input.nextInt();

		System.out.print("Enter DriversLicense:");

		int Driverslicense = input.nextInt();

		
		

		try {


			statement  = connection.createStatement();
		
			String sql = "INSERT INTO Malick_Table.Adress1 values(?,?,?,?,?)";
					
									  
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setInt(1, id);
			statement.setString(2, Street);
			statement.setString(3,State);
			statement.setInt(4, Zip);
			statement.setInt(5, Driverslicense);
			
			 
		  int  row=statement.executeUpdate();
			
			    System.out.println(row+"one row Add!");
		
	        
				    
		}
					 
				catch (SQLException e) {
				System.out.println("\nCrazy SQL Exception: " + e);
			
				}
		return false;
		
	}

	

}
