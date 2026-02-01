# Copilot Instructions for FCMB Bank API

## Project Overview
This is a **Spring Boot 4.0.2 banking application** running on **Java 25**. It implements a CRUD-based REST API for banking operations with **role-based access control** supporting a **single bank with multiple users**.

- **Build Tool**: Maven (via `mvnw` / `mvnw.cmd`)
- **Database**: MySQL (via MySQL Workbench)
- **Main Application Class**: `com.example.demo.FcmbDemoApplication`
- **Architecture Pattern**: CRUD with layered structure using DTOs and role-based authorization
- **Package Structure**: `com.example.demo.*`
- **Core Features**: Bank Management, User Registration (with 6-digit PIN), Bank Transfers, Airtime Purchase
- **Authentication**: Role-based (ADMIN, USER) + 6-digit PIN for secure login

## Key Build & Development Commands
```bash
# Build the project
./mvnw clean package

# Run the application locally
./mvnw spring-boot:run

# Run tests
./mvnw test

# Clean build artifacts
./mvnw clean
```
> Note: On Windows, use `mvnw.cmd` instead of `mvnw`

## Database Configuration (MySQL)
**Connection Details** (in `application.properties`):
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/fcmb_bank_db
spring.datasource.username=root
spring.datasource.password=
```

**Setup Instructions**:
1. Create database in MySQL Workbench: `CREATE DATABASE fcmb_bank_db;`
2. Update `application.properties` with your MySQL credentials if needed
3. Hibernates auto-creates tables on startup (`ddl-auto=update`)

## CRUD Architecture Layers

### DTO Layer (Data Transfer Objects)
- Location: `src/main/java/com/example/demo/dto/`
- Purpose: Decouple API contracts from internal domain models; handle all request and response payloads
- **Request DTOs** (for POST/PUT):
  - Naming: `Create{Entity}Dto.java`, `Update{Entity}Dto.java`
  - Contains: Fields accepted from client (no ID, no timestamps)
  - Used in: Controller method parameters for POST/PUT operations
- **Response DTOs** (for GET/POST/PUT returns):
  - Naming: `{Entity}Dto.java` or `{Entity}ResponseDto.java`
  - Contains: Fields returned to client (ID, timestamps, computed fields)
  - Used in: Controller method return types for all operations

### Controller Layer
- Location: `src/main/java/com/example/demo/controller/`
- Purpose: Handle HTTP requests/responses using DTOs, not models
- Pattern: `@RestController` with `@RequestMapping` endpoints accepting/returning DTOs
- Naming: `{Entity}Controller.java` (e.g., `UserController`, `TransferController`, `AirtimePurchaseController`)
- Data flow: Request DTO → Service (converts to Model) → Repository → Service (converts to Response DTO) → Controller

### Service Layer
- Location: `src/main/java/com/example/demo/service/`
- Purpose: Business logic and transaction management
- Pattern: `@Service` with `@Transactional` methods
- Naming: `{Entity}Service.java` interface + `{Entity}ServiceImpl.java` implementation
- Responsibility: Convert DTOs ↔ Models, validate input, execute business logic

### Repository Layer
- Location: `src/main/java/com/example/demo/repository/`
- Purpose: Data access and persistence (works exclusively with Models)
- Pattern: Extend `JpaRepository<Model, ID>`
- Naming: `{Entity}Repository.java` interface

### Model/Entity Layer
- Location: `src/main/java/com/example/demo/model/`
- Purpose: Define domain objects with JPA annotations
- Pattern: `@Entity` classes with `@Id` primary keys and `@PrePersist`, `@PreUpdate` lifecycle hooks
- Naming: `{Entity}.java` (e.g., `User.java`, `Transfer.java`, `AirtimePurchase.java`)

## Project Structure
```
src/main/java/com/example/demo/
  ├── controller/              → REST endpoints (GET, POST, PUT, DELETE)
  ├── dto/                     → Data Transfer Objects (request/response models)
  ├── service/                 → Business logic layer (with role-based checks)
  ├── repository/              → Data access layer
  ├── model/                   → JPA models (Bank, User, Transfer, AirtimePurchase, UserRole)
  ├── exception/               → Custom exceptions (ResourceNotFoundException, UnauthorizedException, BadRequestException)
  ├── util/                    → Global error handler and utilities
  └── FcmbDemoApplication.java → Application entry point

src/main/resources/
  └── application.properties   → Configuration (MySQL connection, JPA settings)

src/test/java/com/example/demo/
  ├── controller/              → Controller tests
  ├── service/                 → Service tests
  └── FcmbDemoApplicationTests.java
