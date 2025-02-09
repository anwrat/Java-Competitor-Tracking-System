package javafinalgui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

/**
 * Class containing methods related to questions database
 */
public class Questions {
    static String url = "jdbc:mysql://localhost:3306/";
    static String username = "root";
    static String password = "Root#123";
    static String dbname = "javacompetition";
    static String durl = url + dbname;
    //For Adding questions
    /**
     * Add a question to database
     * @param level Difficulty
     * @param category Subject of question
     * @param q Full Question
     * @param o1 Option1 
     * @param o2 Option2
     * @param o3 Option3
     * @param a Correct Answer
     * @return if question was added successfully or not
     */
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
    /**
     * For deleting questions from database
     * @param id ID of question
     */
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
    /**
     * For updating question in database
     * @param id Question ID
     * @param q Full Question
     * @param o1 Option1
     * @param o2 Option2
     * @param o3 Option3
     * @param a Answer
     * @param level Difficulty of Question
     * @param category Subject of Question
     */
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
    /**
     * Get all details of question from database
     * @param id ID of question
     * @return All details in ArrayList
     */
    public static ArrayList<String> getqndetails(int id) {
    	String getquery="select * from questions where QuestionID=?";
    	try {
    		Connection conn = DriverManager.getConnection(durl,username,password);
            PreparedStatement pstm1=conn.prepareStatement(getquery);//For getting original values
            pstm1.setInt(1, id);
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
    /**
     * For viewing questions according to level
     * @param m TableModel where questions are to be added
     * @param level Difficulty of question
     */
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
    /**
     * To search a question by ID
     * @param id ID of question
     * @return question found or not
     */
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
    
    //For getting question only
    /**
     * For getting question only
     * @param id ID of question
     * @return Question
     */
    public static String getqn(int id) {
    	String getquery="select * from questions where QuestionID=?";
    	try {
    		Connection conn = DriverManager.getConnection(durl,username,password);
            PreparedStatement pstm1=conn.prepareStatement(getquery);//For getting original values
            pstm1.setInt(1, id);
            ResultSet rs=pstm1.executeQuery();
            if(rs.next()) {
            	String q=rs.getString("Question");   
                rs.close();
                pstm1.close();
                return q;
            }
            else {
            	rs.close();
                pstm1.close();
            	return null;
            }
    	}catch(SQLException e) {
		  System.out.println(e);
          e.printStackTrace();
          return null;
    	}
    }
    //For getting category only
    /**
     * For getting category of question
     * @param id Question ID
     * @return Category of question
     */
    public static String getcat(int id) {
    	String getquery="select * from questions where QuestionID=?";
    	try {
    		Connection conn = DriverManager.getConnection(durl,username,password);
    		PreparedStatement pstm1=conn.prepareStatement(getquery);//For getting original values
    		pstm1.setInt(1, id);
    		ResultSet rs=pstm1.executeQuery();
    		if(rs.next()) {
    			String l=rs.getString("category");   
    			rs.close();
    			pstm1.close();
    			return l;
    		}
    		else {
    			rs.close();
    			pstm1.close();
    			return null;
    		}
    	}catch(SQLException e) {
    		System.out.println(e);
    		e.printStackTrace();
    		return null;
    	}
    }
}

