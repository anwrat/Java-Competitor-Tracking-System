package javafinalgui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.table.DefaultTableModel;

public class Questions {
	Scanner obj=new Scanner(System.in);
    static String url = "jdbc:mysql://localhost:3306/";
    static String username = "root";
    static String password = "Root#123";
    static String dbname = "javacompetition";
    static String durl = url + dbname;
    //For Adding questions
    public static boolean addquestions(String level,String category,String q,String o1,String o2,String o3,String a) {
        String query = "Insert into questions(Question,A,B,C,Answer,Level,category)values(?,?,?,?,?,?,?)";
        
        try {
            // make a connection
            Connection conn = DriverManager.getConnection(durl,username,password);
            PreparedStatement pstm=conn.prepareStatement(query);
            pstm.setString(1,q);
            pstm.setString(2, o1);
            pstm.setString(3, o2);
            pstm.setString(4, o3);
            pstm.setString(5, a);
            pstm.setString(6, level);
            pstm.setString(7, category);
            pstm.executeUpdate();
            pstm.close();
            conn.close();
            return true;
        }
        catch(SQLException e) {
            System.out.println(e);
            e.printStackTrace();
            return false;
        }
    }
    //For Deleting Questions
    public static void deletequestions(int id) {
    	String query="DELETE from questions where QuestionID=?";
        try {
            // make a connection
            Connection conn = DriverManager.getConnection(durl,username,password);
            PreparedStatement pstm=conn.prepareStatement(query);//For dynamic allocation use PreparedStatement
            pstm.setInt(1,id);
            pstm.executeUpdate();
            pstm.close();
            conn.close();
        }
        catch(SQLException e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }
    //For Updating Questions
    public static void updatequestions(int id,String q,String o1,String o2,String o3,String a,String level,String category) {
    	String query="Update questions SET Question=?,A=?,B=?,C=?,Answer=?,Level=?,category=? where QuestionID=?";
        try {
            // make a connection
            Connection conn = DriverManager.getConnection(durl,username,password);
            PreparedStatement pstm=conn.prepareStatement(query);//For dynamic allocation use PreparedStatement
            pstm.setString(1,q);
            pstm.setString(2, o1);
            pstm.setString(3, o2);
            pstm.setString(4, o3);
            pstm.setString(5, a);
            pstm.setString(6, level);
            pstm.setString(7, category);
            pstm.setInt(8,id);
            pstm.executeUpdate();
            pstm.close();
            conn.close();
        }
        catch(SQLException e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }
    //For getting original values of a question
    public ArrayList<String> getqndetails(int id) {
    	String getquery="select * from questions where QuestionID=?";
    	try {
    		Connection conn = DriverManager.getConnection(durl,username,password);
            PreparedStatement pstm1=conn.prepareStatement(getquery);//For getting original values
            ResultSet rs=pstm1.executeQuery();
            ArrayList<String> qns=new ArrayList<String>();
            while(rs.next()) {
            	String q=rs.getString("Question");
            	String a=rs.getString("Answer");
            	String c=rs.getString("category");
            	String l=rs.getString("level");
            	String o1=rs.getString("A");
            	String o2=rs.getString("B");
            	String o3=rs.getString("C");
            	qns.add(q);
            	qns.add(o1);
            	qns.add(o2);
            	qns.add(o3);
            	qns.add(a);
            	qns.add(l);
            	qns.add(c);
            }
            rs.close();
            pstm1.close();
            return qns;
    	}catch(SQLException e) {
		  System.out.println(e);
          e.printStackTrace();
          return null;
    	}
    }
    //For viewing questions by level
    public static void viewbylevel(DefaultTableModel m,String level) {
        String query = "select * from questions where Level=?";
        
        try {
        	while(m.getRowCount()>0) {
        		m.removeRow(0);
        	}
            // make a connection
            Connection conn = DriverManager.getConnection(durl,username,password);
            
            // create a statement
            PreparedStatement pstm = conn.prepareStatement(query);
            pstm.setString(1, level);
            ResultSet rs=pstm.executeQuery();
            while(rs.next()) {
            	int id=rs.getInt("QuestionID");
            	String q=rs.getString("Question");
            	String a=rs.getString("Answer");
            	String c=rs.getString("category");
            	m.addRow(new Object[] {id,c,q,a,});
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
    //For searching questions by ID
    public static boolean searchbyID(int id) {
	    String query = "SELECT * FROM questions WHERE QuestionID = ?";

	    try (Connection conn = DriverManager.getConnection(durl, username, password);
	         PreparedStatement pst = conn.prepareStatement(query)) {
	        pst.setInt(1, id);

	        try (ResultSet rs = pst.executeQuery()) {
	            // If the ResultSet contains any rows, return true
	            return rs.next();
	        }

	    } catch (SQLException e) {
	        System.out.println(e);
	        e.printStackTrace();
	        return false;  
	    }
    }
}

