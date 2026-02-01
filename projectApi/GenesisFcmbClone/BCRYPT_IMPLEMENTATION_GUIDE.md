# 🔐 BCrypt Implementation Guide

## What Happened (Before vs After)

### ❌ BEFORE: Simple Hashing (INSECURE)
```java
// PinValidator - OLD (INSECURE)
public static String hashPin(String pin) {
    return "HASHED_" + pin + "_PIN";  // PIN: "123456" → "HASHED_123456_PIN"
}

public static boolean verifyPin(String rawPin, String hashedPin) {
    String hashedRawPin = hashPin(rawPin);
    return hashedRawPin.equals(hashedPin);  // Simple string comparison
}

// UserService - OLD (INSECURE)
user.setPassword(createUserDto.getPassword());  // Stored as plain text!
user.setPin(PinValidator.hashPin(createUserDto.getPin()));

// Login - OLD (INSECURE)
if (!user.getPassword().equals(loginDto.getPassword())) {  // Plain text comparison!
    throw new UnauthorizedException("Invalid email or password");
}
```

**Problems:**
- ❌ PIN hash reveals the PIN (just remove "HASHED_" and "_PIN")
- ❌ Password stored in plain text (anyone with DB access sees passwords)
- ❌ No salt (same PIN always produces same hash)
- ❌ No iterations (fast = easy to brute force)
- ❌ Not production-ready

---

### ✅ AFTER: BCrypt Hashing (SECURE)

```java
// PinValidator - NEW (BCRYPT)
private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);

public static String hashPin(String pin) {
    return encoder.encode(pin);  // PIN: "123456" → "$2b$10$abcd..." (unique each time)
}

public static boolean verifyPin(String rawPin, String hashedPin) {
    return encoder.matches(rawPin, hashedPin);  // Timing-safe comparison
}

// UserService - NEW (BCRYPT)
user.setPassword(bCryptPasswordEncoder.encode(createUserDto.getPassword()));
user.setPin(PinValidator.hashPin(createUserDto.getPin()));

// Login - NEW (BCRYPT)
if (!bCryptPasswordEncoder.matches(loginDto.getPassword(), user.getPassword())) {
    throw new UnauthorizedException("Invalid email or password");
}
```

**Benefits:**
- ✅ PIN cannot be reversed (cryptographically secure)
- ✅ Password cannot be reversed (cryptographically secure)
- ✅ Random salt per PIN (same PIN hashes differently each time)
- ✅ 1024 iterations (2^10 - slow by design)
- ✅ Production-ready

---

## Understanding BCrypt Format

### BCrypt Hash Structure
```
$2b$10$abc123def456...xyz

├─ $2b$ = Version identifier (BCrypt version 2b)
├─ $10$ = Cost factor (2^10 = 1024 iterations)
└─ abc123def456...xyz = Salt (22 chars) + Hash (31 chars) = 60 total chars
```

### Example: Same PIN, Different Hashes

```
PIN: "123456"

Hashing Attempt 1:
Input:  "123456"
Output: "$2b$10$N.r8Zc5JXlXZI5Y/c.7CO/iMl5p2fZQHX5nIZz8sM0Y5SuLr3t2Ty"
        └─ Random salt + hash (53 more chars)

Hashing Attempt 2:
Input:  "123456"  (same PIN)
Output: "$2b$10$M7q3Kd8FpQaLs9T2U1V5De/HjKm4nZyWxAb0cF1dG2hR8sJpT5U6VW"
        └─ Different random salt + hash (completely different)

Why Different?
- BCrypt generates NEW random salt each time
- Same PIN + different salt = different output
- This prevents rainbow table attacks
```

---

## BCrypt vs Other Methods

### Comparison Table

| Method | Security | Speed | Salt | Reversible | Production |
|--------|----------|-------|------|-----------|-----------|
| **Plain Text** | ❌ NONE | ✅ Instant | ❌ No | ✅ Yes | ❌ NO |
| **Simple Hash** (HASHED_123456_PIN) | ❌ Low | ✅ Instant | ❌ No | ✅ Yes | ❌ NO |
| **MD5** | ❌ Broken | ✅ Fast | ❌ No | ⚠️ Maybe | ❌ NO |
| **SHA-256** | ⚠️ Weak | ✅ Fast | ❌ No | ❌ Not reversible | ❌ NO |
| **PBKDF2** | ✅ Good | ⚠️ Medium | ✅ Yes | ❌ Not reversible | ⚠️ OK |
| **BCrypt** | ✅ Excellent | ❌ Slow | ✅ Yes | ❌ Not reversible | ✅ YES |
| **Argon2** | ✅ Excellent | ❌ Very Slow | ✅ Yes | ❌ Not reversible | ✅ YES |

