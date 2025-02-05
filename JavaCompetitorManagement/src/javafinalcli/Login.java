package javafinalcli;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login {
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
