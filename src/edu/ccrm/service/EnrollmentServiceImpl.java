package edu.ccrm.service;

import edu.ccrm.domain.Enrollment;
import edu.ccrm.domain.Student;
import edu.ccrm.domain.Courses;
import java.util.ArrayList;
import java.util.List;

public class EnrollmentServiceImpl implements EnrollmentService {
    private List<Enrollment> enrollments = new ArrayList<>();

    @Override
    public void enrollStudent(Student student, Courses course) {
        Enrollment enrollment = new Enrollment(student, course);
        enrollments.add(enrollment);
    }

    @Override
    public void unenrollStudent(Student student, Courses course) {
        enrollments.removeIf(e -> e.getStudent().equals(student) && e.getCourse().equals(course));
    }

    @Override
    public List<Enrollment> listEnrollments() {
        return enrollments;
    }

    @Override
    public Enrollment findEnrollment(Student student, Courses course) {
        for (Enrollment enrollment : enrollments) {
            if (enrollment.getStudent().equals(student) &&
                enrollment.getCourse().equals(course)) {
                return enrollment;
            }
        }
        return null;
    }

    @Override
    public void recordMarks(Enrollment enrollment, double marks) {
        enrollment.setMarks(marks);
    }
}
