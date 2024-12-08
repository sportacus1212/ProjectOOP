package models;

import enums.Role;
import enums.School;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Admin extends Employee {
    private List<User> managedUsers; // List of managed users
    private String logFilePath; // Path to log file

    public Admin(String id, String name, String surname, String login, String password, int yearOfJoining, int salary, int workHours, School school, String logFilePath) {
        super(id, name, surname, login, password, Role.ADMIN, yearOfJoining, salary, workHours, school);
        this.managedUsers = new ArrayList<>();
        this.logFilePath = logFilePath;
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
    public boolean updateUserInfo(String userID, Map<String, Object> newInfo) {
        for (User user : managedUsers) {
            if (user.getId().equals(userID)) {
                if (newInfo.containsKey("name")) {
                    user.changePassword((String) newInfo.get("name"));
                }
                if (newInfo.containsKey("surname")) {
                    user.setSurname((String) newInfo.get("surname"));
                }
                if (newInfo.containsKey("login")) {
                    user.setLogin((String) newInfo.get("login"));
                }
                System.out.println("User information updated successfully for ID: " + userID);
                return true;
            }
        }
        System.out.println("User with ID " + userID + " not found.");
        return false;
    }

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
    public String generateUserReport() {
        StringBuilder report = new StringBuilder("User Report:\n");
        for (User user : managedUsers) {
            report.append(user.getDetails()).append("\n");
        }
        System.out.println("Generated user report.");
        return report.toString();
    }

    @Override
    public void displayFunc() {
        System.out.println("Admin functionalities: Manage users, reset passwords, generate reports, etc.");
    }
}

