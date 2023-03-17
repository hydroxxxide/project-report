package com.example.projectreport.dto;

import com.example.projectreport.enums.UserRole;
import lombok.Data;

@Data
public class UserDto {
    private Long id;
    private String email;
    private String username;
    private String password;
    private UserRole userRole;

}
