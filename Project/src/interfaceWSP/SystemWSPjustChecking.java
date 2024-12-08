package interfaceWSP;


import java.util.Scanner;
import DBPakage.Database;
import models.User;

public class SystemWSPjustChecking {
    private Database database = new Database(); // Create an instance of Database

    // Welcome method
    void welcome() {
        try (Scanner input = new Scanner(System.in)) {
            System.out.println("Welcome to WSP. Log in/Sign in please!!!\nPlease, choose one of these options:\n    1. Log in\n    2. Sign in\n    3. Forget the password");
            int choice = input.nextInt();
            
            if(choice == 1) {
                logIn(); // Direct to login method
            } else if (choice == 2) {
                signIn(); // Direct to sign-in method
            } else if (choice == 3) {
                forgetPassword(); // Direct to forget password method
            } else {
                System.out.println("Invalid choice. Please restart and select a valid option.");
            }
        } catch (Exception e) {
            System.out.println("Invalid input! Please enter a number (1, 2, or 3).");
        }
    }

    // Log in method
    void logIn() {
        try (Scanner input = new Scanner(System.in)) {
            // Entering username and password
            System.out.println("Enter your username: ");
            String username = input.nextLine();
            System.out.println("Enter your password: ");
            String password = input.nextLine();
            
            // Accessing the database instance to get users
            for (User user : database.getUsers()) {  // Use 'database' instance here
                if (user.getLogin().equals(username) && user.getPassword().equals(password)) {
                    System.out.println("Login successful! Welcome " + user.getName());
                    offerLogout(input); // Offer to log out after login
                    return;
                }
            }
            System.out.println("Invalid username or password.");
        }
    }

    // Offer logout after successful login
    void offerLogout(Scanner input) {
        System.out.println("\nWould you like to log out?\n1. Yes\n2. No");
        int choice = input.nextInt();
        
        if (choice == 1) {
            logOut(); // Call logOut method to log out
        } else if (choice == 2) {
            System.out.println("You are still logged in. You can continue using the system.");
        } else {
            System.out.println("Invalid choice. Please restart.");
        }
    }

    // Log out method
    void logOut() {
        System.out.println("You have successfully logged out.");
        welcome(); // Return to welcome page after logout
    }

    // Sign in method (register new user)
    void signIn() {
        // Implement the sign-in functionality
    }

    // Forget password method
    void forgetPassword() {
        // Implement the forget password functionality
    }
}


