package com.admin.admin.dto;

import lombok.Data;

@Data
public class UserRegistrationDTO {
    private String username;
    private String email;
    private String password;
    private String role;
    private String firstName;
    private String lastName;
    private String phoneNumber;

}