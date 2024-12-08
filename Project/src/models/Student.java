package models;

public class Student extends User {
    private String major;

    // Constructor
    public Student(int id, String name, String surname, String major) {
        super(id, name, surname, "Student");  // Calling the constructor of User class
        this.major = major;
    }

    // Getter for major
    public String getMajor() {
        return major;
    }

    // Setter for major
    public void setMajor(String major) {
        this.major = major;
    }

    // Override the displayInfo method
    @Override
    public void displayInfo() {
        super.displayInfo();  // Call the displayInfo from User
        System.out.println("Major: " + major);
    }

	public char[] getDetails() {
		// TODO Auto-generated method stub
		return null;
	}
}

