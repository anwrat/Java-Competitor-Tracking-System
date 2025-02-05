package javafinalgui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserRegister {
    public void signup(String name,String level) {
        String url = "jdbc:mysql://localhost:3306/";
        String username = "root";
        String password = "Root#123";
        String dbname="javacompetition";
        String durl=url+dbname;
        String query = "Insert into userdetails(name,level,Sports,History,Java)values(?,?,?,?,?)";
        
        try {
            // make a connection
            Connection conn = DriverManager.getConnection(durl,username,password);
            PreparedStatement pstm=conn.prepareStatement(query);//For dynamic allocation use PreparedStatement
            pstm.setString(1,name);
            pstm.setString(2, level);
            pstm.setInt(3, 0);
            pstm.setInt(4, 0);
            pstm.setInt(5, 0);
            pstm.executeUpdate();
            pstm.close();
            conn.close();
        }
        catch(SQLException e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }
}
