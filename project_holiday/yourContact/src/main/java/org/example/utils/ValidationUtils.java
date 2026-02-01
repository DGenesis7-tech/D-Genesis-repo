package org.example.utils;

public class ValidationUtils {

    public static String trimWhitespace(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }

        int start = 0;
        int end = input.length();

        // Skip leading whitespace (space, tab, newline, etc.)
        // Characters <= ' ' (Unicode 32) are considered whitespace
        while (start < end && input.charAt(start) <= ' ') {
            start++;
        }

        // Skip trailing whitespace
        while (start < end && input.charAt(end - 1) <= ' ') {
            end--;
        }

        // Return substring without leading/trailing whitespace
        // If no whitespace was found, return original string
        if (start > 0 || end < input.length()) {
            return input.substring(start, end);
        } else {
            return input;
        }
    }

    public static boolean isValidPin(int pin) {
        if (pin >= 100000 && pin <= 999999) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isValidEmail(String email) {
        if (email == null || trimWhitespace(email).isEmpty()) {
            return false;
        }
        // Simple email validation: contains @ and has text before and after it
        int atPosition = -1;
        int dotPosition = -1;

        // Find @ symbol
        for (int index = 0; index < email.length(); index++) {
            if (email.charAt(index) == '@') {
                if (atPosition != -1) {
                    return false; // Multiple @ symbols
                }
                atPosition = index;
            }
        }

        // Check if @ exists and has text before it
        if (atPosition <= 0) {
            return false;
        }

        // Find last dot after @
        for (int index = atPosition + 1; index < email.length(); index++) {
            if (email.charAt(index) == '.') {
                dotPosition = index;
            }
        }

        // Check if dot exists after @ and has at least 2 characters after it
        if (dotPosition <= atPosition + 1 || dotPosition >= email.length() - 2) {
            return false;
        }

        return true;
    }

    public static boolean isValidPhoneNumber(String phoneNumber) {
        if (phoneNumber == null || trimWhitespace(phoneNumber).isEmpty()) {
            return false;
        }

        // Remove common formatting characters manually
        String cleanedNumber = "";
        for (int index = 0; index < phoneNumber.length(); index++) {
            char currentChar = phoneNumber.charAt(index);
            if (currentChar != ' ' && currentChar != '(' && currentChar != ')' && currentChar != '-') {
                cleanedNumber = cleanedNumber + currentChar;
            }
        }

        // Check if it contains only digits and has reasonable length (7-15 digits)
        int digitCount = 0;
        for (int index = 0; index < cleanedNumber.length(); index++) {
            char currentChar = cleanedNumber.charAt(index);
            if (currentChar >= '0' && currentChar <= '9') {
                digitCount++;
            } else {
                return false; // Non-digit character found
            }
        }

        // Check if digit count is within valid range
        if (digitCount >= 7 && digitCount <= 15) {
            return true;
        } else {
            return false;
        }
    }
}
