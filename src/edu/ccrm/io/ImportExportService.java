package edu.ccrm.io;

import edu.ccrm.domain.Courses;
import edu.ccrm.domain.Enrollment;
import edu.ccrm.domain.Student;

import java.util.List;

public interface ImportExportService {
    List<Student> importStudents(String filePath) throws Exception;
    List<Courses> importCourses(String filePath) throws Exception;
    List<Enrollment> importEnrollments(String filePath, List<Student> students, List<Courses> courses) throws Exception;

    void exportStudents(List<Student> students, String filePath) throws Exception;
    void exportCourses(List<Courses> courses, String filePath) throws Exception;
    void exportEnrollments(List<Enrollment> enrollments, String filePath) throws Exception;
	List<Enrollment> importEnrollments(String filePath);
}
