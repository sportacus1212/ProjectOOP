package models;

import enums.Role;
import enums.School;

public abstract class Employee extends User {
    private int salary; // Employee salary
    private int workHours; // Work hours per week
    private School school; // School (enums)

    public Employee(String id, String name, String surname, String login, String password, Role role, int yearOfJoining, int salary, int workHours, School school) {
        super(id, name, surname, login, password, role, yearOfJoining);
        this.salary = salary;
        this.workHours = workHours;
        this.school = school;
    }

    // Calculate bonus based on work hours and salary
    public int calculateBonus() {
        // Example: Bonus is 10% of monthly salary if work hours exceed 40
        if (workHours > 40) {
            return (int) (salary * 0.10);
        }
        return 0;
    }

    // Update work hours
    public void updateWorkHours(int hours) {
        this.workHours = hours;
        System.out.println("Work hours updated to: " + workHours + " hours/week");
    }

    // Display employee details
    public void displayEmployeeDetails() {
        System.out.println("Employee Details:");
        System.out.println("Name: " + getName() + " " + getSurname());
        System.out.println("Role: " + getRole());
        System.out.println("School: " + school);
        System.out.println("Salary: $" + salary);
        System.out.println("Work Hours: " + workHours + " hours/week");
    }

    // Abstract method to ensure subclasses implement their specific functionality
    @Override
    public abstract void displayFunc();

    // Getters and Setters
    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getWorkHours() {
        return workHours;
    }

    public School getSchool() {
        return school;
    }
}