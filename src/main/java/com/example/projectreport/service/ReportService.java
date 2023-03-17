package com.example.projectreport.service;

import com.example.projectreport.entity.Report;
import com.example.projectreport.entity.Task;
import com.example.projectreport.enums.ReportStatus;
import com.example.projectreport.repository.ReportRepository;
import lombok.AllArgsConstructor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@AllArgsConstructor
@Service
public class ReportService {
    ReportRepository reportRepository;
    TaskService taskService;
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
    public Report generateTaskReport(Long id, Report report) {
        List<Task> tasks = taskService.findAllTasksByUserId(id);
        int totalTasks = tasks.size();
        report.setTasks(tasks);
        report.setTotalTasks(totalTasks);
        createReport(report);
        return report;
    }
    public List<Report> getLastWeekReport(LocalDate date){
        return reportRepository.getCreatedDateReport(date);
    }
    public ResponseEntity<byte[]> exportToExcel(List<Report> reports) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Reports");

        // Задаем стиль заголовков
        CellStyle headerStyle = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setBold(true);
        headerStyle.setFont(font);

        // Создаем заголовки столбцов
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("ID");
        headerRow.createCell(1).setCellValue("Title");
        headerRow.createCell(2).setCellValue("Description");


        // Устанавливаем стиль заголовков
        for (Cell cell : headerRow) {
            cell.setCellStyle(headerStyle);
        }

        // Заполняем таблицу данными
        int rowNum = 1;
        for (Report report : reports) {
            Row row = sheet.createRow(rowNum++);

            row.createCell(0).setCellValue(report.getId());
            row.createCell(1).setCellValue(report.getTitle());
            row.createCell(2).setCellValue(report.getText());

        }

        // Авторазмер столбцов
        for (int i = 0; i < 5; i++) {
            sheet.autoSizeColumn(i);
        }

        // Переводим книгу Excel в массив байтов
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        workbook.write(outputStream);


        String fileName = "report on tasks " +
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));

        // Формируем ответ с файлом Excel
        byte[] bytes = outputStream.toByteArray();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", fileName + ".xlsx");
        headers.setContentLength(bytes.length);
        return new ResponseEntity<>(bytes, headers, 200);
    }

}
