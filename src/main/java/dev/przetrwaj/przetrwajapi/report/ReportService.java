package dev.przetrwaj.przetrwajapi.report;

import dev.przetrwaj.przetrwajapi.location.Location;
import dev.przetrwaj.przetrwajapi.report.type.ReportType;
import dev.przetrwaj.przetrwajapi.report.type.ReportTypeDTO;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ReportService {
    private final ReportRepository reportRepository;

    public ReportService(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    public List<Report> getAllReports(){
        return reportRepository.findAll();
    }

    public Report addNewReport(ReportDTO reportDTO) {
        Report newReport = reportDTO.convertFromDTO();
        reportRepository.save(newReport);
        return newReport;
    }
}
