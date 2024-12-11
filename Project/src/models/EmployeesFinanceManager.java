package models;

import enums.ManagerType;
import enums.Role;
import java.util.Map;

public class EmployeesFinanceManager extends FinanceManager {
    private Map<Employee, Integer> employeeSalaries; // employee->salary
    public EmployeesFinanceManager(
        String name, 
        String surname, 
        String password, 
        int yearOfJoining, 
        Role role, 
        ManagerType type, 
        float bankBalance, 
        Map<Employee, Integer> employeeSalaries
    ) {
        super(name, surname, password, yearOfJoining, role, type); // parent constructor
        this.employeeSalaries = employeeSalaries; 
        this.setBankBalance(bankBalance); 
    }

    // needed operations

    @Override
    public void displayFunc() {
        System.out.println("Employees Finance Manager functionalities: Manage employee salaries and benefits.");
    }
}
