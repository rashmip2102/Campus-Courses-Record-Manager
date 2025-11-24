package edu.ccrm.service;

import edu.ccrm.domain.Enrollment;
import edu.ccrm.domain.Student;
import edu.ccrm.domain.Courses;
import java.util.List;

public interface EnrollmentService {
    void enrollStudent(Student student, Courses course);
    void unenrollStudent(Student student, Courses course);
    List<Enrollment> listEnrollments();
    Enrollment findEnrollment(Student student, Courses course);
    void recordMarks(Enrollment enrollment, double marks);
}
