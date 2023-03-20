package com.example.projectreport.mapper;

import com.example.projectreport.dto.TaskDto;
import com.example.projectreport.entity.Task;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public interface TaskMapper {
    TaskDto taskToTaskDto(Task task);
    Task taskDtoToTask(TaskDto taskDto);

    List<TaskDto> taskListToTaskDtoList(List<Task> taskList);
    List<Task> taskDtoListToTaskList(List<TaskDto> taskDtoList);
}
