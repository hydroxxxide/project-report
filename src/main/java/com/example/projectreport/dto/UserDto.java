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

    public UserDto(Long id, String email, String username, String password, UserRole userRole) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.password = password;
        this.userRole = userRole;
    }

    public UserDto() {
    }
}
