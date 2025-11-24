package edu.ccrm.util;

import edu.ccrm.domain.Student;
import java.util.Comparator;

public class Comparators {
    public static Comparator<Student> byRegNo = (s1, s2) -> s1.getRegNo().compareTo(s2.getRegNo());

    public static Comparator<Student> byName = (s1, s2) -> s1.getName().getFullName().compareToIgnoreCase(s2.getName().getFullName());
}
