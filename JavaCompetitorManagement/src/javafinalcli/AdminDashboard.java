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
		while(true) {
			System.out.println("\n\nADMIN DASHBOARD");
			System.out.println("1.Add Questions");
			System.out.println("2.Delete Questions");
			System.out.println("3.Update Questions");
			System.out.println("4.View Questions by category");
			System.out.println("5.View Player Reports");
			System.out.println("6.LogOut");
			String choice;
			while(true) {
				System.out.println("Enter your choice(1/2/3/4/5/6:");
				choice=obj.next();
				if(choice.equals("1")||choice.equals("2")||choice.equals("3")||choice.equals("4")||choice.equals("5")||choice.equals("6")) {
					break;
				}
				else {
					System.out.println("Invalid choice.");
				}
			}
			Question q=new Question();
			if(choice.equals("1")) {
				q.addquestions();
			}
			else if(choice.equals("2")) {
				
			}
			else if(choice.equals("3")) {
				
			}
			else if(choice.equals("4")) {
				
			}
			else if(choice.equals("5")) {
				CompetitorList c=new CompetitorList();
				c.getAllplayers();
			}
			else if(choice.equals("6")) {
				break;
			}
		}
	}
}
