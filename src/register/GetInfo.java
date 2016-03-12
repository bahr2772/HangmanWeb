package register;

import java.sql.Connection;
import java.sql.DriverManager;

import sql.writeSql;

import java.sql.*;

public class GetInfo {



	// lost pass get from email or user name
	public String getLostPass(String email, String username){

		String password = null;
		String dbEmail = null;
		String dbUsername = "";

		try
		{
			String myDriver = "com.mysql.jdbc.Driver"; 
			String myUrl = "jdbc:mysql://localhost/claimgames";
			Class.forName(myDriver);
			Connection conn = DriverManager.getConnection(myUrl, "root", "root");

			PreparedStatement st = conn.prepareStatement("SELECT password FROM Users WHERE email = ? or username = ?");
			st.setString(1, email);
			st.setString(2, username);

			ResultSet r1=st.executeQuery();


			while(r1.next()) 
			{

				password = r1.getString("password");


				if(email.equalsIgnoreCase(dbEmail) || username.equalsIgnoreCase(dbUsername));
				{
					return "User found, password is: " + password;

				}
			}
		}

		catch (SQLException e) 
		{
			System.out.println("SQL Exception: "+ e.toString());
		} 
		catch (ClassNotFoundException cE) 
		{
			System.out.println("Class Not Found Exception: "+ cE.toString());
		}


		return password;
	}


	// login checker  \\
	public boolean credChecker(String username, String password){

		boolean matchUserPass = false;
		try
		{
			String myDriver = "com.mysql.jdbc.Driver"; 
			String myUrl = "jdbc:mysql://localhost/claimgames";
			Class.forName(myDriver);
			Connection conn = DriverManager.getConnection(myUrl, "root", "root");

			PreparedStatement st = conn.prepareStatement("SELECT * FROM Users WHERE username = ? and password = ?");
			st.setString(1, username);
			st.setString(2, password);
			ResultSet r1=st.executeQuery();

			String user;
			String pass;

			while(r1.next()) 
			{
				user =  r1.getString("username");
				pass = r1.getString("password");
				if(username.equalsIgnoreCase(user) && password.equals(pass) ) 
				{
					System.out.println("User Creds Match");
					matchUserPass = true;
				}
			}
		}

		catch (SQLException e) 
		{
			System.out.println("SQL Exception: "+ e.toString());
		} 
		catch (ClassNotFoundException cE) 
		{
			System.out.println("Class Not Found Exception: "+ cE.toString());
		}


		return matchUserPass;

	}


	// check user name exist for register \\
	public boolean usernameChecker(String username){

		boolean usernameExists = false;

		try
		{
			String myDriver = "com.mysql.jdbc.Driver"; 
			String myUrl = "jdbc:mysql://localhost/claimgames";
			Class.forName(myDriver);
			Connection conn = DriverManager.getConnection(myUrl, "root", "root");

			PreparedStatement st = conn.prepareStatement("SELECT * FROM Users WHERE username = ? ");
			st.setString(1, username);
			ResultSet r1=st.executeQuery();

			String user;

			while(r1.next()) 
			{
				user =  r1.getString("username");
				if(username.equalsIgnoreCase(user)) 
				{
					System.out.println("It already exists");
					usernameExists = true;
				}
			}
		}

		catch (SQLException e) 
		{
			System.out.println("SQL Exception: "+ e.toString());
		} 
		catch (ClassNotFoundException cE) 
		{
			System.out.println("Class Not Found Exception: "+ cE.toString());
		}

		return usernameExists;
	}


	public int newRegister(String password1, String password2, String username, String email){

		boolean check = usernameChecker(username);


		// user name found (true)
		if(check) 
			return 1;

		// check user name is smaller then 4
		if(username.length() < 4 ){
			System.out.println("username to small");
			return 2;
			//password to short
		}else if(password1.length() < 2){
			System.out.println("password too short");
			return 3;
			// passwords mismatch
		}else if(!password1.equals(password2)){
			System.out.println("passwords not match");
			return 4;
			// check passwords match
		}else {
			System.out.println("user sent");
			@SuppressWarnings("unused")
			writeSql newUser = new writeSql (username, password1, email);
			System.out.println("User created");
			return 5;
		}

		
	}


}//close class