```

## Critical Dependencies
- **spring-boot-starter-web**: REST API support
- **spring-boot-starter-data-jpa**: JPA/Hibernate ORM for database operations
- **mysql-connector-j**: MySQL database driver
- **lombok**: Code generation for getters/setters (reduces boilerplate)
- **spring-boot-devtools**: Auto-reload during development
- **spring-boot-starter-test**: Testing framework (JUnit, Mockito, AssertJ)

## Core Entities & Models
1. **Bank** (`model/Bank.java`):
   - Fields: name, code (unique), adminEmail
   - Auto-manages: createdAt, updatedAt timestamps
   - One bank serves multiple users

2. **User** (`model/User.java`):
   - Fields: bank (FK to Bank), email, firstName, lastName, phoneNumber, password, accountNumber, accountBalance, **role**, **pin**
   - Role enum: ADMIN (can see all users), USER (can only see own data)
   - PIN field: Hashed 6-digit PIN for secure login (stored hashed, verified during login)
   - Auto-manages: createdAt, updatedAt timestamps

3. **UserRole** (`model/UserRole.java`):
   - **ADMIN**: Can view all users in bank, view all transactions
   - **USER**: Can only view own profile, make transfers, buy airtime

4. **Transfer** (`model/Transfer.java`):
   - Fields: sender (FK to User), recipientAccountNumber, amount, description, status
   - Status enum: PENDING, COMPLETED, FAILED, CANCELLED
   - Auto-manages: createdAt, updatedAt timestamps

5. **AirtimePurchase** (`model/AirtimePurchase.java`):
   - Fields: user (FK to User), phoneNumber, amount, provider, status
   - Provider enum: MTN, VODAFONE, AIRTEL, TIGO
   - Status enum: PENDING, COMPLETED, FAILED, CANCELLED

## Developer Patterns for CRUD Operations
1. **Controller**: Accept/return DTOs, never expose models directly in API contracts
2. **Service layer**: Convert incoming DTOs to models, perform business logic, convert models to response DTOs
3. **Repository methods**: Use Spring Data JPA derived queries or custom `@Query` for operations
4. **DTO Conversion**: Map DTOs ↔ Models in Service layer to maintain separation
5. **Controller methods** (with Request/Response DTOs):
   - `GET /{entity}` → Service finds all → converts `List<Model>` to `List<Dto>` → return `List<Dto>`
   - `GET /{entity}/{id}` → Service finds by ID → converts `Model` to `Dto` → return `Dto`
   - `POST /{entity}` → receive `Create{Entity}Dto` → Service converts to `Model`, saves → converts saved `Model` to `Dto` → return `Dto` with 201 status
   - `PUT /{entity}/{id}` → receive `Update{Entity}Dto` → Service converts to `Model`, updates → converts `Model` to `Dto` → return `Dto`
   - `DELETE /{entity}/{id}` → Service calls delete → return 204 No Content

## Error Handling & Exceptions
- **GlobalExceptionHandler** (`util/GlobalExceptionHandler.java`): Centralized exception handling
  - `ResourceNotFoundException`: Resource not found (404)
  - `UnauthorizedException`: User doesn't have permission (403)
  - `BadRequestException`: Invalid input (400)
  - `MethodArgumentNotValidException`: Validation failure (400)

- All exceptions return standardized `ErrorResponse` with status, message, and timestamp

## Role-Based Authorization Patterns
**In Service Layer**: Every method that accesses user data checks role
```java
// Example from UserService.getUserById()
if (requestingUserRole == UserRole.USER && !userId.equals(requestingUserId)) {
    throw new UnauthorizedException("You can only view your own profile");
}

// Only ADMIN can see all users
if (requestingUserRole != UserRole.ADMIN) {
    throw new UnauthorizedException("Only admins can view all users");
}
```

**In Controller Layer**: Accept requestingUserId and role as query parameters
```java
@GetMapping("/{userId}")
public ResponseEntity<UserDto> getUser(
    @PathVariable Long userId,
    @RequestParam Long requestingUserId,
    @RequestParam String role) {
    // Pass to service for authorization check
    UserRole userRole = UserRole.valueOf(role.toUpperCase());
    UserDto userDto = userService.getUserById(userId, requestingUserId, userRole);
}
```

**Future Enhancement**: Replace query params with JWT token-based authentication (currently manual for clarity)

## Testing Conventions
- Unit tests in `src/test/java/` following `{Class}Test.java` naming
- Use `@WebMvcTest` for controller tests
- Use `@DataJpaTest` for repository tests
- Use `@SpringBootTest` for integration tests

## API Testing Examples (cURL)

### 1. Create Bank
```bash
curl -X POST http://localhost:8080/api/banks \
  -H "Content-Type: application/json" \
  -d '{"name":"FCMB","code":"FCMB001","adminEmail":"admin@fcmb.com"}'
```

### 2. Register User (USER role)
```bash
curl -X POST http://localhost:8080/api/users/register \
  -H "Content-Type: application/json" \
  -d '{
    "bankId": 1,
    "email": "john@example.com",
    "firstName": "John",
    "lastName": "Doe",
    "phoneNumber": "0123456789",
    "password": "password123",
    "role": "USER"
  }'
```

### 3. Register Admin User
```bash
curl -X POST http://localhost:8080/api/users/register \
  -H "Content-Type: application/json" \
  -d '{
    "bankId": 1,
    "email": "admin@example.com",
    "firstName": "Admin",
    "lastName": "User",
    "phoneNumber": "0123456788",
    "password": "admin123",
    "role": "ADMIN"
  }'
```

### 4. Get User (with authorization)
```bash
# User viewing own profile
curl http://localhost:8080/api/users/1?requestingUserId=1&role=USER

