package com.example.projectreport.mapper;

import com.example.projectreport.dto.TaskDto;
import com.example.projectreport.entity.Task;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    TaskDto taskToTaskDto(Task task);
    Task taskDtoToTask(TaskDto taskDto);
}
