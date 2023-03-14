package com.example.projectreport.service;

import com.example.projectreport.repository.ReportRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ReportService {
    ReportRepository reportRepository;

}
