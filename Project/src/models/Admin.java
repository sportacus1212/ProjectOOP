package models;

import enums.LevelOfRequest;
import enums.ManagerType;
import enums.Role;
import enums.School;
import enums.Status;
import enums.Subjects;
import interfaceWSP.AdminView;
import interfaceWSP.SystemWSP;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

import DBPakage.Database;
import DBPakage.Request;
import DBPakage.Serializer;

public class Admin extends Employee {
    private List<User> managedUsers; // List of managed users
    private static String logFilePath = "C:\\Users\\Hush\\git\\ProjectOOP\\Project\\src\\DBPakage\\databaseOOP"; // Path to log file
    private Queue<Request<?>> requests = new ArrayDeque<>(); //List of Requests
    private static Database db = new Database();
   

    
    public Admin(String name, String surname, String password, Role role, int yoj) {
    	super(name, surname, password, role, yoj);
    	this.managedUsers = new ArrayList<>();
    }
    
    public Admin(String log, String pass, String id) {
    	super(log, pass, id);
    	this.managedUsers = new ArrayList<>();
    }
    
    
    
    //Getting Request
    public void getRequest(Request<?> r) {
    	requests.add(r);
    }
    
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------   
    
    //Read Requests
    @SuppressWarnings("unchecked")
	public <T> void readRequest() {
    	System.out.println("You have " + requests.size() + " requests. Do you want read them?\n    1.Yes\n    2.No");
    	try (Scanner input = new Scanner(System.in)) {
    		int read = input.nextInt();
    		input.nextLine();
    		
    		//Reading request
    		if(read == 1) {
		    	Request<T> request = (Request<T>) requests.poll();
		    	System.out.println(request.toString());
		    	
		    	//ADD_USER OPTION
		    	if(request.getLevel().equals(LevelOfRequest.ADD_URSER)) {
		    		request.toString();
		    		System.out.println("Do you want add this user to Database?\n    1.Yes\n    2.No\n    3.Decide leter");
		    		int decision = input.nextInt();
		    		input.nextLine(); 
		    		//Adding User
		    		if(decision == 1) {
		    			T obj = (T) request.getObj();
		    			User userObj = (User) request.getObj();
		    			managedUsers.add(userObj);
		    		    
		    		    // Проверяем тип объекта и добавляем в соответствующий список
		    		    if (obj instanceof Student) {
		    		        db.getStudents().add((Student) obj);
		    		        System.out.println("Student added to the students list.");
		    		    } else if (obj instanceof Admin) {
		    		    	db.getAdmins().add((Admin) obj);
		    		        System.out.println("Admin added to the admins list.");
		    		    } else if (obj instanceof Manager) {
		    		    	db.getManagers().add((Manager) obj);
		    		        System.out.println("Manager added to the managers list.");
		    		    } else if (obj instanceof Teacher) {
		    		    	db.getTeachers().add((Teacher) obj);
		    		        System.out.println("Teacher added to the teachers list.");
		    		    } else if (obj instanceof User) {
		    		    	db.getUsers().add((User) obj);
		    		        System.out.println("User added to the users list.");
		    		    } else if (obj instanceof FinanceManager) {
		    		    	db.getFinanceManager().add((FinanceManager) obj);
		    		        System.out.println("User added to the users list.");
		    		    } else {
		    		        System.out.println("Unknown object type. Cannot add to any list.");
		    		    }
		    		    
		    		}
		    		
		    		// Сериализуем базу данных в файл logFilePath
		    	    if (logFilePath != null && !logFilePath.isEmpty()) {
		    	        Serializer.saveObject(logFilePath, db);  // Сериализуем базу данных
		    	        System.out.println("Database has been serialized to: " + logFilePath);
		    	    } else {
		    	        System.err.println("Log file path is not set. Cannot serialize database.");
		    	    }
		    		
		    		 // Сериализуем список managedUsers
		    	    if (logFilePath != null && !logFilePath.isEmpty()) {
		    	        String managedUsersFilePath = logFilePath.replace(".ser", "_managedUsers.ser");
		    	        Serializer.saveObject(managedUsersFilePath, managedUsers);  // Сериализуем managedUsers
		    	        System.out.println("ManagedUsers list has been serialized to: " + managedUsersFilePath);
		    	    } else {
		    	        System.err.println("Log file path is not set. Cannot serialize managedUsers.");
		    	    }
		    	    
		    	    AdminView.welcomePage(this);
		    		
		    	}
		    	
		    //Go to back
    		} else if(read == 2) {
    			AdminView.welcomePage(this);
    		} else {
    			System.out.println("Please enter 1 or 2");
    			AdminView.welcomePage(this);
    		}
    		
    	} catch (InputMismatchException e) {
		    System.out.println("Invalid input! Please enter a number accepted.");
		}
    	
    	AdminView.welcomePage(this);
    }
    
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------
    
