package com.example.projectreport.dto;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class TaskDto {
    private Long id;
    private String title;
    private String description;
    private Timestamp startDate;
    private Timestamp endDate;
}
