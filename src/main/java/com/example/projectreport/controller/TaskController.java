package com.example.projectreport.controller;

import com.example.projectreport.dto.TaskDto;
import com.example.projectreport.entity.Task;
import com.example.projectreport.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


@AllArgsConstructor
@RestController
@RequestMapping("/task")
public class TaskController {

    TaskService taskService;

    @PostMapping("/create")
    public TaskDto createTask(@RequestBody TaskDto taskDto) {
        Task task = mapToTask(taskDto);
        Task createdTask = taskService.saveTask(task);
        return mapToTaskDto(createdTask);
    }

    @GetMapping("/{id}")
    public TaskDto getTask(@PathVariable Long id) {
        Task task = taskService.findTaskById(id);
        return mapToTaskDto(task);
    }

    @PutMapping("/update/{id}")
    public TaskDto updateTask(@PathVariable Long id, @RequestBody TaskDto taskDto) {
        Task task = taskService.findTaskById(id);
        Task updatedTask = taskService.updateTask(task);
        return mapToTaskDto(updatedTask);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTaskById(id);
    }

    private TaskDto mapToTaskDto(Task task) {
        TaskDto taskDto = new TaskDto();
        taskDto.setId(task.getId());
        taskDto.setTitle(task.getTitle());
        taskDto.setDescription(task.getDescription());
        taskDto.setStartDate(task.getStartDate());
        taskDto.setEndDate(task.getEndDate());
        return taskDto;
    }

    private Task mapToTask(TaskDto taskDto) {
        Task task = new Task();
        task.setId(taskDto.getId());
        task.setTitle(taskDto.getTitle());
        task.setDescription(taskDto.getDescription());
        task.setStartDate(taskDto.getStartDate());
        task.setEndDate(taskDto.getEndDate());
        return task;
    }
}
