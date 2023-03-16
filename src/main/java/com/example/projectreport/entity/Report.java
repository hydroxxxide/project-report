package com.example.projectreport.entity;

import com.example.projectreport.enums.ReportStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "reports")
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String title;
    @Column
    private String text;
    @Column
    private Integer totalTasks;
    @Column
    private LocalDate createdDate;
    @OneToMany
    @JoinColumn(name = "report_id")
    List<Task> tasks = new ArrayList<>();
    @Column
    @Enumerated(EnumType.STRING)
    private ReportStatus reportStatus;
}
