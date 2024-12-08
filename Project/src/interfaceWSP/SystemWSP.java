package interfaceWSP;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import DBPakage.Database;

public class SystemWSP {
	public SystemWSP() {
		
	}
	
	//This is welcome page it will be first page which will shown to the user
	void welcome() {
		try (Scanner input = new Scanner(System.in)) {
			System.out.println("Welcome to WSP. Log in/Sing in please!!!\nPlease, choose one of this:\n    1.Log in\n    2.Sign in\n    3.Forget the password");
			int choice = input.nextInt();
			
			if(choice == 1) {
				logIn();
			} else if (choice == 2) {
		        signIn();
		    } else if (choice == 3) {
		        forgetPassword();
		    } else {
		        System.out.println("Invalid choice. Please restart and select a valid option.");
		    }
			
		} catch (InputMismatchException e) {
		    System.out.println("Invalid input! Please enter a number (1, 2, or 3).");
		}
	}
	
	//Functions in welcome page
	void logIn() {
		try (Scanner input = new Scanner(System.in)) {
			//Entering user name
			System.out.println("Enter your username: ");
			String username = input.nextLine();
			//Entering password
			System.out.println("Enter your password: ");
			String password = input.nextLine();
			
			//Checking for correct password and user name
			List<User> users = Database.getUsers();
			for(User user: users) {
				if(username.equals(user.getLogin())) {
					if(password.equals(user.getPassword())) {
						System.out.println("You successfuly entered to your account. Welcome to Main Page " + user.getName() + " " + user.getSurname());
						if((user.getId().charAt(2)).equals('B')) {
							
						}
					}
				}
			}
			
			
		} catch (InputMismatchException e) {
		    System.out.println("Invalid input! Please enter a number (1, 2, or 3).");
		}
	}
	
	void signIn() {
		
	}
	
	void forgetPassword() {
		
	}
	
}
