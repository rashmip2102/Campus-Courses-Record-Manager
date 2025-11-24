package edu.ccrm.service;

import edu.ccrm.domain.Student;
import edu.ccrm.domain.Enrollment;
import java.util.List;

public interface TranscriptService {
    double computeGPA(List<Enrollment> enrollments);
    String generateTranscript(Student student, List<Enrollment> enrollments);
}
