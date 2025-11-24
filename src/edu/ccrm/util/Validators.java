package edu.ccrm.util;

public class Validators {
    public static boolean isValidEmail(String email) {
        return email != null && email.matches("^[\\w.-]+@[\\w.-]+\\.\\w+$");
    }

    public static boolean isValidRegNo(String regNo) {
        return regNo != null && regNo.matches("^\\d{4,10}$");
    }
}
