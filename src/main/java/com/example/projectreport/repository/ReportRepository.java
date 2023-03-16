package com.example.projectreport.repository;

import com.example.projectreport.entity.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {
    @Query(value = "select * from reports WHERE created_date = ?",nativeQuery = true )
    List<Report> getCreatedDateReport (LocalDate createdDate);
}
