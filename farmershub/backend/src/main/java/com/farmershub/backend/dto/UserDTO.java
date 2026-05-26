package com.farmershub.backend.dto;

import lombok.Data;

@Data
public class UserDTO {
    private Long id;
    private String fullName;
    private String email;
    private String status;
    private String profilePic;
    private String bio;
}