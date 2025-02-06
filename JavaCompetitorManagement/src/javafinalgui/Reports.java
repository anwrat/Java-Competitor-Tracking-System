package javafinalgui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

public class Reports {
    static String url = "jdbc:mysql://localhost:3306/";
    static String username = "root";
    static String password = "Root#123";
    static String dbname = "javacompetition";
    static String durl = url + dbname;
    
    //Generate Report
    public static void generatereport(JLabel lname,JLabel llevel,JLabel date,JLabel c,JLabel s,String dt,String name,String level,int correct) {
        String query = "Insert into reports(DT,Name,level,Correct,Score)values(?,?,?,?,?)";
        
        try {
            // make a connection
            Connection conn = DriverManager.getConnection(durl,username,password);
            PreparedStatement pstm=conn.prepareStatement(query);
            pstm.setString(1,dt);
            pstm.setString(2, name);
            pstm.setString(3, level);
            pstm.setInt(4, correct);
            float score=correct/5.0f;
            pstm.setFloat(5, score);
            lname.setText("Name: "+name);
            llevel.setText("Quiz Level: "+level);
            date.setText("Date and Time: "+dt);
            c.setText("Correct Answers: "+correct);
            s.setText("Average Score: "+score);
            pstm.executeUpdate();
            pstm.close();
            conn.close();
        }
        catch(SQLException e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }
    
    //Add scores to the user tables
    public static void addscores(String name,String level, int hscore,int sscore,int jscore) {
    	String query="Update userdetails SET Sports=?, History=?, Java=? where Name=? and level=?";
        try {
            // make a connection
            Connection conn = DriverManager.getConnection(durl,username,password);
            PreparedStatement pstm=conn.prepareStatement(query);//For dynamic allocation use PreparedStatement
            ArrayList<Integer> original=Competitor.getscore(name, level);
            pstm.setInt(1,sscore+original.get(1));
            pstm.setInt(2, hscore+original.get(0));
            pstm.setInt(3, jscore+original.get(2));
            pstm.setString(4, name);
            pstm.setString(5, level);
            pstm.executeUpdate();
            pstm.close();
            conn.close();
        }
        catch(SQLException e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }
    
    //Get all user Reports
    public static void getreports(DefaultTableModel m) {
        String query = "select * from reports";
        
        try {
        	while(m.getRowCount()>0) {
        		m.removeRow(0);
        	}
            // make a connection
            Connection conn = DriverManager.getConnection(durl,username,password);
            
            // create a statement
            PreparedStatement pstm = conn.prepareStatement(query);
            ResultSet rs=pstm.executeQuery();
            while(rs.next()) {
            	String date=rs.getString("DT");
            	String n=rs.getString("Name");
            	String l=rs.getString("level");
            	int c=rs.getInt("correct");
            	float s=rs.getFloat("score");
            	m.addRow(new Object[] {date,n,l,c,s});
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
    
    //Get Total Players
    public static int getTotalPlayers() {
        String query = "SELECT COUNT(*) FROM userdetails";
        int totalPlayers = 0;

        try (Connection conn = DriverManager.getConnection(durl, username, password);
             PreparedStatement pstm = conn.prepareStatement(query);
             ResultSet rs = pstm.executeQuery()) {  

            if (rs.next()) {  
                totalPlayers = rs.getInt(1);  
            }

        } catch (SQLException e) {
            System.out.println(e);
            e.printStackTrace();
        }

        return totalPlayers; 
    }

}
