package javafinalcli;
import java.util.Scanner;

public class AdminDashboard {
	Scanner obj=new Scanner(System.in);
	public void adminlogin() {
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
	public void admindashboard() {
		System.out.println("ADMIN DASHBOARD");
		System.out.println("1.Add Questions");
		System.out.println("2.Delete Questions");
		System.out.println("3.Update Questions");
		System.out.println("4.View Questions by category");
		System.out.println("5.View Player Reports");
	}
}
