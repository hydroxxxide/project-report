package com.example.projectreport.controller;

import com.example.projectreport.service.RepostService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/report")
public class ReportController {
    RepostService repostService;
}
