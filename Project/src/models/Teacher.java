package models;

import enums.Role;
import enums.School;
import enums.Status;

public class Teacher extends Employee {
    private Status status; // Status of the teacher (enum, e.g., PROFESSOR, LECTURER)
    private String subject; // Subject taught by the teacher
    private static double rating; // Static field for overall teacher rating

    public Teacher(String id, String name, String surname, String login, String password, int yearOfJoining, int salary, int workHours, School school, Status status, String subject) {
        super(id, name, surname, login, password, Role.TEACHER, yearOfJoining, salary, workHours, school);
        this.status = status;
        this.subject = subject;
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
        System.out.println(student.getDetails());
    }

    // Assign marks to a student for a course
    public void putMarks(Student student, Course course, double marks) {
        System.out.println("Assigning " + marks + " marks to " + student.getName() + " for the course: " + course.getName());
    }

    // Send a message to another employee
    public void sendMessage(Employee employee, String message) {
        System.out.println("Message sent to " + employee.getName() + ": " + message);
    }

    // Display teacher-specific functionalities
    @Override
    public void displayFunc() {
        System.out.println("Teacher functionalities: Manage courses, put marks, view students, etc.");
    }

    // Getters and setters
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public static double getRating() {
        return rating;
    }

    public static void setRating(double rating) {
        Teacher.rating = rating;
    }
}
