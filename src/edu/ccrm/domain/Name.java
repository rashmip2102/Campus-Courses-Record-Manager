package edu.ccrm.domain;
import java.util.Objects;
public final class Name {
    private final String firstName;
    private final String middleName;
    private final String lastName;
    public Name(String firstName, String middleName, String lastName) {
        this.firstName = firstName != null ? firstName.trim() : "";
        this.middleName = middleName != null ? middleName.trim() : "";
        this.lastName = lastName != null ? lastName.trim() : "";
    }
    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getFullName() {
        StringBuilder fullName = new StringBuilder(firstName);
        if (!middleName.isEmpty()) {
            fullName.append(" ").append(middleName);
        }
        if (!lastName.isEmpty()) {
            fullName.append(" ").append(lastName);
        }
        return fullName.toString();
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Name)) return false;
        Name name = (Name) o;
        return firstName.equals(name.firstName)
                && middleName.equals(name.middleName)
                && lastName.equals(name.lastName);
    }
    @Override
    public int hashCode() {
        return Objects.hash(firstName, middleName, lastName);
    }
    @Override
    public String toString() {
        return getFullName();
    }
}
