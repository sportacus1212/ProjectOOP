package models;

import enums.Role;
import enums.School;

public class Student extends User {
    private School school;

    // Constructor
    public Student(String name, String surname, String password, Role role, int yoj, School school) {
    	super(name, surname, password, role, yoj);
    	this.school = school;
    }
    
    
    



   
}

