package models;

import enums.Role;

public abstract class User {
    private String id;
    private String name;
    private String surname;
    private String login;
    private String password;
    private Role role;
    protected boolean isLogged; // Protected for access in subclasses
    protected int yearOfJoining; // Protected for subclass access

    public User(String id, String name, String surname, String login, String password, Role role, int yearOfJoining) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
        this.role = role;
        this.isLogged = false; // Default to not logged in
        this.yearOfJoining = yearOfJoining;
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

    public int getYearOfJoining() {
        return yearOfJoining;
    }
    
    public String getPassword() {
        return id; 
    }
}

