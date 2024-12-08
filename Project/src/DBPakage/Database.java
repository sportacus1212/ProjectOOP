package DBPakage;


import java.util.List;
import java.util.ArrayList;
import models.Admin;
import models.Course;
import models.Employee;
import models.FinanceManager;
import models.Manager;
import models.Teacher;
import models.Student;
import models.StudentsFinanceManager;
import models.User;

public class Database {
    // Lists to hold the different types of users
    private List<User> users = new ArrayList<>();
    private List<Student> students = new ArrayList<>();
    private List<Admin> admins = new ArrayList<>();
    private List<Manager> managers = new ArrayList<>();
    private List<Teacher> teachers = new ArrayList<>();
    private List<Course> courses = new ArrayList<>();

    // Getters for the lists
    public List<User> getUsers() {
        return users;
    }

    public List<Student> getStudents() {
        return students;
    }

    public List<Admin> getAdmins() {
        return admins;
    }

    public List<Manager> getManagers() {
        return managers;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public List<Course> getCourses() {
        return courses;
    }

    // Setter for users list (optional if you need to replace the list)
    public void setUsers(List<User> users) {
        this.users = users;
    }

    // Method to add a new user to the list
    public boolean addUser(User user) {
        // You can add validation checks like duplicate username if needed
        for (User existingUser : users) {
            if (existingUser.getLogin().equals(user.getLogin())) {
                System.out.println("Username already exists.");
                return false;
            }
        }
        users.add(user);  // Add the user to the list
        return true;
    }

    // Example method for user login validation
    public User authenticateUser(String username, String password) {
        for (User user : users) {
            if (user.getLogin().equals(username) && user.getPassword().equals(password)) {
                return user;  // Return the authenticated user
            }
        }
        return null;  // Return null if no match
    }
}

