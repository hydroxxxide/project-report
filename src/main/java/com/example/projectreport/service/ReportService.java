package com.example.projectreport.service;

import com.example.projectreport.entity.Report;
import com.example.projectreport.enums.ReportStatus;
import com.example.projectreport.repository.ReportRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@AllArgsConstructor
@Service
public class ReportService {
    ReportRepository reportRepository;
    public List<Report> getAllReports(){
        return reportRepository.findAll();
    }
    public Report getReportById(Long id){
        return reportRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Report with id " + id + "not found"));
    }
    public Report createReport(Report report){
        report.setReportStatus(ReportStatus.NEW);
        return reportRepository.save(report);
    }
    public Report updateReport(Long id, Report report){
        Report newReport = getReportById(id);
        newReport.setText(report.getText());
        newReport.setTitle(report.getTitle());
        newReport.setTasks(report.getTasks());
        return reportRepository.save(newReport);
    }
    public void deleteReport(Long id){
        reportRepository.deleteById(id);
    }
    public Report changeReportStatus(Long id, ReportStatus reportStatus){
        Report report = getReportById(id);
        report.setReportStatus(reportStatus);
        return reportRepository.save(report);
    }

}
