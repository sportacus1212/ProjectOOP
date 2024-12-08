package models;

import enums.Role;
import enums.School;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class Manager extends Employee {
    private List<Course> assignedCourses; // List of assigned courses
    private List<String> newsFeed; // News feed for announcements
    private List<Request> studentRequests; // Student registration requests
    private Date courseRegistrationDeadline; // Course registration deadline
    private SortingOrder gpaSortingOrder; // Sorting order for GPA
    private List<Request> academicReports; // List of academic performance reports
    private Map<Integer, News> news; // Map of news entries with unique IDs

    public Manager(String id, String name, String surname, String login, String password, int yearOfJoining, int salary, int workHours, School school) {
        super(id, name, surname, login, password, Role.MANAGER, yearOfJoining, salary, workHours, school);
    }

    // Generate academic performance report
    public Report generateAcademicPerformanceReport() {
        System.out.println("Generating academic performance report...");
        // Simulate generating a report
        return new Report("Sample Academic Report");
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

    // Edit news by ID
    public boolean editNews(int newsID) {
        if (news.containsKey(newsID)) {
            System.out.println("Edited news with ID: " + newsID);
            return true;
        }
        System.out.println("News with ID: " + newsID + " not found.");
        return false;
    }

    // Delete news by ID
    public boolean deleteNews(int newsID) {
        if (news.remove(newsID) != null) {
            System.out.println("Deleted news with ID: " + newsID);
            return true;
        }
        System.out.println("News with ID: " + newsID + " not found.");
        return false;
    }

    // View student information sorted by criteria
    public List<Student> viewStudentInfo(SortingOrder sortBy) {
        System.out.println("Viewing student information sorted by: " + sortBy);
        return List.of(); // Simulate fetching sorted student information
    }

    // View teacher information sorted by criteria
    public List<Teacher> viewTeacherInfo(SortingOrder sortBy) {
        System.out.println("Viewing teacher information sorted by: " + sortBy);
        return List.of(); // Simulate fetching sorted teacher information
    }

    // View employee requests
    public List<Request> viewEmployeeRequests() {
        System.out.println("Viewing employee requests...");
        return studentRequests; // Return requests for now
    }

    @Override
    public void displayFunc() {
        System.out.println("Manager functionalities: Approve registrations, manage courses, generate reports, etc.");
    }
}
