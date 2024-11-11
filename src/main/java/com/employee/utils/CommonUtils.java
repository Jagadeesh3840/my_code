package com.employee.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommonUtils {

    private static final String EMAIL_PATTERN =
            "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";

    public static boolean isValidEmail(String email) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("Please provide valid email");
        }
        return true;
    }

    public static double calculateTax(double salary) {
        double tax = 0.0;

        if (salary > 250000 && salary <= 500000) {
            tax += (salary - 250000) * 0.05;
        } else if (salary > 500000 && salary <= 1000000) {
            tax += (250000 * 0.05);
            tax += (salary - 500000) * 0.10;
        } else if (salary > 1000000) {
            tax += (250000 * 0.05);
            tax += (500000 * 0.10);
            tax += (salary - 1000000) * 0.20;
        }
        return tax;
    }


    public static double calculateCess(double salary) {
        double cess = 0.0;
        if (salary > 2500000) {
            double excessAmount = salary - 2500000;
            cess = excessAmount * 0.02;
        }
        return cess;
    }
}
