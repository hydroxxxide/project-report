package com.example.projectreport.dto;

import com.example.projectreport.entity.Task;
import com.example.projectreport.enums.ReportStatus;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class ReportDto {
    private Long id;
    private String title;
    private String text;
    private Integer totalTasks;
    private LocalDate createdDate;
    @OneToMany
    @JoinColumn(name = "report_id")
    List<Task> tasks = new ArrayList<>();
    @Enumerated(EnumType.STRING)
    private ReportStatus reportStatus;
}
