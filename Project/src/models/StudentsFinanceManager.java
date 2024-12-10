package models;

import java.util.List;

public class StudentsFinanceManager extends FinanceManager {
    private List<Student> studentsList; // List of students managed by this class

    public StudentsFinanceManager(
            String name,
            String surname,
            String password,
            int yearOfJoining,
            Role role,
            ManagerType type,
            List<Student> studentsList) {
        super(name, surname, password, yearOfJoining, role, type); // Call to the parent class constructor
        this.studentsList = studentsList; // Initialize the unique field
    }
//constructor to students finance manager
    // Additional operations specific to managing student finances can go here

    @Override
    public void displayFunc() {
        System.out.println("Students Finance Manager functionalities: Manage student fees and scholarships.");
    }
}

