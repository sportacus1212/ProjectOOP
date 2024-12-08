package models;

import java.util.List;

public class StudentsFinanceManager extends FinanceManager {
    private List<Student> studentsList; // List of students managed by this class

    public StudentsFinanceManager(String id, String name, String surname, String login, String password, int yearOfJoining, int salary, int workHours, float bankBalance, List<Student> studentsList) {
        super(id, name, surname, login, password, yearOfJoining, salary, workHours, School.FIT, bankBalance);
        this.studentsList = studentsList;
    }

    // Additional operations specific to managing student finances can go here

    @Override
    public void displayFunc() {
        System.out.println("Students Finance Manager functionalities: Manage student fees and scholarships.");
    }
}

