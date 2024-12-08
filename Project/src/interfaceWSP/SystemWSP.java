package interfaceWSP;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import DBPakage.Database;
import enums.Role;
import enums.School;
import enums.Status;
import enums.Subjects;
import models.Admin;
import models.FinanceManager;
import models.Manager;
import models.Student;
import models.Teacher;
import models.User;

public class SystemWSP {
	Database database = new Database(); 
	
	public SystemWSP() {
	}
	


	//This is welcome page it will be first page which will shown to the user
	void welcome() {
		database.addDefaultAdmin();
		try (Scanner input = new Scanner(System.in)) {
			System.out.println("Welcome to WSP. Log in/Sing in please!!!\nPlease, choose one of this:\n    1.Log in\n    2.Sign up\n    3.Forget the password\n    4.Exit");
			int choice = input.nextInt();
			input.nextLine();
			
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
			System.out.println("Enter your login: ");
			String login = input.nextLine();
			//Entering password
			System.out.println("Enter your password: ");
			String password = input.nextLine();
			
			//Checking for correct password and user name
			List<User> users = database.getUsers();
			boolean isAuthenticated = false;
			
			if(!(users.isEmpty())) {
				for(User user: users) {
					if(login.equals(user.getLogin())) {
						int attempts = 0;
						
						while (attempts < 3) {
							if(password.equals(user.getPassword())) {
								System.out.println("You successfuly entered to your account. Welcome to Main Page " + user.getName() + " " + user.getSurname());
								isAuthenticated = true;
								
								char roleChar = user.getId().charAt(2);
								switch (roleChar) {
				                    case 'B': openStudentMainPage((Student) user); break;
				                    case 'T': openTeacherMainPage((Teacher) user); break;
				                    case 'A': openAdminMainPage((Admin) user); break;
				                    case 'm': openAdminMainPage((Admin) user); break;
				                    case 'M': openManagerMainPage((Manager) user); break;
				                    case 'F': openFinanceManagerMainPage((FinanceManager) user); break;
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
			} else {
				System.out.println("Database is not ready now. Please try again.");
				exit();
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
			input.nextLine();
			
			//By role choosing type of registration
			//For teacher
			if(role == 1) {
				System.out.println("Enter your name: ");
				String name = input.nextLine();
				
				System.out.println("Enter your surname: ");
				String surname = input.nextLine();
				
				System.out.println("Choose your school:\n    1.FIT\n    2.KMA\n    3.ISE\n    4.BS\n    5.FGE\n    6.SCE");
				int shcool = input.nextInt();
				input.nextLine();
				
				System.out.println("Choose your status:\n    1.Assistant\n    2.Tutor\n    3.Lector\n    4.Senior Lector\n    5.Professor");
				int status = input.nextInt();
				input.nextLine();
				
				System.out.println("Enter your year of joining: ");
				int yoj = input.nextInt();
				input.nextLine();
				
				System.out.println("Enter your subject with CAPITAL LETTERS: ");
				String subject = input.nextLine();
				
				System.out.println("Create a password: ");
				String password = input.nextLine();
				
				//Creating Teacher Object
				School schName = null;
				switch (shcool) {
                    case 1: schName = School.FIT; break;
                    case 2: schName = School.KMA; break;
                    case 3: schName = School.ISE; break;
                    case 4: schName = School.BS; break;
                    case 5: schName = School.FGE; break;
                    case 6: schName = School.SCE; break;
				}
				
				Status st = null;

				switch (status) {
				    case 1: st = Status.ASSISTANT; break;
				    case 2: st = Status.TUTOR; break;
				    case 3: st = Status.LECTOR; break;
				    case 4: st = Status.SENIOR_LECTOR; break;
				    case 5: st = Status.PROFESSOR; break;
				}
				
				Subjects sbj = null;
				try {
				    sbj = Subjects.valueOf(subject.toUpperCase());  
				} catch (IllegalArgumentException e) {
				    System.out.println("Invalid subject entered.");
				}

				
				Teacher teacher = new Teacher(name, surname, password, Role.TEACHER, yoj, schName, st, sbj);
				teacher.sendRequestADD(database.getAdmins().get(0));
				
				welcome();
				
			} 
			
			//For student
			else if(role == 2) {
				System.out.println("Enter your name: ");
				String name = input.nextLine();
				
				System.out.println("Enter your surname: ");
				String surname = input.nextLine();
				
				System.out.println("Choose your school:\n    1.FIT\n    2.KMA\n    3.ISE\n    4.BS\n    5.FGE\n    6.SCE");
				int shcool = input.nextInt();
				input.nextLine();
				
				System.out.println("When you enter to university? ");
				int yearOfStudy = input.nextInt();
				input.nextLine();
				
				System.out.println("Create a password: ");
				String password = input.nextLine();
				
				
			}
			
			//For manager
			else if(role == 3) {
				System.out.println("Enter your name: ");
				String name = input.nextLine();
				
				System.out.println("Enter your surname: ");
				String surname = input.nextLine();
				
				System.out.println("Create a password: ");
				String password = input.nextLine();
			}
			
			//For finance manager
			else if(role == 4) {
				System.out.println("Enter your name: ");
				String name = input.nextLine();
				
				System.out.println("Enter your surname: ");
				String surname = input.nextLine();
				
				System.out.println("What type of finance manager you are?:\n    1.For Student\n    2.For Employee");
				int type = input.nextInt();
				input.nextLine();
				
				System.out.println("Create a password: ");
				String password = input.nextLine();
			}
			
			//For admin
			else if(role == 5) {
				System.out.println("Enter your name: ");
				String name = input.nextLine();
				
				System.out.println("Enter your surname: ");
				String surname = input.nextLine();
				
				System.out.println("Create a password: ");
				String password = input.nextLine();
			}

			
			
		} catch (InputMismatchException e) {
		    System.out.println("Invalid input! Please enter a number (1, 2, 3 or 4).");
		}
		
		
	}
		
	
	//If forget Password
	void forgetPassword() {
		
	}
	
	//Exit 
	void exit() {
		welcome();
	}
	
	
//----------------------------------------------------------------------------------------------------------------
	
	
	//Interfaces 
	//For Student
	void openStudentMainPage(Student student) {
	
	}
	
	//For Teacher
	void openTeacherMainPage(Teacher teacher) {
		
	}
	
	//For Admin
	public void openAdminMainPage(Admin admin) {
		System.out.println("Choose you action:\n    1.Read Requests\n    2.Exit");
		try (Scanner input = new Scanner(System.in)) {
			int action = input.nextInt();
			input.nextLine();
			
			if(action == 1) {
				admin.readRequest();
			} else if(action == 2) {
				exit();
			}
			
			
		} catch (InputMismatchException e) {
		    System.out.println("Invalid input! Please enter a correct number.");
		}
	}
	
	//For Manager
	void openManagerMainPage(Manager manager) {
		
	}
	
	//For Finance Manager
	void openFinanceManagerMainPage(FinanceManager FManager) {
		
	}
	
	
}
