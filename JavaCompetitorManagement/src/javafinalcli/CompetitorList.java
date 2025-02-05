package javafinalcli;
import java.sql.*;
public class CompetitorList {
    String url = "jdbc:mysql://localhost:3306/";
    String username = "root";
    String password = "Root#123";
    String dbname = "javacompetition";
    String durl = url + dbname;
    public void getAllplayers() {
        String query = "select * from userdetails";
        
        try {
            // make a connection
            Connection conn = DriverManager.getConnection(durl,username,password);
            
            // create a statement
            Statement stm = conn.createStatement();
            ResultSet rs=stm.executeQuery(query);
            while(rs.next()) {
            	int id=rs.getInt("CompetitorID");
            	String name=rs.getString("Name");
            	String level=rs.getString("Level");
            	int sports=rs.getInt("Sports");
            	int history=rs.getInt("History");
            	int java=rs.getInt("Java");
            	System.out.println(id+", "+name+", "+level+", Sports:"+sports+", History:"+history+", Java:"+java);
            }
            stm.close();
            rs.close();
            //Connection close
            conn.close();
        }
        catch(SQLException e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }
}
