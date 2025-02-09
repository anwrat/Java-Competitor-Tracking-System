package javafinalgui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

/**
 * Class related to generation of quizgame reports
 */
public class Reports {
    static String url = "jdbc:mysql://localhost:3306/";
    static String username = "root";
    static String password = "Root#123";
    static String dbname = "javacompetition";
    static String durl = url + dbname;
    
    //Generate Report
    /**
     * Method for adding reports to database and showing in JLabel
     * @param lname JLabel for showing text
     * @param llevel JLabel for showing text
     * @param date JLabel for showing text
     * @param c JLabel for showing text
     * @param s JLabel for showing text
     * @param dt Date and time of the quiz taken
     * @param name Name of the player
     * @param level Level of the player
     * @param correct Number of correct answers
     */
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
    /**
     * Method to add to scores in userdetails table
     * @param name Name of player
     * @param level Level of player
     * @param hscore History score of player
     * @param sscore Sports score of player
     * @param jscore Java score of player
     */
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
    /**
     * Method to get reports of all players
     * @param m TableModel where the rows are to be added
     */
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
    /**
     * Method to get total number of players in the game
     * @return total players
     */
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
    
    //Get highest score player according to level
    /**
     * Method to get highest total score for a certain level
     * @param level Level of quiz taken
     * @return Name and scores as string
     */
    public static String getHighestLevel(String level) {
        String query = "SELECT Name, (history + sports + java) AS total_score FROM userdetails WHERE Level = ? ORDER BY total_score DESC LIMIT 1";
        String result = "No " + level + " players found";

        try (Connection conn = DriverManager.getConnection(durl, username, password);
             PreparedStatement pstm = conn.prepareStatement(query)) {

            pstm.setString(1, level); 
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    String name = rs.getString("Name");
                    int totalScore = rs.getInt("total_score");  
                    result = "Best "+level+" player: "+name + " - " + totalScore;
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return result;
    }

    
    //Get highest score for particular subjects
    /**
     * Method to get highest score for particular subjects
     * @param subject Name of subject
     * @return Name and score as a string
     */
    public static String getHighestSubject(String subject) {
        if (!subject.equalsIgnoreCase("history") && 
            !subject.equalsIgnoreCase("sports") && 
            !subject.equalsIgnoreCase("java")) {
            return "Invalid subject!";
        }

        String query = "SELECT Name, " + subject + " FROM userdetails ORDER BY " + subject + " DESC LIMIT 1";
        String result = "No " + subject + " players found";

        try (Connection conn = DriverManager.getConnection(durl, username, password);
             PreparedStatement pstm = conn.prepareStatement(query);
             ResultSet rs = pstm.executeQuery()) {

            if (rs.next()) {
                String name = rs.getString("Name");
                int subjectScore = rs.getInt(subject); 
                result = "Best "+subject+" player: "+ name + " - " + subjectScore;
            }

        } catch (SQLException e) {
            System.out.println(e);
            e.printStackTrace();
        }

        return result;
    }
    
    //Leaderboard
    /**
     * Method to populate TableModel of leaderboard
     * @param model Leaderboard TableModel
     * @param level Level of quiz taken
     */
    public static void populateLeaderboard(DefaultTableModel model, String level) {
        String query = "SELECT Name, Sports, History, Java FROM userdetails WHERE Level = ? ORDER BY (Sports + History + Java) DESC";
        
        try (Connection conn = DriverManager.getConnection(durl, username, password);
             PreparedStatement pstm = conn.prepareStatement(query)) {

            pstm.setString(1, level);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                String name = rs.getString("Name");
                int sports = rs.getInt("Sports");
                int history = rs.getInt("History");
                int java = rs.getInt("Java");

                model.addRow(new Object[]{name, sports, history, java});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}