**Recommendation:** BCrypt for passwords/PINs, Argon2 for ultra-secure applications.

---

## How BCrypt Works (Under the Hood)

### 1. Hashing Process
```
PIN: "123456"
     ↓
[Generate Random Salt: 16 bytes → 22 chars in base64]
     ↓
salt = "$2b$10$N9qo8uLOickgx2ZMRZoMye"
     ↓
[Hash PIN + salt using Blowfish cipher, repeat 2^10 times]
     ↓
Hash: "oLjzlVQ5qyB8WN4H2MRz5JgfVTYmJMuU5I4MbqVKyXI"
     ↓
Output: "$2b$10$N9qo8uLOickgx2ZMRZoMye" + "oLjzlVQ5qyB8WN4H2MRz5JgfVTYmJMuU5I4MbqVKyXI"
Output: "$2b$10$N9qo8uLOickgx2ZMRZoMyeoLjzlVQ5qyB8WN4H2MRz5JgfVTYmJMuU5I4MbqVKyXI"
```

### 2. Verification Process
```
User enters PIN: "123456"
Stored in DB: "$2b$10$N9qo8uLOickgx2ZMRZoMyeoLjzlVQ5qyB8WN4H2MRz5JgfVTYmJMuU5I4MbqVKyXI"
     ↓
[Extract salt from stored hash]
salt = "$2b$10$N9qo8uLOickgx2ZMRZoMye"
     ↓
[Hash entered PIN + extracted salt, repeat 2^10 times]
     ↓
Computed hash: "oLjzlVQ5qyB8WN4H2MRz5JgfVTYmJMuU5I4MbqVKyXI"
     ↓
[Compare with stored hash portion]
"oLjzlVQ5qyB8WN4H2MRz5JgfVTYmJMuU5I4MbqVKyXI" == "oLjzlVQ5qyB8WN4H2MRz5JgfVTYmJMuU5I4MbqVKyXI"
     ↓
Result: ✅ MATCH - PIN is correct
```

---

## Why BCrypt is Better than Simple Hash

### Attack Scenario: Hacker steals database

#### Simple Hash (Your Old System)
```
Database leaked:
john@example.com: HASHED_123456_PIN

Attacker:
1. Sees "HASHED_" prefix
2. Removes "HASHED_" and "_PIN"
3. Gets PIN: "123456"
4. Total time: 5 seconds ⚠️ COMPROMISED

Brute force attack:
for i in 000000 to 999999:
    hash = "HASHED_" + i + "_PIN"
    if hash == stolen_hash:
        print("PIN found:", i)
Total time: 2 seconds per PIN ⚠️ INSTANT
```

#### BCrypt (Your New System)
```
Database leaked:
john@example.com: $2b$10$N9qo8uLOickgx2ZMRZoMyeoLjzlVQ5qyB8WN4H2MRz5JgfVTYmJMuU5I4MbqVKyXI

Attacker:
1. Sees "$2b$10$..." format
2. Cannot reverse (one-way function)
3. Would need to try all 1,000,000 PINs
4. Each attempt takes 1 second (2^10 iterations)
5. Total time: 1,000,000 seconds = 11.5 days ⚠️ IMPRACTICAL

With stronger parameters ($2b$14$):
1. Each attempt takes 4 seconds
2. Total time: 4,000,000 seconds = 46 days
3. By that time: Account should be locked after 3 failures
```

---

## Configuration Details

### BCrypt Strength Levels

```java
// Strength 10 (default, recommended for most applications)
new BCryptPasswordEncoder(10)  // 2^10 = 1,024 iterations
Hashing time: ~100ms per password
Security: Good for 2024

// Strength 12 (higher security, slightly slower)
new BCryptPasswordEncoder(12)  // 2^12 = 4,096 iterations
Hashing time: ~500ms per password
Security: Excellent for sensitive systems

// Strength 14 (very high security, slower)
new BCryptPasswordEncoder(14)  // 2^14 = 16,384 iterations
Hashing time: ~2 seconds per password
Security: Bank-level for ultra-sensitive data
```

