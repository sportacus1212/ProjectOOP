package DBPakage;


import java.util.List;
import java.util.ArrayList;
import models.Admin;
import models.Course;
import models.Employee;
import models.FinanceManager;
import models.Manager;
import models.Teacher;
import models.Student;
import models.StudentsFinanceManager;
import models.User;
import enums.SubjectsSITE;
import enums.SubjectsBS;
import enums.SubjectsSNS;
import enums.SubjectsISE;
import enums.SubjectsSAM;
import enums.SubjectsSEPI;
import enums.SubjectsSG;
import enums.SubjectsSCE;
import enums.SubjectsKMA;
import enums.SubjectsSMGT;

public class Database {
    // Lists to hold the different types of users
    private List<User> users = new ArrayList<>();
    private List<Student> students = new ArrayList<>();
    private List<Admin> admins = new ArrayList<>();
    private List<Manager> managers = new ArrayList<>();
    private List<Teacher> teachers = new ArrayList<>();
    private List<Course> courses = new ArrayList<>();

    // Lists to hold subjects for different departments
    private List<SubjectsSITE> subjectsSITE = new ArrayList<>();
    private List<SubjectsBS> subjectsBS = new ArrayList<>();
    private List<SubjectsSNS> subjectsSNS = new ArrayList<>();
    private List<SubjectsISE> subjectsISE = new ArrayList<>();
    private List<SubjectsSAM> subjectsSAM = new ArrayList<>();
    private List<SubjectsSEPI> subjectsSEPI = new ArrayList<>();
    private List<SubjectsSG> subjectsSG = new ArrayList<>();
    private List<SubjectsSCE> subjectsSCE = new ArrayList<>();
    private List<SubjectsKMA> subjectsKMA = new ArrayList<>();
    private List<SubjectsSMGT> subjectsSMGT = new ArrayList<>();
    
    
    // Getters for the lists
    
    
    public List<User> getUsers() {
        return users;
    }

    public List<Student> getStudents() {
        return students;
    }

    public List<Admin> getAdmins() {
        return admins;
    }

    public List<Manager> getManagers() {
        return managers;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public List<Course> getCourses() {
        return courses;
    }
    // Getters for the subject lists
    public List<SubjectsSITE> getSubjectsSITE() {
        return subjectsSITE;
    }

    public List<SubjectsBS> getSubjectsBS() {
        return subjectsBS;
    }

    public List<SubjectsSNS> getSubjectsSNS() {
        return subjectsSNS;
    }

    public List<SubjectsISE> getSubjectsISE() {
        return subjectsISE;
    }

    public List<SubjectsSAM> getSubjectsSAM() {
        return subjectsSAM;
    }

    public List<SubjectsSEPI> getSubjectsSEPI() {
        return subjectsSEPI;
    }

    public List<SubjectsSG> getSubjectsSG() {
        return subjectsSG;
    }

    public List<SubjectsSCE> getSubjectsSCE() {
        return subjectsSCE;
    }

    public List<SubjectsKMA> getSubjectsKMA() {
        return subjectsKMA;
    }

    public List<SubjectsSMGT> getSubjectsSMGT() {
        return subjectsSMGT;
    }
}

