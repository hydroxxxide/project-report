package com.example.projectreport.controller;

import com.example.projectreport.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/task")
public class TaskController {
    TaskService taskService;
}
