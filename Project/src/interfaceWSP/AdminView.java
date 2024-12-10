package interfaceWSP;

import java.util.InputMismatchException;
import java.util.Scanner;

import models.Admin;

public class AdminView {
	public static void welcomePage(Admin admin) {
		System.out.println("Choose you action:\n    1.Read Requests\n    2.Delete the user\n    3.Delete all users\n    4.Add user");
		try (Scanner input = new Scanner(System.in)) {
			int action = input.nextInt();
			input.nextLine();
			
			if(action == 1) {
				admin.readRequest();
			} else if(action == 2) {
				SystemWSP.welcome();
			} else {
				System.out.println("Invalid input! Please enter a correct number.");
				welcomePage(admin);
			}
			
			
		} catch (InputMismatchException e) {
		    System.out.println("Invalid input! Please enter a correct number.");
		    
		}
	}
}
