package javafinalgui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class QuizGame {
    static String url = "jdbc:mysql://localhost:3306/";
    static String username = "root";
    static String password = "Root#123";
    static String dbname = "javacompetition";
    static String durl = url + dbname;
    
    public static ArrayList<Integer> getrandomfiveids(String level) {
    	String getquery="select * from questions where level=?";
    	try {
    		Connection conn = DriverManager.getConnection(durl,username,password);
            PreparedStatement pstm1=conn.prepareStatement(getquery);//For getting original values
            pstm1.setString(1, level);
            ResultSet rs=pstm1.executeQuery();
            ArrayList<Integer> qns=new ArrayList<Integer>();
            while(rs.next()) {
            	int qid=rs.getInt("QuestionID");
            	qns.add(qid);
            }
            rs.close();
            pstm1.close();
            Collections.shuffle(qns); // Shuffle the arraylist

            // Return only the first 5 elements (or all if arraylist size is < 5)
            return new ArrayList<Integer>(qns.subList(0, Math.min(5, qns.size())));

    	}catch(SQLException e) {
		  System.out.println(e);
          e.printStackTrace();
          return null;
    	}
    }
    
    public static ArrayList<String> getshuffledoptions(int id) {
    	String getquery="select * from questions where QuestionID=?";
    	try {
    		Connection conn = DriverManager.getConnection(durl,username,password);
            PreparedStatement pstm1=conn.prepareStatement(getquery);//For getting original values
            pstm1.setInt(1, id);
            ResultSet rs=pstm1.executeQuery();
            ArrayList<String> options=new ArrayList<String>();
            while(rs.next()) {
            	String o1=rs.getString("A");
            	String o2=rs.getString("B");
            	String o3=rs.getString("C");
            	String a=rs.getString("Answer");
            	options.add(o1);
            	options.add(o2);
            	options.add(o3);
            	options.add(a);
            }
            rs.close();
            pstm1.close();
            Collections.shuffle(options); // Shuffle the arraylist

            return options;

    	}catch(SQLException e) {
		  System.out.println(e);
          e.printStackTrace();
          return null;
    	}
    }
}
