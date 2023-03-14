package com.example.projectreport.dto;

import com.example.projectreport.enums.UserRole;
import com.example.projectreport.enums.UserStatus;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
public class UserDto {

    private Long id;
    private String email;
    private String username;
    private String password;
    private UserStatus userStatus;
}
