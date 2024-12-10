package models;

import DBPakage.Request;
import enums.LevelOfRequest;
import enums.Role;
import enums.School;
import enums.Status;
import enums.Subjects;

public class Teacher extends Employee {
    private Status status; // Status of the teacher (enum, e.g., PROFESSOR, LECTURER)
    private Subjects subject; // Subject taught by the teacher
    private static double rating; // Static field for overall teacher rating

    public Teacher(String name, String surname, String password, Role role, int yoj, School school, Status status, Subjects subject) {
    	super(name, surname, password, yoj, role, school);
    	this.status = status;
    	this.subject = subject;
    	
    }
    
    
    //Sending verification to Admin to create Account;
    public void sendRequestADD(Admin a) {
    	Request<Teacher> createAcc = new Request<Teacher>("Please Approve my account!!!", LevelOfRequest.ADD_URSER, this);
    	createAcc.sendRequest(a);
    }
    
    
    
    // View information about the course
    public void viewCourse(Course course) {
        System.out.println("Course Information:");
        System.out.println("Course Name: " + course.getName());
    }

    // Manage courses
    public void manageCourse() {
        System.out.println("Managing courses...");
    }

    // View students in a course
    public void viewStudents(Student student) {
        System.out.println("Viewing student details:");
        //System.out.println(student.getDetails());
    }

    // Assign marks to a student for a course
    public void putMarks(Student student, Course course, double marks) {
        System.out.println("Assigning " + marks + " marks to " + student.getName() + " for the course: " + course.getName());
    }

    // Send a message to another employee
    public void sendMessage(Employee employee, String message) {
        System.out.println("Message sent to " + employee.getName() + ": " + message);
    }

    // Getters and setters
    public Status getStatus() {
        return status;
    }


    public Subjects getSubject() {
        return subject;
    }

    public static double getRating() {
        return rating;
    }

}
