package javafinalgui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

/**
 * Competitor class for getting score and user details
 */
public class Competitor {
    static String url = "jdbc:mysql://localhost:3306/";
    static String username = "root";
    static String password = "Root#123";
    static String dbname = "javacompetition";
    static String durl = url + dbname;
    
    /**
     * Method to show Competitor Details
     * @param m DefaultTableModel to be filled by details
     * @param name Name of Competitor
     * @param level Level of Competitor
     */
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
    
    /**
     * Method to get scores of 3 subjects for a user
     * @param name Name of Competitor
     * @param level Level of Competitor
     * @return ArrayList of Integers with scores for 3 subjects
     */
    //For getting scores
    public static ArrayList<Integer> getscore(String name, String level) {
    	String getquery="select * from userdetails where Name=? and level=?";
    	try {
    		Connection conn = DriverManager.getConnection(durl,username,password);
            PreparedStatement pstm1=conn.prepareStatement(getquery);//For getting original values
            pstm1.setString(1,name);
            pstm1.setString(2, level);
            ResultSet rs=pstm1.executeQuery();
            ArrayList<Integer> scores=new ArrayList<Integer>();
            while(rs.next()) {
            	int h=rs.getInt("History");
            	int s=rs.getInt("Sports");
            	int j=rs.getInt("Java");
            	scores.add(h);
            	scores.add(s);
            	scores.add(j);
            }
            rs.close();
            pstm1.close();
            return scores;
    	}catch(SQLException e) {
		  System.out.println(e);
          e.printStackTrace();
          return null;
    	}
    }
}
