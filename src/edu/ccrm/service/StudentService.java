package edu.ccrm.service;
import edu.ccrm.domain.Student;
import java.util.*;

public interface StudentService {
    void addStudent(Student student);
    List<Student> listStudents();
    Student findStudentByRegNo(String regNo);
    void updateStudent(Student student);
    void deactivateStudent(String regNo);
}