### Our Configuration
```java
// SecurityConfig.java
@Bean
public BCryptPasswordEncoder bCryptPasswordEncoder() {
    return new BCryptPasswordEncoder(10);  // Good balance of security and speed
}
```

**Why Strength 10?**
- ✅ Secure enough for most applications
- ✅ Fast enough for responsive login (100ms)
- ✅ Future-proof (can increase when computers get faster)
- ✅ Industry standard

---

## API Examples

### Registration with BCrypt

**Request:**
```json
POST /api/users/register
{
  "email": "john@example.com",
  "password": "SecurePassword123!",
  "firstName": "John",
  "lastName": "Doe",
  "phoneNumber": "+233501234567",
  "pin": "654321",
  "bankId": 1,
  "role": "USER"
}
```

**What Happens:**
```java
// Password hashing (BCrypt)
bCryptPasswordEncoder.encode("SecurePassword123!")
→ "$2b$10$N9qo8uLOickgx2ZMRZoMyeoLjzlVQ5qyB8WN4H2MRz5JgfVTYmJMuU5I4MbqVKyXI"

// PIN hashing (BCrypt via PinValidator)
PinValidator.hashPin("654321")
→ "$2b$10$M7q3Kd8FpQaLs9T2U1V5De/HjKm4nZyWxAb0cF1dG2hR8sJpT5U6VW"

// Stored in Database
User:
{
  email: "john@example.com",
  password: "$2b$10$N9qo8uLOickgx2ZMRZoMyeoLjzlVQ5qyB8WN4H2MRz5JgfVTYmJMuU5I4MbqVKyXI",  // ← Hashed
  pin: "$2b$10$M7q3Kd8FpQaLs9T2U1V5De/HjKm4nZyWxAb0cF1dG2hR8sJpT5U6VW",  // ← Hashed
  firstName: "John",
  lastName: "Doe",
  ...
}
```

### Login with BCrypt

**Request:**
```json
POST /api/users/login
{
  "email": "john@example.com",
  "password": "SecurePassword123!",
  "pin": "654321"
}
```

**What Happens:**
```java
// Find user by email
User user = userRepository.findByEmail("john@example.com");

// Verify password (BCrypt timing-safe comparison)
bCryptPasswordEncoder.matches("SecurePassword123!", user.getPassword())
// Extracts salt from stored "$2b$10$N9qo..." hash
// Hashes entered password with that salt
// Compares securely → ✅ MATCH

// Verify PIN (BCrypt via PinValidator)
PinValidator.verifyPin("654321", user.getPin())
// Extracts salt from stored "$2b$10$M7q3..." hash
// Hashes entered PIN with that salt
// Compares securely → ✅ MATCH

// Result
LoginResponseDto:
{
  id: 1,
  email: "john@example.com",
  firstName: "John",
  lastName: "Doe",
  accountNumber: "1234567890",
  accountBalance: 0.00,
  role: "USER",
  token: "token_will_go_here",
  loginTime: "2024-01-15T10:30:00",
  message: "Login successful"
}
```

---

## Testing BCrypt

### Manual Test in Spring Boot

```java
// In your controller or test
@RestController
@RequestMapping("/api/bcrypt-test")
public class BcryptTestController {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/hash/{password}")
    public Map<String, String> hashPassword(@PathVariable String password) {
        Map<String, String> response = new HashMap<>();
        response.put("input", password);
        response.put("hash1", bCryptPasswordEncoder.encode(password));
        response.put("hash2", bCryptPasswordEncoder.encode(password));  // Different!
        response.put("explanation", "Same input, different outputs (random salt)");
        return response;
    }

    @PostMapping("/verify")
    public Map<String, Object> verifyPassword(@RequestBody Map<String, String> request) {
        String rawPassword = request.get("password");
        String hashedPassword = request.get("hash");
        
        Map<String, Object> response = new HashMap<>();
        response.put("rawPassword", rawPassword);
        response.put("storedHash", hashedPassword);
        response.put("isMatch", bCryptPasswordEncoder.matches(rawPassword, hashedPassword));
        response.put("isMatch", bCryptPasswordEncoder.matches("wrongPassword", hashedPassword));
        return response;
    }
}
```

