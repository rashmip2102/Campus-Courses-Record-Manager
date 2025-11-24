package edu.ccrm.service;

import edu.ccrm.domain.Student;
import edu.ccrm.domain.Enrollment;
import edu.ccrm.domain.Courses;
import java.util.List;

public class TranscriptServiceImpl implements TranscriptService {

    @Override
    public double computeGPA(List<Enrollment> enrollments) {
        int totalCredits = 0;
        double weightedSum = 0;
        for (Enrollment enrollment : enrollments) {
            Courses course = enrollment.getCourse();
            int credits = course.getCredits();
            double gradePoint = enrollment.getGrade().ordinal(); // Map S=0, A=1, etc., or provide a .getPoint() method
            weightedSum += credits * gradePoint;
            totalCredits += credits;
        }
        return totalCredits > 0 ? weightedSum / totalCredits : 0;
    }

    @Override
    public String generateTranscript(Student student, List<Enrollment> enrollments) {
        StringBuilder sb = new StringBuilder();
        sb.append("Transcript for ").append(student.getName().getFullName()).append("\n");
        for (Enrollment enrollment : enrollments) {
            sb.append(enrollment.toString()).append("\n");
        }
        sb.append("GPA: ").append(computeGPA(enrollments));
        return sb.toString();
    }
}
