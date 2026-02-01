package com.example.demo.service;

import com.example.demo.dto.CreateUserDto;
import com.example.demo.dto.LoginDto;
import com.example.demo.dto.LoginResponseDto;
import com.example.demo.dto.UserDto;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.exception.UnauthorizedException;
import com.example.demo.model.Bank;
import com.example.demo.model.User;
import com.example.demo.model.UserRole;
import com.example.demo.repository.BankRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.util.PinValidator;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;
    private final BankRepository bankRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserService(UserRepository userRepository, BankRepository bankRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bankRepository = bankRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    /**
     * Register a new user in the bank with PIN
     * 
     * Flow:
     * 1. Validate all inputs
     * 2. Validate PIN format (6 digits)
     * 3. Check for compromised PINs
     * 4. Hash PIN before storing
     * 5. Create user
     */
    public UserDto registerUser(CreateUserDto createUserDto) {
        // Validate input
        if (createUserDto.getEmail() == null || createUserDto.getEmail().isBlank()) {
            throw new BadRequestException("Email is required");
        }
        if (createUserDto.getPassword() == null || createUserDto.getPassword().isBlank()) {
            throw new BadRequestException("Password is required");
        }
        if (createUserDto.getBankId() == null) {
            throw new BadRequestException("Bank ID is required");
        }

        // NEW: Validate PIN
        if (createUserDto.getPin() == null || createUserDto.getPin().isBlank()) {
            throw new BadRequestException("PIN is required");
        }
        
        // Validate PIN format (exactly 6 digits)
        PinValidator.validatePinFormat(createUserDto.getPin());
        
        // Check if PIN is compromised (too common)
        PinValidator.checkCompromisedPin(createUserDto.getPin());

        // Check if user already exists
        if (userRepository.findByEmail(createUserDto.getEmail()).isPresent()) {
            throw new BadRequestException("Email already registered");
        }
        if (userRepository.findByPhoneNumber(createUserDto.getPhoneNumber()).isPresent()) {
            throw new BadRequestException("Phone number already registered");
        }

        // Get bank
        Bank bank = bankRepository.findById(createUserDto.getBankId())
                .orElseThrow(() -> new ResourceNotFoundException("Bank not found"));

        // Create user
        User user = new User();
        user.setBank(bank);
        user.setEmail(createUserDto.getEmail());
        user.setFirstName(createUserDto.getFirstName());
        user.setLastName(createUserDto.getLastName());
        user.setPhoneNumber(createUserDto.getPhoneNumber());
        // Hash password using BCrypt (secure, with salt and iterations)
        user.setPassword(bCryptPasswordEncoder.encode(createUserDto.getPassword()));
        // Hash PIN using BCrypt (through PinValidator)
        user.setPin(PinValidator.hashPin(createUserDto.getPin()));
        user.setAccountNumber(generateAccountNumber());
        user.setAccountBalance(BigDecimal.ZERO);
        
        // Set role (default to USER if not specified)
        UserRole role = UserRole.USER;
        if (createUserDto.getRole() != null) {
            try {
                role = UserRole.valueOf(createUserDto.getRole().toUpperCase());
            } catch (IllegalArgumentException e) {
                throw new BadRequestException("Invalid role. Must be ADMIN or USER");
            }
        }
        user.setRole(role);

        User savedUser = userRepository.save(user);
        return mapToDto(savedUser);
    }

    /**
     * Login user with email, password, and PIN
     * 
     * Flow:
     * 1. Find user by email
     * 2. Verify password matches
     * 3. Verify PIN matches (6-digit)
     * 4. Return LoginResponseDto with user details
     * 
     * Example:
     * POST /api/auth/login
     * {
     *   "email": "john@example.com",
     *   "password": "password123",
     *   "pin": "123456"
     * }
     */
    public LoginResponseDto login(LoginDto loginDto) {
        // Validate input
        if (loginDto.getEmail() == null || loginDto.getEmail().isBlank()) {
            throw new BadRequestException("Email is required");
        }
        if (loginDto.getPassword() == null || loginDto.getPassword().isBlank()) {
            throw new BadRequestException("Password is required");
        }
        if (loginDto.getPin() == null || loginDto.getPin().isBlank()) {
            throw new BadRequestException("PIN is required");
        }

        // Find user by email
        User user = userRepository.findByEmail(loginDto.getEmail())
                .orElseThrow(() -> new UnauthorizedException("Invalid email or password"));

        // Verify password using BCrypt (timing-safe comparison)
        if (!bCryptPasswordEncoder.matches(loginDto.getPassword(), user.getPassword())) {
            throw new UnauthorizedException("Invalid email or password");
        }

        // Verify PIN (using BCrypt comparison via PinValidator)
        if (!PinValidator.verifyPin(loginDto.getPin(), user.getPin())) {
            throw new UnauthorizedException("Invalid PIN");
        }

        // Create login response
        return new LoginResponseDto(
                user.getId(),
                user.getBank().getId(),
                user.getEmail(),
                user.getFirstName(),
                user.getLastName(),
                user.getPhoneNumber(),
                user.getAccountNumber(),
                user.getAccountBalance(),
                user.getRole(),
                "token_will_go_here", // TODO: Generate JWT token
                LocalDateTime.now(),
                "Login successful"
        );
    }

    /**
     * Get user by ID
     * ADMIN: can see any user in their bank
     * USER: can only see themselves
     */
    public UserDto getUserById(Long userId, Long requestingUserId, UserRole requestingUserRole) {
        User requestingUser = userRepository.findById(requestingUserId)
                .orElseThrow(() -> new ResourceNotFoundException("Requesting user not found"));

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        // Authorization check
        if (requestingUserRole == UserRole.USER && !userId.equals(requestingUserId)) {
            throw new UnauthorizedException("You can only view your own profile");
        }

        // Check if both users belong to same bank (for ADMIN viewing)
        if (!requestingUser.getBank().getId().equals(user.getBank().getId())) {
            throw new UnauthorizedException("User belongs to different bank");
        }

        return mapToDto(user);
    }

    /**
     * Get all users in a bank
     * Only ADMIN can access this
     */
    public List<UserDto> getAllUsersInBank(Long bankId, UserRole requestingUserRole) {
        if (requestingUserRole != UserRole.ADMIN) {
            throw new UnauthorizedException("Only admins can view all users");
        }

        List<User> users = userRepository.findByBankId(bankId);
        return users.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    /**
     * Update user account balance (for transfers and purchases)
     */
    public void updateBalance(Long userId, BigDecimal newBalance) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        if (newBalance.compareTo(BigDecimal.ZERO) < 0) {
            throw new BadRequestException("Balance cannot be negative");
        }

        user.setAccountBalance(newBalance);
        userRepository.save(user);
    }

    /**
     * Get user by account number (for transfers)
     */
    public User getUserByAccountNumber(String accountNumber) {
        return userRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Account not found"));
    }

    /**
     * Get user by email
     */
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    /**
     * Convert User entity to UserDto
     */
    private UserDto mapToDto(User user) {
        return new UserDto(
                user.getId(),
                user.getBank().getId(),
                user.getEmail(),
                user.getFirstName(),
                user.getLastName(),
                user.getPhoneNumber(),
                user.getAccountNumber(),
                user.getAccountBalance(),
                user.getRole(),
                user.getCreatedAt(),
                user.getUpdatedAt()
        );
    }

    /**
     * Generate unique account number
     */
    private String generateAccountNumber() {
        // In production, follow bank's account number format
        return UUID.randomUUID().toString().replace("-", "").substring(0, 10);
    }
}
