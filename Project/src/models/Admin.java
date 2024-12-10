package models;

import enums.LevelOfRequest;
import enums.Role;
import enums.School;
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
    private Database db = new Database();
   

    
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
    
    
    
    
    
    
    
    
    // Add a user to the managed list
    public boolean addUser(User user) {
        if (managedUsers.contains(user)) {
            System.out.println("User already exists in the system.");
            return false;
        }
        managedUsers.add(user);
        System.out.println("User added successfully: " + user.getName());
        return true;
    }

    // Delete a user by ID
    public boolean deleteUser(String userID) {
        boolean removed = managedUsers.removeIf(user -> user.getId().equals(userID));
        if (removed) {
            System.out.println("User with ID " + userID + " removed successfully.");
        } else {
            System.out.println("User with ID " + userID + " not found.");
        }
        return removed;
    }

    // Update user information
//    public boolean updateUserInfo(String userID, Map<String, Object> newInfo) {
//        for (User user : managedUsers) {
//            if (user.getId().equals(userID)) {
//                if (newInfo.containsKey("name")) {
//                    user.changePassword((String) newInfo.get("name"));
//                }
//                if (newInfo.containsKey("surname")) {
//                    user.setSurname((String) newInfo.get("surname"));
//                }
//                if (newInfo.containsKey("login")) {
//                    user.setLogin((String) newInfo.get("login"));
//                }
//                System.out.println("User information updated successfully for ID: " + userID);
//                return true;
//            }
//        }
//        System.out.println("User with ID " + userID + " not found.");
//        return false;
//    }

    // View log file
    public List<String> viewLogFile() {
        // Simulate reading log file
        System.out.println("Fetching logs from: " + logFilePath);
        return List.of("Log entry 1", "Log entry 2", "Log entry 3");
    }

    // Reset a user's password
    public boolean resetUserPassword(String userID) {
        for (User user : managedUsers) {
            if (user.getId().equals(userID)) {
                user.changePassword("default_password"); // Reset to default password
                System.out.println("Password reset successfully for user ID: " + userID);
                return true;
            }
        }
        System.out.println("User with ID " + userID + " not found.");
        return false;
    }

    // Generate a user report
//    public String generateUserReport() {
//        StringBuilder report = new StringBuilder("User Report:\n");
//        for (User user : managedUsers) {
//            report.append(user.getDetails()).append("\n");
//        }
//        System.out.println("Generated user report.");
//        return report.toString();
//    }

    @Override
    public void displayFunc() {
        System.out.println("Admin functionalities: Manage users, reset passwords, generate reports, etc.");
    }



	@Override
	public String toString() {
		return "Admin [Login=" + getLogin() + ", Password=" + getPassword() + ", username=" + getName() 
				+ ", db=" + db + "]";
	}

	
}

