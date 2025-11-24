package edu.ccrm.service;

import edu.ccrm.domain.Student;
import java.util.ArrayList;
import java.util.List;

public class StudentServiceImpl implements StudentService {
    private List<Student> students = new ArrayList<>();
    @Override
    public void addStudent(Student student) {
        students.add(student);
    }
    @Override
    public List<Student> listStudents() {
        return students;
    }
    @Override
    public Student findStudentByRegNo(String regNo) {
        for (Student student : students) {
            if (student.getRegNo().equals(regNo)) {
                return student;
            }
        }
        return null;
    }
    @Override
    public void updateStudent(Student student) {
        // Update logic as needed
    }
    @Override
    public void deactivateStudent(String regNo) {
        Student student = findStudentByRegNo(regNo);
        if (student != null) {
            student.setActive(false);
        }
    }
}
