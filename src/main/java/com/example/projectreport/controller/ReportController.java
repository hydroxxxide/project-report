package com.example.projectreport.controller;

import com.example.projectreport.entity.Report;
import com.example.projectreport.service.ReportService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/report")
public class ReportController {
    ReportService reportService;
    public List<Report> getAllReports(){
        return reportService
    }
}
