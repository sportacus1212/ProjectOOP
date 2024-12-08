package interfaceWSP;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import DBPakage.Database;
import models.User;

public class SystemWSP {
	public SystemWSP() {
		
	}
	
	//This is welcome page it will be first page which will shown to the user
	void welcome() {
		try (Scanner input = new Scanner(System.in)) {
			System.out.println("Welcome to WSP. Log in/Sing in please!!!\nPlease, choose one of this:\n    1.Log in\n    2.Sign up\n    3.Forget the password\n    4.Exit");
			int choice = input.nextInt();
			
			if(choice == 1) {
				logIn();
			} else if (choice == 2) {
		        signUp();
		    } else if (choice == 3) {
		        forgetPassword();
		    } else if (choice == 4) {
		        exit();
		    } else {
		        System.out.println("Invalid choice. Please restart and select a valid option.");
		    }
			
		} catch (InputMismatchException e) {
		    System.out.println("Invalid input! Please enter a number (1, 2, 3 or 4).");
		}
	}
	

//-----------------------------------------------------------------------------------------------------------------------
	
	
	//Functions in welcome page
	//Log in
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
			boolean isAuthenticated = false;
			
			for(User user: users) {
				if(username.equals(user.getLogin())) {
					int attempts = 0;
					
					while (attempts < 3) {
						if(password.equals(user.getPassword())) {
							System.out.println("You successfuly entered to your account. Welcome to Main Page " + user.getName() + " " + user.getSurname());
							isAuthenticated = true;
							
							char roleChar = user.getId().charAt(2);
							switch (roleChar) {
			                    case 'B': openStudentMainPage(); break;
			                    case 'T': openTeacherMainPage(); break;
			                    case 'A': openAdminMainPage(); break;
			                    case 'M': openManagerMainPage(); break;
			                    case 'F': openFinanceManagerMainPage(); break;
			                    default: System.out.println("Unknown role."); break;
							}
							break;
						} else {
							attempts++; 
			                if (attempts < 3) {
			                    System.out.println("Incorrect password. Please try again (" + (3 - attempts) + " attempts left): ");
			                    password = input.nextLine(); 
			                }
						}
					}
					
					if (attempts == 3) {
			            System.out.println("You have exceeded the maximum number of attempts.");
			            forgetPassword(); 
			        }
			        break;
				}
				
				if (!isAuthenticated) {
				    System.out.println("Invalid username or password. Please try again.");
				}
			}
			
			
		} catch (InputMismatchException e) {
		    System.out.println("Invalid input! Please enter a number (1, 2, 3 or 4).");
		}
	}
	
	//Sign up
	void signUp() {
		System.out.println("Please, fill this form:\n\nChoose who are you?\n    1.Teacher\n    2.Student\n    3.Manager\n    4.Finance Manager\n    5.Admin");
		try (Scanner input = new Scanner(System.in)) {
			int role = input.nextInt();
			
			//By role choosing type of registration
			if(role == 1) {
				System.out.println("Enter your name: ");
				String name = input.nextLine();
				System.out.println("Enter your surname: ");
				String surname = input.nextLine();
				System.out.println("Enter your surname: ");
			}
			
			
			
			
		} catch (InputMismatchException e) {
		    System.out.println("Invalid input! Please enter a number (1, 2, 3 or 4).");
		}
		
	
	//If forget Password
	void forgetPassword() {
		
	}
	
	//Exit 
	void exit() {
		
	}
	
	
//----------------------------------------------------------------------------------------------------------------
	
	
	//Interfaces 
	//For Student
	void openStudentMainPage() {
	
	}
	
	//For Teacher
	void openTeacherMainPage() {
		
	}
	
	//For Admin
	void openAdminMainPage() {
		
	}
	
	//For Manager
	void openManagerMainPage() {
		
	}
	
	//For Finance Manager
	void openFinanceManagerMainPage() {
		
	}
	
	
}