    //Add a user
    public void addUser() {
    	System.out.println("Which type of user you want to add?\n    1.Teacher\\n    2.Student\\n    3.Manager\\n    4.Finance Manager\\n    5.Admin");
    	try (Scanner input = new Scanner(System.in)) {
			int role = input.nextInt();
			input.nextLine();
			
			//By role choosing type of registration
			//For teacher
			if(role == 1) {
				System.out.println("Enter name: ");
				String name = input.nextLine();
				
				System.out.println("Enter surname: ");
				String surname = input.nextLine();
				
				System.out.println("Choose school:\n    1.FIT\n    2.KMA\n    3.ISE\n    4.BS\n    5.FGE\n    6.SCE");
				int shcool = input.nextInt();
				input.nextLine();
				
				System.out.println("Choose status:\n    1.Assistant\n    2.Tutor\n    3.Lector\n    4.Senior Lector\n    5.Professor");
				int status = input.nextInt();
				input.nextLine();
				
				System.out.println("Enter your year of joining: ");
				int yearOfJoining = input.nextInt();
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

				
				Teacher teacher = new Teacher(name, surname, password, Role.TEACHER, yearOfJoining, schName, st, sbj);
				db.getTeachers().add(teacher);
				System.out.println("Teacher added to the teachers list.");
				AdminView.welcomePage(this);				
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
				
				System.out.println("When you join to occupation? ");
				int yearOfStudy = input.nextInt();
				input.nextLine();
				
				System.out.println("Create a password: ");
				String password = input.nextLine();
				
				School schName = null;
				switch (shcool) {
                    case 1: schName = School.FIT; break;
                    case 2: schName = School.KMA; break;
                    case 3: schName = School.ISE; break;
                    case 4: schName = School.BS; break;
                    case 5: schName = School.FGE; break;
                    case 6: schName = School.SCE; break;
				}
				
				Student student = new Student(name, surname, password, Role.STUDENT, yearOfStudy, schName);
				db.getStudents().add(student);
		        System.out.println("Student added to the students list.");
		        AdminView.welcomePage(this);
			}
			
			//For manager
			else if(role == 3) {
				System.out.println("Enter your name: ");
				String name = input.nextLine();
				
				System.out.println("Enter your surname: ");
				String surname = input.nextLine();
				
				System.out.println("Create a password: ");
				String password = input.nextLine();
				
				System.out.println("When you join to occupation? ");
				int yearOfJoining = input.nextInt();
				input.nextLine();
				
				System.out.println("Choose your school:\n    1.FIT\n    2.KMA\n    3.ISE\n    4.BS\n    5.FGE\n    6.SCE");
				int shcool = input.nextInt();
				input.nextLine();
				
				
				School schName = null;
				switch (shcool) {
                    case 1: schName = School.FIT; break;
                    case 2: schName = School.KMA; break;
                    case 3: schName = School.ISE; break;
                    case 4: schName = School.BS; break;
                    case 5: schName = School.FGE; break;
                    case 6: schName = School.SCE; break;
				}
				
				Manager manager = new Manager(name, surname, password, yearOfJoining, Role.MANAGER, schName);
				db.getManagers().add(manager);
		        System.out.println("Manager added to the managers list.");
		        AdminView.welcomePage(this);
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
				
				System.out.println("When you join to occupation? ");
				int yearOfJoining = input.nextInt();
				input.nextLine();
				
				
				ManagerType managerType = null;
				switch (type) {
                    case 1: managerType = ManagerType.EMPLOYEE; break;
                    case 2: managerType = ManagerType.STUDENT; break;
				}
				
				FinanceManager fmanager = new FinanceManager(name, surname, password, yearOfJoining, Role.MANAGER, managerType);
				db.getFinanceManager().add(fmanager);
		        System.out.println("User added to the users list.");
		        AdminView.welcomePage(this);
			}
			
			//For admin
			else if(role == 5) {
				System.out.println("Enter your name: ");
				String name = input.nextLine();
				
				System.out.println("Enter your surname: ");
				String surname = input.nextLine();
				
				System.out.println("Create a password: ");
				String password = input.nextLine();
				
				System.out.println("When you join to occupation? ");
				int yearOfJoining = input.nextInt();
				input.nextLine();
				
				
				Admin admin = new Admin(name, surname, password, Role.ADMIN, yearOfJoining);
				db.getAdmins().add(admin);
		        System.out.println("Admin added to the admins list.");
		        AdminView.welcomePage(this);
			}

			
			
		} catch (InputMismatchException e) {
		    System.out.println("Invalid input! Please enter a number (1, 2, 3 or 4).");
		}
		
    	AdminView.welcomePage(this);
    }

//----------------------------------------------------------------------------------------------------------------------------------------------------------------------    

