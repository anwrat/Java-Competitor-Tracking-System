package javafinalcli;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner obj=new Scanner(System.in);
		System.out.println("--- Competitor Management System --");
		System.out.println("1.User Login/Registration");
		System.out.println("2.Admin Login");
		String check;
		while(true) {
			System.out.println("Enter your choice(1/2): ");
			check=obj.next();
			if(check.equals("1") || check.equals("2")) {
				break;
			}
			else {
				System.out.println("Invalid choice");
			}
		}
		//For Admin 
		if(check.equals("2")) {
			while(true) {
				System.out.println("Enter the name: ");
				String name=obj.next();
				System.out.println("Enter the password: ");
				String pass=obj.next();
				AdminLogin a=new AdminLogin();
				if(a.login(name, pass)) {
					System.out.println("Admin Login Successful");
					break;
				}
				else {
					System.out.println("Invalid details. Please try again");
				}
			}
		}
		//For User
		else if(check.equals("1")) {
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
}
