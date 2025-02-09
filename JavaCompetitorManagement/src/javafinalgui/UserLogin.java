package javafinalgui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Login class to verify existence of user
 */
public class UserLogin {
	/**
	 * Method to check if user details match or not
	 * @param name Name of user
	 * @param level Level of user
	 * @return boolean value if user exists or not
	 */
	public boolean login(String name, String level) {
	    String url = "jdbc:mysql://localhost:3306/";
	    String username = "root";
	    String password = "Root#123";
	    String dbname = "javacompetition";
	    String durl = url + dbname;
	    String query = "SELECT * FROM userdetails WHERE name = ? AND level = ?";

	    try (Connection conn = DriverManager.getConnection(durl, username, password);
	         PreparedStatement pst = conn.prepareStatement(query)) {
	        pst.setString(1, name);
	        pst.setString(2, level);

	        try (ResultSet rs = pst.executeQuery()) {
	            // If the ResultSet contains any rows, login is successful
	            return rs.next();
	        }

	    } catch (SQLException e) {
	        System.out.println(e);
	        e.printStackTrace();
	        return false;  
	    }
	}
}
