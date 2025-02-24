package javafinalcli;
import java.sql.*;

public class AdminLogin {
	public boolean login(String name, String pass) {
	    String url = "jdbc:mysql://localhost:3306/";
	    String username = "root";
	    String password = "Root#123";
	    String dbname = "javacompetition";
	    String durl = url + dbname;
	    String query = "SELECT * FROM admininfo WHERE name = ? AND password = ?";

	    try (Connection conn = DriverManager.getConnection(durl, username, password);
	         PreparedStatement pst = conn.prepareStatement(query)) {
	        pst.setString(1, name);
	        pst.setString(2, pass);

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