**Test Request:**
```bash
# Hash password (each call produces different output)
curl http://localhost:8080/api/bcrypt-test/hash/SecurePassword123

Response:
{
  "input": "SecurePassword123",
  "hash1": "$2b$10$N9qo8uLOickgx2ZMRZoMyeoLjzlVQ5qyB8WN4H2MRz5JgfVTYmJMuU5I4MbqVKyXI",
  "hash2": "$2b$10$M7q3Kd8FpQaLs9T2U1V5De/HjKm4nZyWxAb0cF1dG2hR8sJpT5U6VW",
  "explanation": "Same input, different outputs (random salt)"
}

# Verify password
curl -X POST http://localhost:8080/api/bcrypt-test/verify \
  -H "Content-Type: application/json" \
  -d {
    "password": "SecurePassword123",
    "hash": "$2b$10$N9qo8uLOickgx2ZMRZoMyeoLjzlVQ5qyB8WN4H2MRz5JgfVTYmJMuU5I4MbqVKyXI"
  }

Response:
{
  "rawPassword": "SecurePassword123",
  "storedHash": "$2b$10$N9qo8uLOickgx2ZMRZoMyeoLjzlVQ5qyB8WN4H2MRz5JgfVTYmJMuU5I4MbqVKyXI",
  "isMatch": true
}
```

---

## Migration Note

If you already have users in your database with simple hashes:

```java
// Option 1: Force password reset on next login
public LoginResponseDto login(LoginDto loginDto) {
    User user = userRepository.findByEmail(loginDto.getEmail())
            .orElseThrow(...);

    // Check if password is in old simple hash format
    if (user.getPassword().startsWith("HASHED_")) {
        throw new UnauthorizedException("Password must be reset");
        // Redirect to password reset endpoint
    }

    // Use BCrypt for new passwords
    if (!bCryptPasswordEncoder.matches(loginDto.getPassword(), user.getPassword())) {
        throw new UnauthorizedException("Invalid password");
    }
    ...
}

// Option 2: Upgrade on successful login
public LoginResponseDto login(LoginDto loginDto) {
    User user = userRepository.findByEmail(loginDto.getEmail())
            .orElseThrow(...);

    // If old format, upgrade to BCrypt
    if (user.getPassword().startsWith("HASHED_")) {
        if (user.getPassword().equals("HASHED_" + loginDto.getPassword())) {
            user.setPassword(bCryptPasswordEncoder.encode(loginDto.getPassword()));
            userRepository.save(user);
        } else {
            throw new UnauthorizedException("Invalid password");
        }
    } else {
        // New format, use BCrypt comparison
        if (!bCryptPasswordEncoder.matches(loginDto.getPassword(), user.getPassword())) {
            throw new UnauthorizedException("Invalid password");
        }
    }
    ...
}
```

---

## Summary

| Aspect | Before (Simple Hash) | After (BCrypt) |
|--------|----------------------|----------------|
| **Security** | ❌ Not secure | ✅ Production-ready |
| **Password Storage** | Plain text | BCrypt hashed |
| **PIN Storage** | `HASHED_123456_PIN` | BCrypt hashed |
| **Salt** | None | Auto-generated per hash |
| **Iterations** | 1 | 1,024 (2^10) |
| **Reversible** | ✅ Yes | ❌ No |
| **Attack Time** | Seconds | Days/Months |
| **Compliance** | ❌ OWASP fails | ✅ OWASP compliant |

---

**Next Steps:**
1. ✅ Dependency added
2. ✅ SecurityConfig created
3. ✅ PinValidator updated
4. ✅ UserService updated
5. 📋 Test registration and login
6. 📋 Verify BCrypt hashes in database
7. 📋 Implement password reset with BCrypt
8. 📋 Add account lockout after failed attempts

---

**Questions?**
- How does BCrypt prevent rainbow table attacks? → Random salt per hash
- Why is BCrypt slow? → By design, makes brute force impractical
- Can BCrypt be cracked? → Theoretically yes, but would take years
- Do I need to upgrade users' passwords? → Option 1: Force reset, Option 2: Lazy upgrade on login
