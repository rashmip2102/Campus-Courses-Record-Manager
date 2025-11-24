package edu.ccrm.domain;
import java.time.LocalDate;
import java.util.List;
public class Student extends Person{
	private String regNo;
    private boolean active;
    private List<String> enrolledCourses;
    private LocalDate enrollmentDate;
    public Student(String id, String regNo, Name name, String email, LocalDate dateOfBirth, LocalDate enrollmentDate, List<String> enrolledCourses) {
        super(id, name, email, dateOfBirth);
        this.regNo = regNo;
        this.active = true;
        this.enrolledCourses = enrolledCourses;
        this.enrollmentDate = enrollmentDate;
    }
    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
    public List<String> getEnrolledCourses() { return enrolledCourses; }
    public void setEnrolledCourses(List<String> enrolledCourses) { this.enrolledCourses = enrolledCourses; }
    public LocalDate getEnrollmentDate() { return enrollmentDate; }
    public void setEnrollmentDate(LocalDate enrollmentDate) { this.enrollmentDate = enrollmentDate; }
    public String getRegNo() {
    	return regNo;
    }
    @Override
    public String profile() {
        return String.format("Student: %s (%s)", name, regNo);
    }
}
