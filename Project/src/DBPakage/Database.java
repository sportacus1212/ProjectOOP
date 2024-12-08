package DBPakage;


import java.util.List;

import enums.Role;
import enums.Subjects;

import java.util.ArrayList;
import models.Admin;
import models.Course;
//import models.Employee;
//import models.FinanceManager;
import models.Manager;
import models.Teacher;
import models.Student;
//import models.StudentsFinanceManager;
import models.User;

public class Database {
    // Lists to hold the different types of users
    private List<User> users = new ArrayList<>();
    public List<Student> students = new ArrayList<>();
    private List<Admin> admins = new ArrayList<>();
    private List<Manager> managers = new ArrayList<>();
    private List<Teacher> teachers = new ArrayList<>();
    private List<Course> courses = new ArrayList<>();

    // Lists to hold subjects for different departments
    private List<Subjects> subjects = new ArrayList<>();
    
    //Default ADMIN
    public Database() {
    	
    }
    
    public void addDefaultAdmin() {
        Admin admin = new Admin("admin", "admin", "admin");
        admins.add(admin);
        users.add(admin); 
    }
    
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
    
    public List<Subjects> getSubjects() {
        return subjects;
    }

}

