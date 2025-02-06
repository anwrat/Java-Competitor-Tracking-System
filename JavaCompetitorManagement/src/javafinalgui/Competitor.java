package javafinalgui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

public class Competitor {
    static String url = "jdbc:mysql://localhost:3306/";
    static String username = "root";
    static String password = "Root#123";
    static String dbname = "javacompetition";
    static String durl = url + dbname;
    
    public static void showuserdetails(DefaultTableModel m,String name,String level) {
        String query = "select * from userdetails where Name=? and level=?";
        
        try {
        	while(m.getRowCount()>0) {
        		m.removeRow(0);
        	}
            // make a connection
            Connection conn = DriverManager.getConnection(durl,username,password);
            
            // create a statement
            PreparedStatement pstm = conn.prepareStatement(query);
            pstm.setString(1, name);
            pstm.setString(2, level);
            ResultSet rs=pstm.executeQuery();
            while(rs.next()) {
            	int id=rs.getInt("CompetitorID");
            	int sports=rs.getInt("Sports");
            	int history=rs.getInt("History");
            	int java=rs.getInt("Java");
            	m.addRow(new Object[] {id,name,level,sports,history,java});
            }
            rs.close();
            pstm.close();
            //Connection close
            conn.close();
        }
        catch(SQLException e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }
}
