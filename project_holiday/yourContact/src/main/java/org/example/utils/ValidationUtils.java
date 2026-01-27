package org.example.utils;

public class ValidationUtils {

    /**
     * Custom implementation to remove leading and trailing whitespace from a string.
     * This does the same thing as String.trim() but shows how it works under the hood.
     *
     * @param input the string to trim
     * @return the trimmed string, or null if input is null
     */
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
        return (start > 0 || end < input.length())
            ? input.substring(start, end)
            : input;
    }

    public static boolean isValidPin(int pin) {
        return pin >= 100000 && pin <= 999999;
    }

    public static boolean isValidEmail(String email) {
        if (email == null || trimWhitespace(email).isEmpty()) {
            return false;
        }
        // Simple email validation: contains @ and has text before and after it
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        return email.matches(emailRegex);
    }

    public static boolean isValidPhoneNumber(String phoneNumber) {
        if (phoneNumber == null || trimWhitespace(phoneNumber).isEmpty()) {
            return false;
        }
        // Remove common formatting characters
        String cleaned = phoneNumber.replaceAll("[\\s()-]", "");
        // Check if it contains only digits and has reasonable length (7-15 digits)
        return cleaned.matches("\\d{7,15}");
    }
}
