package com.farmershub.backend.service;

import com.farmershub.backend.dto.UserDTO;
import com.farmershub.backend.model.Role;
import com.farmershub.backend.model.User;
import com.farmershub.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private static final String UPLOAD_DIR = "uploads/profiles/";

    public List<UserDTO> getAllUsers() {
        return userRepository.findByRoleNot(Role.ADMIN)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public UserDTO getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return toDTO(user);
    }

    public UserDTO updateProfilePicture(Long userId, MultipartFile file) throws IOException {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        String filename = userId + "_" + file.getOriginalFilename();
        Path path = Paths.get(UPLOAD_DIR + filename);
        Files.createDirectories(path.getParent());
        Files.write(path, file.getBytes());

        user.setProfilePic("/uploads/profiles/" + filename);
        userRepository.save(user);
        return toDTO(user);
    }

    // Converts User entity to UserDTO (safe to send to frontend)
    private UserDTO toDTO(User user) {
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setFullName(user.getFullName());
        dto.setEmail(user.getEmail());
        dto.setStatus(user.getStatus().name());
        dto.setProfilePic(user.getProfilePic());
        dto.setBio(user.getBio());
        return dto;
    }
}