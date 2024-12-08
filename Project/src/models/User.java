package models;

import enums.Role;

public abstract class User {
    private String id;
    private String name;
    private String surname;
    private String login;
    private int yearOfJoining;
    private static int idFormat = 100000;
    

	private String password;
    private Role role;
    protected boolean isLogged; // Protected for access in subclasses

    public User(String name, String surname, String password, Role role, int yoj) {
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.role = role;
        this.yearOfJoining = yoj;
        this.isLogged = false; // Default to not logged in
        createId();
    }
    
    public User(String login, String pass, String id) {
    	this.login = login;
    	this.password = pass;
    	this.id = id;
    }

    // Generate unique ID (for simplicity, using a random number here)
    public String generateUniqueID() {
        return "UID-" + (int) (Math.random() * 10000);
    }

    // Log in the user
    public boolean login(String inputPassword) {
        if (this.password.equals(inputPassword)) {
            this.isLogged = true;
            System.out.println(name + " logged in successfully.");
            return true;
        }
        System.out.println("Incorrect password. Login failed.");
        return false;
    }

    // Display user-specific functionality (abstract)
    public abstract void displayFunc();

    // Change the password
    public void changePassword(String newPassword) {
        this.password = newPassword;
        System.out.println("Password changed successfully.");
    }
    
    // Simulate forgetting a password
    public void forgetPassword() {
        System.out.println("Reset link sent to the registered email for " + name);
    }
    
    
    //Creation of Id
    public void createId() {
    	idFormat++;
    	switch (role) {
        case Role.STUDENT: id = String.valueOf(yearOfJoining) + "B" + String.valueOf(idFormat); break;
        case Role.TEACHER: id = String.valueOf(yearOfJoining) + "T" + String.valueOf(idFormat); break;
        case Role.ADMIN: ; id = String.valueOf(yearOfJoining) + "A" + String.valueOf(idFormat); break;
        case Role.MANAGER: id = String.valueOf(yearOfJoining) + "M" + String.valueOf(idFormat); break;
        case Role.FINANCE_MANAGER: id = String.valueOf(yearOfJoining) + "F" + String.valueOf(idFormat); break;
    	}
    }
    
  //Creation of login
    public void createLogin() {
    	login = name.toLowerCase().charAt(0) + "_" + surname.toLowerCase();
    }
    
    

    // Getters for attributes
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getLogin() {
        return login;
    }

    public Role getRole() {
        return role;
    }
    
    public String getPassword() {
        return password; 
    }
}

