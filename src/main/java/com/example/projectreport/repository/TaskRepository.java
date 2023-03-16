package com.example.projectreport.repository;

import com.example.projectreport.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    @Query(value = "select * from tasks WHERE user_id = ?",nativeQuery = true )
    List<Task>findAllByUserId(Long id);
}
