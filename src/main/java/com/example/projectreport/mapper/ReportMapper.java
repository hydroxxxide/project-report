package com.example.projectreport.mapper;

import com.example.projectreport.dto.ReportDto;
import com.example.projectreport.entity.Report;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public interface ReportMapper {
    ReportDto reportToReportDto(Report report);
    Report reportDtoToReport(ReportDto reportDto);

    List<ReportDto> reportListToReportDtoList(List<Report> reportList);
    List<Report> reportDtoListToReportList(List<ReportDto> reportDtoList);
}
