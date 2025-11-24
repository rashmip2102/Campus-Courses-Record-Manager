package edu.ccrm.service;

import edu.ccrm.domain.Courses;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CourseServiceImpl implements CourseService {
    private List<Courses> courses = new ArrayList<>();

    @Override
    public void addCourse(Courses course) {
        courses.add(course);
    }

    @Override
    public List<Courses> listCourses() {
        return new ArrayList<>(courses);
    }

    @Override
    public Courses findCourseByCode(String code) {
        for (Courses course : courses) {
            if (course.getCode().equals(code)) {
                return course;
            }
        }
        return null;
    }

    @Override
    public void updateCourse(Courses updated) {
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getCode().equals(updated.getCode())) {
                courses.set(i, updated);
                return;
            }
        }
    }

    @Override
    public void deactivateCourse(String code) {
        findCourseByCode(code);
    }

    @Override
    public List<Courses> filterCoursesByInstructor(String instructorName) {
        return courses.stream()
            .filter(c -> c.getInstructor() != null &&
                         c.getInstructor().getName().getFullName().equalsIgnoreCase(instructorName))
            .collect(Collectors.toList());
    }

    @Override
    public List<Courses> filterCoursesByDepartment(String department) {
        return courses.stream()
            .filter(c -> c.getDepartment().equalsIgnoreCase(department))
            .collect(Collectors.toList());
    }

    @Override
    public List<Courses> filterCoursesBySemester(String semester) {
        return courses.stream()
            .filter(c -> c.getSemester().name().equalsIgnoreCase(semester))
            .collect(Collectors.toList());
    }
}
