package edu.ccrm.domain;
import java.time.LocalDate;
public abstract class Person {
	protected String id;
    protected Name name;
    protected String email;
    protected LocalDate dateOfBirth;
    public Person(String id, Name name, String email, LocalDate dateOfBirth) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
    }
    public void setName(Name name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void setDateOfBirth(LocalDate dateOfBirth) { this.dateOfBirth = dateOfBirth; }
    public abstract String profile();
    
    public String getId() { return id; }
    public Name getName() { return name; }
    public String getEmail() { return email; }
    public LocalDate getDateOfBirth() { return dateOfBirth; }
}
