package com.example.demo.util;

import com.example.demo.exception.BadRequestException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Utility class for PIN validation and verification
 * 
 * Features:
 * - Validates PIN format (exactly 6 digits)
 * - Hashes PIN using BCrypt (industry-standard, secure)
 * - Verifies PINs against BCrypt hashes
 * 
 * Security Notes:
 * - Each PIN hash is unique due to random salt generation
 * - BCrypt is slow-by-design: 2^10 iterations (configurable)
 * - Brute force attacks are impractical due to time cost
 * - Rainbow tables are ineffective due to per-PIN salt
 */
public class PinValidator {
    
    // BCrypt encoder instance - strength 10 (2^10 = 1024 iterations)
    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);

    /**
     * Validate PIN format
     * Requirements: Exactly 6 digits, numeric only
     * 
     * Examples:
     * ✅ "123456" → Valid
     * ❌ "12345" → Invalid (5 digits)
     * ❌ "1234567" → Invalid (7 digits)
     * ❌ "12345a" → Invalid (contains letter)
     * ❌ "123 456" → Invalid (contains space)
     */
    public static void validatePinFormat(String pin) {
        if (pin == null || pin.isBlank()) {
            throw new BadRequestException("PIN is required");
        }

        // Check if exactly 6 characters
        if (pin.length() != 6) {
            throw new BadRequestException("PIN must be exactly 6 digits");
        }

        // Check if all characters are digits
        if (!pin.matches("\\d{6}")) {
            throw new BadRequestException("PIN must contain only numbers (0-9)");
        }
    }

    /**
     * Hash PIN for storage using BCrypt
     * 
     * Process:
     * 1. Generates random salt
     * 2. Hashes PIN with salt and 10 iterations (2^10 = 1024 rounds)
     * 3. Returns BCrypt format: $2b$10$salt+hash
     * 
     * Example:
     * Input PIN: "123456"
     * Output: "$2b$10$abcdefghijklmnopqrstuvwxyz..." (60 chars, always unique)
     * 
     * Why BCrypt is better than simple hashing:
     * - Simple hash: Same input always produces same output (vulnerable)
     * - BCrypt: Random salt ensures different output each time
     * - Rainbow tables: Impossible because each PIN has unique salt
     * - Brute force: Intentionally slow (1024 iterations minimum)
     * 
     * @param pin The raw PIN to hash (must be validated first)
     * @return BCrypt hash ready for storage
     */
    public static String hashPin(String pin) {
        return encoder.encode(pin);
    }

    /**
     * Verify PIN matches stored BCrypt hash
     * 
     * Process:
     * 1. Takes the raw PIN user entered
     * 2. Takes the stored BCrypt hash from database
     * 3. Extracts salt from stored hash
     * 4. Hashes raw PIN with extracted salt
     * 5. Compares with stored hash (timing-safe comparison)
     * 
     * Example:
     * Stored hash: "$2b$10$abcdef...xyz" (from registration)
     * User enters:  "123456"
     * BCrypt extracts salt: "abcdef..."
     * BCrypt hashes user input with that salt
     * If result matches stored hash → PIN is correct
     * 
     * Why timing-safe comparison:
     * - Prevents timing attacks (hackers measuring response time)
     * - Always takes same time regardless of match result
     * 
     * @param rawPin The PIN entered by user (not yet hashed)
     * @param hashedPin The BCrypt hash from database storage
     * @return true if PIN matches, false otherwise
     */
    public static boolean verifyPin(String rawPin, String hashedPin) {
        return encoder.matches(rawPin, hashedPin);
    }

    /**
     * Check if PIN is compromised (dummy implementation)
     * In production, check against breach databases
     */
    public static void checkCompromisedPin(String pin) {
        // Common PIN patterns to avoid
        String[] commonPins = {
            "000000", // All zeros
            "111111", // All ones
            "123456", // Sequential
            "654321", // Reverse sequential
            "111111", // Repeated
            "000000"  // All same
        };

        for (String commonPin : commonPins) {
            if (pin.equals(commonPin)) {
                throw new BadRequestException("PIN is too common. Please choose a different PIN");
            }
        }
    }
}
