package models;

import java.util.List;
import enums.ManagerType;
import enums.Role;

public class StudentsFinanceManager extends FinanceManager {
    private List<Student> studentsList; 

    public StudentsFinanceManager(String name,String surname, String password, int yearOfJoining, Role role, ManagerType type, float bankBalance, List<Student> studentsList) {
        super(name, surname, password, yearOfJoining, role, type); 
        this.studentsList = studentsList; 
        this.setBankBalance(bankBalance);
    }

    // needed operations

    @Override
    public void displayFunc() {
        System.out.println("Students Finance Manager functionalities: Manage student fees and scholarships.");
    }
}


