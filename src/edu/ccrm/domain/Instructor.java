package edu.ccrm.domain;
import java.time.LocalDate;
public class Instructor extends Person{
	private String department;

    public Instructor(String id, Name Name, String email, LocalDate dateOfBirth, String department) {
        super(id, Name, email, dateOfBirth);
        this.department = department;
    }
    @Override
    public String profile() {
        return String.format("Instructor: %s (%s)", name, department);
    }
}