    //Delete a user
	public void deleteUser() {
    	System.out.println("Which type of user you want to delete?\n    1.Teacher\n    2.Student\n    3.Manager\n    4.Finance Manager\n    5.Admin");
    	try (Scanner input = new Scanner(System.in)) {
			int role = input.nextInt();
			input.nextLine();
			boolean found = false;			
			
			if(role == 1) {
				System.out.println("Enter ID of the teacher: ");
				String id = input.nextLine();
				
				for(int i = 0; i < db.getTeachers().size(); i++) {
					if((db.getTeachers().get(i).getId()).equals(id)) {
						Teacher delTeacher = db.getTeachers().get(i);
						String name = delTeacher.getName();
						String surname = delTeacher.getSurname();
						db.getTeachers().remove(i);
						System.out.println(name + " " + surname + " is successfully deleted from database");
						found = true;
						break;
					}
				}
				
				if(!found) {
					System.out.println("Teacher with this ID is not found if you want rewrite ID choose 1 or go to main page\n    1.Try again\n    2.Go back");
					int choice = input.nextInt();
					input.nextLine();
					
					if(choice == 1) {
						deleteUser();
					} else if(choice == 2) {
						AdminView.welcomePage(this);
					}
				}
			} else if(role == 2) {
				System.out.println("Enter ID of the student: ");
				String id = input.nextLine();
				
				for(int i = 0; i < db.getStudents().size(); i++) {
					if((db.getStudents().get(i).getId()).equals(id)) {
						Student delTeacher = db.getStudents().get(i);
						String name = delTeacher.getName();
						String surname = delTeacher.getSurname();
						db.getStudents().remove(i);
						System.out.println(name + " " + surname + " is successfully deleted from database");
						found = true;
						break;
					}
				}
				
				if(!found) {
					System.out.println("Student with this ID is not found if you want rewrite ID choose 1 or go to main page\n    1.Try again\n    2.Go back");
					int choice = input.nextInt();
					input.nextLine();
					
					if(choice == 1) {
						deleteUser();
					} else if(choice == 2) {
						AdminView.welcomePage(this);
					}
				}
			} else if(role == 3) {
				System.out.println("Enter ID of the manager: ");
				String id = input.nextLine();
				
				for(int i = 0; i < db.getManagers().size(); i++) {
					if((db.getManagers().get(i).getId()).equals(id)) {
						Manager delTeacher = db.getManagers().get(i);
						String name = delTeacher.getName();
						String surname = delTeacher.getSurname();
						db.getManagers().remove(i);
						System.out.println(name + " " + surname + " is successfully deleted from database");
						found = true;
						break;
					}
				}
				
				if(!found) {
					System.out.println("Manager with this ID is not found if you want rewrite ID choose 1 or go to main page\n    1.Try again\n    2.Go back");
					int choice = input.nextInt();
					input.nextLine();
					
					if(choice == 1) {
						deleteUser();
					} else if(choice == 2) {
						AdminView.welcomePage(this);
					}
				}
			} else if(role == 4) {
				System.out.println("Enter ID of the finance manager: ");
				String id = input.nextLine();
				
				for(int i = 0; i < db.getFinanceManager().size(); i++) {
					if((db.getFinanceManager().get(i).getId()).equals(id)) {
						FinanceManager delTeacher = db.getFinanceManager().get(i);
						String name = delTeacher.getName();
						String surname = delTeacher.getSurname();
						db.getFinanceManager().remove(i);
						System.out.println(name + " " + surname + " is successfully deleted from database");
						found = true;
						break;
					}
				}
				
				if(!found) {
					System.out.println("Finance manager with this ID is not found if you want rewrite ID choose 1 or go to main page\n    1.Try again\n    2.Go back");
					int choice = input.nextInt();
					input.nextLine();
					
					if(choice == 1) {
						deleteUser();
					} else if(choice == 2) {
						AdminView.welcomePage(this);
					}
				}
			} else if(role == 5) {
				System.out.println("Enter ID of the finance admin: ");
				String id = input.nextLine();
				
				for(int i = 0; i < db.getAdmins().size(); i++) {
					if((db.getAdmins().get(i).getId()).equals(id)) {
						Admin delTeacher = db.getAdmins().get(i);
						String name = delTeacher.getName();
						String surname = delTeacher.getSurname();
						db.getAdmins().remove(i);
						System.out.println(name + " " + surname + " is successfully deleted from database");
						found = true;
						break;
					}
				}
				
				if(!found) {
					System.out.println("Finance manager with this ID is not found if you want rewrite ID choose 1 or go to main page\n    1.Try again\n    2.Go back");
					int choice = input.nextInt();
					input.nextLine();
					
					if(choice == 1) {
						deleteUser();
					} else if(choice == 2) {
						AdminView.welcomePage(this);
					}
				}
			}
			
			
			
    	} catch (InputMismatchException e) {
		    System.out.println("Invalid input! Please enter a number (1, 2, 3, 4 or 5).");
		}
    	
    }

//----------------------------------------------------------------------------------------------------------------------------------------------------------------------    
	
	//Delete all users
	public void deleteAllUsers() {
		System.out.println("Which type of user you want to delete?\n    1.Teacher\n    2.Student\n    3.Manager\n    4.Finance Manager\n    5.Admin");
		
		System.out.println("Are you sure that you want to delete all users from database?\n    1.Yes\n    2.No");
		try (Scanner input = new Scanner(System.in)) {
			int answer = input.nextInt();
			input.nextLine();
			
			if(answer == 1) {
				System.out.println("Verify that you are real admin, enter your password: ");
				String password = input.nextLine();
				if(this.getPassword().equals(password)) {
					db.getTeachers().clear();
				}
			}
			
			
			
		} catch (InputMismatchException e) {
		    System.out.println("Invalid input! Please enter a number (1 or 2).");
		}
	}
	
	
	@Override
	public String toString() {
		return "Admin [Login=" + getLogin() + ", Password=" + getPassword() + ", username=" + getName() 
				+ ", db=" + db + "]";
	}

	
}

