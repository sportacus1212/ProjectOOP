package models;

import enums.ManagerType;
import enums.Role;
import enums.School;

import java.util.Map;
import java.util.List;

public class FinanceManager extends Employee {
    private float bankBalance; // The total balance of the finance office
    private ManagerType type;
    private Map<Student, Boolean> studentFeePaid; // Map tracking whether students have paid their fees
    private Map<Employee, Integer> salaryMap; // Map tracking the salaries of employees

  
    public FinanceManager(String name, String surname, String password, int yoj, Role role, ManagerType type) {
    	super(name, surname, password, role, yoj);
    	this.type = type;
    }
    
    
    
    
    // Block students who have not paid fees
    public boolean blockingStudents(Student student) {
        if (studentFeePaid.containsKey(student) && !studentFeePaid.get(student)) {
            System.out.println("Student " + student.getName() + " is blocked due to unpaid fees.");
            return true;
        }
        System.out.println("Student " + student.getName() + " has paid their fees or is not found.");
        return false;
    }

    // Give salary to employees
    public boolean givingSalary(List<Employee> employees) {
        for (Employee employee : employees) {
            if (bankBalance >= employee.getSalary()) {
                bankBalance -= employee.getSalary();
                salaryMap.put(employee, employee.getSalary());
                System.out.println("Salary paid to " + employee.getName() + ": $" + employee.getSalary());
            } else {
                System.out.println("Insufficient funds to pay salary for " + employee.getName());
                return false;
            }
        }
        return true;
    }

    // Give scholarships to students
    public boolean givingScholarship(List<Student> students) {
        for (Student student : students) {
            if (bankBalance >= 1000) { // Example: Fixed scholarship amount
                bankBalance -= 1000;
                System.out.println("Scholarship of $1000 granted to " + student.getName());
            } else {
                System.out.println("Insufficient funds to give scholarship to " + student.getName());
                return false;
            }
        }
        return true;
    }

    public float getBankBalance() {
        return bankBalance;
    }

	public static void welcomePage(FinanceManager user) {
		// TODO Auto-generated method stub
		
	}
}

