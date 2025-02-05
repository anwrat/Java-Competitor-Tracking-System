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
			System.out.println("4.View Questions by Difficulty");
			System.out.println("5.View Player Reports");
			System.out.println("6.LogOut");
			String choice;
			while(true) {
				System.out.println("Enter your choice(1/2/3/4/5/6):");
				choice=obj.next();
				if(choice.equals("1")||choice.equals("2")||choice.equals("3")||choice.equals("4")||choice.equals("5")||choice.equals("6")) {
					break;
				}
				else {
					System.out.println("Invalid choice.");
				}
			}
			Question q=new Question();
			//For adding question
			if(choice.equals("1")) {
				q.addquestions();
			}
			//For Deleting question
			else if(choice.equals("2")) {
				System.out.println("Enter the ID of question to delete: ");
				int id=obj.nextInt();
				if(q.searchbyID(id)) {
					q.deletequestions(id);
				}
				else {
					System.out.println("No Questions found of ID: "+id);
				}
			}
			//For Updating question
			else if(choice.equals("3")) {
				System.out.println("Enter the ID of question to update: ");
				int id=obj.nextInt();
				if(q.searchbyID(id)) {
					q.updatequestions(id);
				}
				else {
					System.out.println("No Questions found of ID: "+id);
				}
			}
			//For viewing questions by level
			else if(choice.equals("4")) {
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
				q.viewbylevel(level);
			}
			//For viewing player report
			else if(choice.equals("5")) {
				CompetitorList c=new CompetitorList();
				c.getAllplayers();
			}
			//For logging out
			else if(choice.equals("6")) {
				break;
			}
		}
	}
}
