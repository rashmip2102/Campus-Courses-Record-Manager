package edu.ccrm.service;

import edu.ccrm.domain.Courses;
import java.util.List;
public interface CourseService {
	void addCourse(Courses course);
    List<Courses> listCourses();
    Courses findCourseByCode(String code);
    void updateCourse(Courses course);
    void deactivateCourse(String code);
    List<Courses> filterCoursesByInstructor(String instructorName);
    List<Courses> filterCoursesByDepartment(String department);
    List<Courses> filterCoursesBySemester(String semester);
}
