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

  

}

