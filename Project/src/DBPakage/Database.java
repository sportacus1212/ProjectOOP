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






public class Database {
    // List of users (could be Students, Teachers, Admins, etc.)
    List<User> users = new List<>();
    List<Student> students = new List<>();
    List<Admin> admins = new List<>();
    List<Manager> managers = new List<>();
    List<Teacher> teachers = new List<>();
    List<Course> courses = new List<>();


}
