package com.example.demo.util;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBKDFKeySpec;
import java.security.SecureRandom;
import java.util.Base64;

/**
 * Manual PBKDF2 Password Hashing (If you must do it manually)
 * 
 * ⚠️ WARNING: Using this instead of BCrypt is NOT RECOMMENDED
 * 
 * This is ONLY more solid than simple encryption because:
 * - Uses PBKDF2 (NIST approved)
 * - Uses 600,000 iterations (slows down attackers)
 * - Uses random salt (prevents rainbow tables)
 * - Uses timing-safe comparison
 * 
 * BUT: BCrypt/Argon2 are still better because:
 * - BCrypt has been battle-tested for 25+ years
 * - Argon2 won password hashing competition (2015)
 * - Less room for implementation errors
 * - Built-in security best practices
 * 
 * IF YOUR TEAM INSISTS:
 * - Use this ONLY for legacy systems that can't use Spring Security
 * - Test thoroughly
 * - Have security review
 * - Consider migrating to BCrypt later
 */
public class ManualSecurePasswordHashing {

    private static final int ITERATIONS = 600000;  // NIST recommended minimum
    private static final int SALT_LENGTH = 32;     // 256 bits
    private static final int KEY_LENGTH = 256;     // 256 bits output
    private static final String ALGORITHM = "PBKDF2WithHmacSHA256";

    /**
     * Hash password with random salt using PBKDF2
     * 
     * Process:
     * 1. Generate random salt (32 bytes)
     * 2. Apply PBKDF2 with 600,000 iterations
     * 3. Return: base64(salt) + ":" + base64(hash)
     * 
     * Example:
     * hashPassword("SecurePass123")
     * → "abc123...XYZ:def456...UVW"
     *    └─ Salt    └─ Hash
     * 
     * @param password Raw password from user
     * @return Salted hash ready for storage
     */
    public static String hashPassword(String password) {
        try {
            // Generate random salt (32 bytes = 256 bits)
            byte[] salt = new byte[SALT_LENGTH];
            new SecureRandom().nextBytes(salt);

            // Apply PBKDF2
            PBKDFKeySpec spec = new PBKDFKeySpec(
                    password.toCharArray(),
                    salt,
                    ITERATIONS,
                    KEY_LENGTH * 8  // Convert to bits
            );

            SecretKeyFactory factory = SecretKeyFactory.getInstance(ALGORITHM);
            byte[] hash = factory.generateSecret(spec).getEncoded();

            // Return: salt:hash (both base64 encoded)
            String encodedSalt = Base64.getEncoder().encodeToString(salt);
            String encodedHash = Base64.getEncoder().encodeToString(hash);

            return encodedSalt + ":" + encodedHash;

        } catch (Exception e) {
            throw new RuntimeException("Error hashing password", e);
        }
    }

    /**
     * Verify password against stored hash using PBKDF2
     * 
     * Process:
     * 1. Extract salt from stored hash
     * 2. Hash raw password with SAME salt and 600,000 iterations
     * 3. Compare using timing-safe comparison
     * 
     * Example:
     * storedHash: "abc123...XYZ:def456...UVW"
     * rawPassword: "SecurePass123"
     * 
     * → Extract salt "abc123...XYZ"
     * → Hash "SecurePass123" with that salt
     * → Compare result with "def456...UVW"
     * → Return true if match
     * 
     * @param rawPassword Password entered by user
     * @param storedHash Hash from database (salt:hash format)
     * @return true if password matches, false otherwise
     */
    public static boolean verifyPassword(String rawPassword, String storedHash) {
        try {
            // Parse stored hash
            String[] parts = storedHash.split(":");
            if (parts.length != 2) {
                return false;  // Invalid format
            }

            byte[] salt = Base64.getDecoder().decode(parts[0]);
            byte[] storedHashBytes = Base64.getDecoder().decode(parts[1]);

            // Hash raw password with SAME salt
            PBKDFKeySpec spec = new PBKDFKeySpec(
                    rawPassword.toCharArray(),
                    salt,
                    ITERATIONS,
                    KEY_LENGTH * 8
            );

            SecretKeyFactory factory = SecretKeyFactory.getInstance(ALGORITHM);
            byte[] computedHash = factory.generateSecret(spec).getEncoded();

            // Timing-safe comparison (prevents timing attacks)
            return constantTimeEquals(storedHashBytes, computedHash);

        } catch (Exception e) {
            return false;  // Any error = mismatch
        }
    }

    /**
     * Timing-safe byte array comparison
     * 
     * Why needed?
     * - Simple equals() exits early on first mismatch
     * - Attacker can measure response time
     * - "Wrong first byte" responds faster than "wrong last byte"
     * - Attacker learns password one byte at a time
     * 
     * Timing-safe comparison:
     * - Always compares ALL bytes
     * - Takes same time regardless of position of mismatch
     * - Prevents timing attacks
     * 
     * @param a First array
     * @param b Second array
     * @return true if equal, false otherwise
     */
    private static boolean constantTimeEquals(byte[] a, byte[] b) {
        if (a == null || b == null) {
            return a == b;  // Both null = true, one null = false
        }

        if (a.length != b.length) {
            return false;
        }

        int result = 0;
        for (int i = 0; i < a.length; i++) {
            result |= a[i] ^ b[i];  // XOR with all bytes, even if mismatch found
        }

        return result == 0;  // Only true if no differences
    }
}
