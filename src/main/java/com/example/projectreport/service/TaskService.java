package com.example.projectreport.service;

import com.example.projectreport.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class TaskService {
    TaskRepository taskRepository;
}
