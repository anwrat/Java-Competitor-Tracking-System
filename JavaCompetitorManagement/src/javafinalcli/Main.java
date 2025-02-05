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
			AdminDashboard a=new AdminDashboard();
			a.adminlogin();
			a.admindashboard();
		}
		//For User
		else if(check.equals("1")) {
			UserDashboard u=new UserDashboard();
			u.userlogin();
		}
	}
}
