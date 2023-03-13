package com.example.projectreport.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "report_sequence")
    @SequenceGenerator(name = "report_sequence", sequenceName = "report_seq", allocationSize = 1)
    private Long id;
}
