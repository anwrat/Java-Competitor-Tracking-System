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
			
		}
	}
}
