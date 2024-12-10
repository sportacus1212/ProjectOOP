package models;

import enums.Role;
import enums.School;
import java.util.Date;
import java.util.List;
import java.util.Map;

import DBPakage.Request;

public class Manager extends Employee {
    private List<Course> assignedCourses; // List of assigned courses
    private List<String> newsFeed; // News feed for announcements
    private List<Request<?>> studentRequests; 

    
    public Manager(String name, String surname, String password, int yoj, Role role, School school) {
    	super(name, surname, password, yoj, role, school);
    }
    
    

    // Approve student registration
    public boolean approveStudentRegistration(Student student) {
        if (student != null) {
            System.out.println("Approved registration for student: " + student.getName());
            return true;
        }
        System.out.println("Failed to approve registration: Student is null.");
        return false;
    }

    // Add a new course
    public boolean addCourse(Course course, String major, int year) {
        System.out.println("Added course: " + course.getName() + " for major: " + major + " year: " + year);
        return true;
    }

    // Assign a course to a teacher
    public boolean assignCourseToTeacher(Course course, Teacher teacher) {
        System.out.println("Assigned course: " + course.getName() + " to teacher: " + teacher.getName());
        return true;
    }

    // Add news
    public boolean addNews(String newsEntry) {
        newsFeed.add(newsEntry);
        System.out.println("Added news: " + newsEntry);
        return true;
    }

   
}
