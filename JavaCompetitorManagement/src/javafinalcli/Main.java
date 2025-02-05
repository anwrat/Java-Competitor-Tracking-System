package javafinalcli;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		while(true) {
			Scanner obj=new Scanner(System.in);
			System.out.println("--- Competitor Management System --");
			System.out.println("1.User Login/Registration");
			System.out.println("2.Admin Login");
			System.out.println("3.Exit");
			String check;
			while(true) {
				System.out.println("Enter your choice(1/2/3): ");
				check=obj.next();
				if(check.equals("1") || check.equals("2")|| check.equals("3")) {
					break;
				}
				else {
					System.out.println("Invalid choice");
				}
			}
			//For Admin 
			if(check.equals("2")) {
				AdminDashboard a=new AdminDashboard();
				a.adminlogin();
				a.admindashboard();
			}
			//For User
			else if(check.equals("1")) {
				UserDashboard u=new UserDashboard();
				u.userlogin();
			}
			//For exiting the program
			else {
				System.out.println("Thank you for playing");
				break;
			}
		}
	}
}