# Admin viewing any user
curl http://localhost:8080/api/users/2?requestingUserId=1&role=ADMIN

# User trying to view another user (FAILS)
curl http://localhost:8080/api/users/2?requestingUserId=1&role=USER
# Returns: 403 Forbidden - "You can only view your own profile"
```

### 5. Get All Users (Admin only)
```bash
# Admin can see all users
curl http://localhost:8080/api/users/bank/1?requestingUserId=1&role=ADMIN

# User cannot see all users (FAILS)
curl http://localhost:8080/api/users/bank/1?requestingUserId=2&role=USER
# Returns: 403 Forbidden - "Only admins can view all users"
```

## PIN (6-Digit) Security Implementation

### PIN Validation & Format Requirements
- **Length**: Exactly 6 digits
- **Characters**: Numbers only (0-9)
- **Format**: `[0-9]{6}`
- **Storage**: Hashed before storing in database (currently simple hash, production use BCrypt)

### PIN Validation Utility (`util/PinValidator.java`)

**Methods Available**:
1. `validatePinFormat(String pin)` - Validates PIN is exactly 6 digits
   ```java
   // Examples:
   PinValidator.validatePinFormat("123456");  // ✅ Valid
   PinValidator.validatePinFormat("12345");   // ❌ BadRequestException: "PIN must be exactly 6 digits"
   PinValidator.validatePinFormat("12345a");  // ❌ BadRequestException: "PIN must contain only numbers"
   ```

2. `hashPin(String pin)` - Hash PIN before storing
   ```java
   String hashedPin = PinValidator.hashPin("123456");
   // Returns: "HASHED_123456_PIN" (production: use BCrypt)
   ```

3. `verifyPin(String rawPin, String hashedPin)` - Verify PIN during login
   ```java
   boolean isValid = PinValidator.verifyPin("123456", storedHashedPin);
   ```

4. `checkCompromisedPin(String pin)` - Prevent common/weak PINs
   ```java
   // Rejects these common patterns:
   // "000000", "111111", "123456", "654321", etc.
   ```

### PIN Flow in Registration

```
1. User provides PIN during registration
   ↓
2. PinValidator.validatePinFormat(pin)
   ✓ Checks format (6 digits only)
   ↓
3. PinValidator.checkCompromisedPin(pin)
   ✓ Checks against common patterns
   ↓
4. PinValidator.hashPin(pin)
   ✓ Hashes PIN for secure storage
   ↓
5. Save hashed PIN to database
   (Original PIN not stored)
```

### PIN Flow in Login

```
1. User provides email, password, PIN
   ↓
2. Find user by email
   ↓
3. Verify password matches
   ↓
4. Verify PIN using PinValidator.verifyPin()
   ✓ Compares provided PIN with stored hash
   ↓
5. If all match → Return LoginResponseDto with user details
   If any fails → Throw UnauthorizedException
```

### PIN Security Best Practices (Implemented)
✅ **Validated format** - Must be exactly 6 digits  
✅ **Hashed storage** - Not stored in plain text  
✅ **Compromised check** - Reject common patterns  
✅ **Failed attempt logging** - (Future enhancement)  
✅ **Rate limiting** - (Future enhancement)  
✅ **Account lockout** - (Future enhancement after 3 failed attempts)

### PIN Testing Examples (cURL)

### 6. Register User with PIN
```bash
curl -X POST http://localhost:8080/api/users/register \
  -H "Content-Type: application/json" \
  -d '{
    "bankId": 1,
    "email": "john@example.com",
    "firstName": "John",
    "lastName": "Doe",
    "phoneNumber": "0123456789",
    "password": "password123",
    "pin": "123456",
    "role": "USER"
  }'
```

### 7. Login with PIN
```bash
# Successful login
curl -X POST http://localhost:8080/api/users/login \
  -H "Content-Type: application/json" \
  -d '{
    "email": "john@example.com",
    "password": "password123",
    "pin": "123456"
  }'
# Returns: LoginResponseDto with user details + message "Login successful"

# Invalid PIN format (FAILS)
curl -X POST http://localhost:8080/api/users/login \
  -H "Content-Type: application/json" \
  -d '{
    "email": "john@example.com",
    "password": "password123",
    "pin": "12345"
  }'
# Returns: 400 Bad Request - "PIN must be exactly 6 digits"

# Wrong PIN (FAILS)
curl -X POST http://localhost:8080/api/users/login \
  -H "Content-Type: application/json" \
  -d '{
    "email": "john@example.com",
    "password": "password123",
    "pin": "654321"
  }'
# Returns: 403 Forbidden - "Invalid PIN"

# Weak PIN (FAILS)
curl -X POST http://localhost:8080/api/users/register \
  -H "Content-Type: application/json" \
  -d '{
    "bankId": 1,
    "email": "test@example.com",
    "firstName": "Test",
    "lastName": "User",
    "phoneNumber": "0987654321",
    "password": "password123",
    "pin": "123456",
    "role": "USER"
  }'
# Returns: 400 Bad Request - "PIN is too common. Please choose a different PIN"
```
