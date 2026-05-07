package com.farmershub.backend.dto.request;

import com.farmershub.backend.model.UserStatus;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RegisterRequest {
    @NotBlank
    private String fullName;

    @Email @NotBlank
    private String email;

    @NotBlank
    private String password;

    private UserStatus status = UserStatus.ASPIRANT; // default
}