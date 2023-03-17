package com.example.projectreport.controller;

import com.example.projectreport.dto.ReportDto;
import com.example.projectreport.entity.Report;
import com.example.projectreport.enums.ReportStatus;
import com.example.projectreport.service.ReportService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/report")
public class ReportController {

    ReportService reportService;

    @PostMapping("/create")
    ReportDto createReport(@RequestBody ReportDto reportDto){
        Report report = mapToReport(reportDto);
        reportService.createReport(report);
        return mapToReportDto(report);
    }

    @GetMapping("/all")
    List<ReportDto> getAllReports(){
        List<Report> reports = reportService.getAllReports();
        return maptoDtoList(reports);
    }

    @GetMapping("/{id}")
    ReportDto getReportById(@PathVariable Long id){
        Report report = reportService.getReportById(id);
        return mapToReportDto(report);
    }

    @PutMapping("/update/{id}")
    ReportDto updateReport(@PathVariable Long id, @RequestBody ReportDto reportDto){
        Report report = reportService.getReportById(id);
        Report updatedReport = reportService.updateReport(id, report);
        return mapToReportDto(updatedReport);
    }

    @PostMapping("/delete/{id}")
    void deleteReport(@PathVariable Long id){
        reportService.deleteReport(id);
    }

    @PostMapping("/change-status/{id}")
    ReportDto changeStatus(@PathVariable Long id, @RequestParam ReportStatus reportStatus){
        Report changeReport = reportService.changeReportStatus(id, reportStatus);
        return mapToReportDto(changeReport);
    }

    @PostMapping("/send/{id}")
    ReportDto sendReport(@RequestParam Long user_id, @RequestBody Report report){
        Report sendReport = reportService.generateTaskReport(user_id, report);
        return mapToReportDto(sendReport);
    }

    @GetMapping("/last-week-report")
    List <ReportDto> getLastWeekReport(){
        LocalDate today = LocalDate.now();
        LocalDate lastWeek = today.minusDays(7);
        List<Report> lastweekReport = reportService.getLastWeekReport(lastWeek);
        return maptoDtoList(lastweekReport);
    }
    @GetMapping("/download")
    ResponseEntity<byte[]> downloadReports(HttpServletResponse response)throws IOException{
        List<Report> reports = reportService.getAllReports();
        return reportService.exportToExcel(reports);
    }

    private Report mapToReport(ReportDto reportDto) {
        Report report = new Report();
        report.setId(reportDto.getId());
        report.setText(reportDto.getText());
        report.setTasks(reportDto.getTasks());
        report.setCreatedDate(reportDto.getCreatedDate());
        report.setReportStatus(reportDto.getReportStatus());
        report.setTitle(reportDto.getTitle());
        report.setTotalTasks(reportDto.getTotalTasks());
        return report;
    }
    public List<ReportDto> maptoDtoList(List<Report> reports) {
        List<ReportDto> reportDtos = new ArrayList<>();
        for (Report report : reports) {
            reportDtos.add(mapToReportDto(report));
        }
        return reportDtos;
    }
    private ReportDto mapToReportDto(Report report) {
        ReportDto reportDto = new ReportDto();
        reportDto.setId(report.getId());
        reportDto.setText(report.getText());
        reportDto.setTasks(report.getTasks());
        reportDto.setCreatedDate(report.getCreatedDate());
        reportDto.setReportStatus(report.getReportStatus());
        reportDto.setTitle(report.getTitle());
        reportDto.setTotalTasks(report.getTotalTasks());
        return reportDto;
    }
}
