package javafinalcli;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Question {
	Scanner obj=new Scanner(System.in);
    String url = "jdbc:mysql://localhost:3306/";
    String username = "root";
    String password = "Root#123";
    String dbname = "javacompetition";
    String durl = url + dbname;
    //For Adding questions
    public void addquestions() {
    	String level,category;
		while(true) {
			System.out.println("1.Beginner\n2.Intermediate\n3.Advanced");
			System.out.println("Choose a level(1/2/3):");
			level=obj.next();
			if(level.equals("1")||level.equals("2")||level.equals("3")) {
				if (level.equals("1")) {
				    level = "Beginner";
				} else if (level.equals("2")) {
				    level = "Intermediate";
				} else if (level.equals("3")) {
				    level = "Advanced";
				}
				break;
			}
			else {
				System.out.println("Invalid level choice. Please choose again");
			}
		}
		while(true) {
			System.out.println("1.Sports\n2.History\n3.Java");
			System.out.println("Choose a category(1/2/3):");
			category=obj.next();
			if(category.equals("1")||category.equals("2")||category.equals("3")) {
				if (category.equals("1")) {
				    category = "Sports";
				} else if (category.equals("2")) {
				    category = "History";
				} else if (category.equals("3")) {
				    category = "Java";
				}
				break;
			}
			else {
				System.out.println("Invalid level choice. Please choose again");
			}
		}
    	System.out.println("Enter the question: ");
    	obj.nextLine();
    	String q=obj.nextLine();
    	System.out.println("Enter option A: ");
    	String o1=obj.nextLine();
    	System.out.println("Enter option B: ");
    	String o2=obj.nextLine();
    	System.out.println("Enter option C: ");
    	String o3=obj.nextLine();
    	System.out.println("Enter the answer: ");
    	String a=obj.nextLine();
        String query = "Insert into questions(Question,A,B,C,Answer,Level,category)values(?,?,?,?,?,?,?)";
        
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
            pstm.executeUpdate();
            System.out.println("Added question successfully!!");
            pstm.close();
            conn.close();
        }
        catch(SQLException e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }
    //For Deleting Questions
    public void deletequestions(int id) {
    	String query="DELETE from questions where QuestionID=?";
        try {
            // make a connection
            Connection conn = DriverManager.getConnection(durl,username,password);
            PreparedStatement pstm=conn.prepareStatement(query);//For dynamic allocation use PreparedStatement
            pstm.setInt(1,id);
            pstm.executeUpdate();
            System.out.println("Deleted question successfully!!");
            pstm.close();
            conn.close();
        }
        catch(SQLException e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }
    //For Updating Questions
    public void updatequestions(int id) {
    	String level,category;
		while(true) {
			System.out.println("1.Beginner\n2.Intermediate\n3.Advanced");
			System.out.println("Choose a level(1/2/3):");
			level=obj.next();
			if(level.equals("1")||level.equals("2")||level.equals("3")) {
				if (level.equals("1")) {
				    level = "Beginner";
				} else if (level.equals("2")) {
				    level = "Intermediate";
				} else if (level.equals("3")) {
				    level = "Advanced";
				}
				break;
			}
			else {
				System.out.println("Invalid level choice. Please choose again");
			}
		}
		while(true) {
			System.out.println("1.Sports\n2.History\n3.Java");
			System.out.println("Choose a category(1/2/3):");
			category=obj.next();
			if(category.equals("1")||category.equals("2")||category.equals("3")) {
				if (category.equals("1")) {
				    category = "Sports";
				} else if (category.equals("2")) {
				    category = "History";
				} else if (category.equals("3")) {
				    category = "Java";
				}
				break;
			}
			else {
				System.out.println("Invalid level choice. Please choose again");
			}
		}
    	System.out.println("Enter the question: ");
    	obj.nextLine();
    	String q=obj.nextLine();
    	System.out.println("Enter option A: ");
    	String o1=obj.nextLine();
    	System.out.println("Enter option B: ");
    	String o2=obj.nextLine();
    	System.out.println("Enter option C: ");
    	String o3=obj.nextLine();
    	System.out.println("Enter the answer: ");
    	String a=obj.nextLine();
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
            System.out.println("Updated question successfully!!");
            pstm.close();
            conn.close();
        }
        catch(SQLException e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }
    //For viewing questions by level
    public void viewbylevel(String level) {
        String query = "select * from questions where Level=?";
        
        try {
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
            	System.out.println("ID: "+id);
            	System.out.println(q);
            	System.out.println("Answer: "+a);
            	System.out.println("Category: "+c);
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
    public boolean searchbyID(int id) {
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
