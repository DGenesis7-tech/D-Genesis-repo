package com.example.demo.controller;

import com.example.demo.dto.CreateUserDto;
import com.example.demo.dto.LoginDto;
import com.example.demo.dto.LoginResponseDto;
import com.example.demo.dto.UserDto;
import com.example.demo.model.UserRole;
import com.example.demo.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Register a new user with PIN
     * Endpoint: POST /api/users/register
     * 
     * Body: CreateUserDto including 6-digit PIN
     * Returns: UserDto with 201 status
     * 
     * Example:
     * {
     *   "bankId": 1,
     *   "email": "john@example.com",
     *   "firstName": "John",
     *   "lastName": "Doe",
     *   "phoneNumber": "0123456789",
     *   "password": "password123",
     *   "pin": "123456",
     *   "role": "USER"
     * }
     */
    @PostMapping("/register")
    public ResponseEntity<UserDto> registerUser(@RequestBody CreateUserDto createUserDto) {
        UserDto userDto = userService.registerUser(createUserDto);
        return new ResponseEntity<>(userDto, HttpStatus.CREATED);
    }

    /**
     * Login user with email, password, and PIN
     * Endpoint: POST /api/users/login
     * 
     * Body: LoginDto
     * Returns: LoginResponseDto with 200 status
     * 
     * Validation:
     * ✓ Email must exist
     * ✓ Password must match
     * ✓ PIN must be exactly 6 digits
     * ✓ PIN must match stored PIN
     * 
     * Example Request:
     * {
     *   "email": "john@example.com",
     *   "password": "password123",
     *   "pin": "123456"
     * }
     * 
     * Example Response (on success):
     * {
     *   "id": 1,
     *   "bankId": 1,
     *   "email": "john@example.com",
     *   "firstName": "John",
     *   "lastName": "Doe",
     *   "phoneNumber": "0123456789",
     *   "accountNumber": "1234567890",
     *   "accountBalance": 1000.00,
     *   "role": "USER",
     *   "token": "token_will_go_here",
     *   "loginTime": "2026-02-01T10:30:45",
     *   "message": "Login successful"
     * }
     * 
     * Error Cases:
     * - Invalid email: 403 Forbidden - "Invalid email or password"
     * - Invalid password: 403 Forbidden - "Invalid email or password"
     * - Invalid PIN format: 400 Bad Request - "PIN must be exactly 6 digits"
     * - Wrong PIN: 403 Forbidden - "Invalid PIN"
     */
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginDto loginDto) {
        LoginResponseDto response = userService.login(loginDto);
        return ResponseEntity.ok(response);
    }

    /**
     * Get user by ID
     * Endpoint: GET /api/users/{userId}
     * Query params: requestingUserId (current user), role (current user's role)
     * 
     * Example:
     * GET /api/users/1?requestingUserId=1&role=USER → Can access own profile
     * GET /api/users/2?requestingUserId=1&role=USER → Error: Can only see own profile
     * GET /api/users/2?requestingUserId=1&role=ADMIN → Can access (if same bank)
     */
    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getUser(
            @PathVariable Long userId,
            @RequestParam Long requestingUserId,
            @RequestParam String role) {
        
        UserRole userRole = UserRole.valueOf(role.toUpperCase());
        UserDto userDto = userService.getUserById(userId, requestingUserId, userRole);
        return ResponseEntity.ok(userDto);
    }

    /**
     * Get all users in a bank
     * Endpoint: GET /api/users/bank/{bankId}
     * Query params: requestingUserId, role
     * 
     * Only ADMIN can access this endpoint
     * Example:
     * GET /api/users/bank/1?requestingUserId=1&role=ADMIN → Returns all users
     * GET /api/users/bank/1?requestingUserId=2&role=USER → Error: Not authorized
     */
    @GetMapping("/bank/{bankId}")
    public ResponseEntity<List<UserDto>> getAllUsersInBank(
            @PathVariable Long bankId,
            @RequestParam Long requestingUserId,
            @RequestParam String role) {
        
        UserRole userRole = UserRole.valueOf(role.toUpperCase());
        List<UserDto> users = userService.getAllUsersInBank(bankId, userRole);
        return ResponseEntity.ok(users);
    }
}
