package javafinalcli;
import java.util.Scanner;

public class UserDashboard {
	Scanner obj=new Scanner(System.in);
	public void userlogin() {
		System.out.println("Enter your name: ");
		String name=obj.next();
		String level;
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
		Login l=new Login();
		SignUp s=new SignUp();
		if(l.login(name, level)) {
			System.out.println("Login Successful!!");
		}
		else {
			s.signup(name, level);
			System.out.println("Registration Succesful!!");
		}
	}
}
