package com.example.projectreport.controller;

import com.example.projectreport.dto.TaskDto;
import com.example.projectreport.entity.Task;
import com.example.projectreport.mapper.TaskMapper;
import com.example.projectreport.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


@AllArgsConstructor
@RestController
@RequestMapping("/task")
public class TaskController {

    private TaskService taskService;
    private TaskMapper taskMapper;

    @PostMapping("/create")
    public TaskDto createTask(@RequestBody TaskDto taskDto) {
        Task task = taskMapper.taskDtoToTask(taskDto);
        taskService.saveTask(task);
        return taskMapper.taskToTaskDto(task);
    }

    @GetMapping("/{id}")
    public TaskDto getTask(@PathVariable Long id) {
        Task task = taskService.findTaskById(id);
        taskMapper.taskToTaskDto(task);
        return taskMapper.taskToTaskDto(task);
    }

    @PutMapping("/update/{id}")
    public TaskDto updateTask(@PathVariable Long id, @RequestBody TaskDto taskDto) {
        Task task = taskService.findTaskById(id);
        Task updatedTask = taskService.updateTask(task);
        return taskMapper.taskToTaskDto(updatedTask);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTaskById(id);
    }

}
