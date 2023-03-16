package com.example.projectreport.controller;

import com.example.projectreport.entity.Report;
import com.example.projectreport.enums.ReportStatus;
import com.example.projectreport.service.ReportService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/report")
public class ReportController {
    ReportService reportService;
    @PostMapping("/create")
    Report createReport(@RequestBody Report report){
        return reportService.createReport(report);
    }
    @GetMapping("/all")
    List<Report> getAllReports(){
        return reportService.getAllReports();
    }
    @GetMapping("/{id}")
    Report getReportById(@PathVariable Long id){
        return reportService.getReportById(id);
    }
    @PostMapping("/update/{id}")
    Report updateReport(@PathVariable Long id, @RequestBody Report report){
        return reportService.updateReport(id, report);
    }
    @PostMapping("/delete/{id}")
    void deleteReport(@PathVariable Long id){
        reportService.deleteReport(id);
    }
    @PostMapping("/change-status/{id}")
    Report changeStatus(@PathVariable Long id, @RequestParam ReportStatus reportStatus){
        return reportService.changeReportStatus(id, reportStatus);
    }
    @GetMapping("/send/{id}")
    Report sendReport(@PathVariable Long id, @RequestBody Report report){
        return reportService.generateTaskReport(id, report);
    }
    @GetMapping("/last-week-report")
    List <Report> sendLastWeekReport(){
        LocalDate today = LocalDate.now();
        LocalDate lastWeek = today.minusDays(7);
        return reportService.getLastWeekReport(lastWeek);
    }
}
