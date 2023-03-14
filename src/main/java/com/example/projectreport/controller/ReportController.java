package com.example.projectreport.controller;

import com.example.projectreport.service.ReportService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/report")
public class ReportController {
    ReportService repostService;
}
