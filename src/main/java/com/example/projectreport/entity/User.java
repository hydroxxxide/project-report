package com.example.projectreport.entity;

import com.example.projectreport.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String email;
    @Column
    private String username;
    @Column
    private String password;
    @Column
    @Enumerated(EnumType.STRING)
    private UserRole userRole;
    @OneToMany
    @JoinColumn(name = "user_id")
    List<Report> reports = new ArrayList<>();
    @OneToMany
    @JoinColumn(name = "user_id")
    List<Task> tasks = new ArrayList<>();
}
