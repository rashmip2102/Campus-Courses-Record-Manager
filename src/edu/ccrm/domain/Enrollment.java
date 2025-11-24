package edu.ccrm.domain;
public class Enrollment {
	private Student student;
    private Courses course;
    private double marks;
    private Grade grade;

    public Enrollment(Student student, Courses course) {
        this.student = student;
        this.course = course;
        this.marks = 0.0;
        this.grade = Grade.F;
    }
    public Student getStudent() { return student; }
    public Courses getCourse() { return course; }
    public double getMarks() { return marks; }
    public Grade getGrade() { return grade; }

    public void setMarks(double marks) {
        this.marks = marks;
        this.grade = calculateGrade(marks);
    }
    private Grade calculateGrade(double marks) {
        if (marks >= 90) return Grade.S;
        else if (marks >= 80) return Grade.A;
        else if (marks >= 70) return Grade.B;
        else if (marks >= 60) return Grade.C;
        else if (marks >= 50) return Grade.D;
        else if (marks >= 40) return Grade.E;
        else return Grade.F;
    }
    @Override
    public String toString() {
        return String.format("Enrollment[student=%s, course=%s, marks=%.2f, grade=%s]",
                student.getName(), course.getCode(), marks, grade);
    }
}
