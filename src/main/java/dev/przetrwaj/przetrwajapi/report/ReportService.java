package dev.przetrwaj.przetrwajapi.report;

import dev.przetrwaj.przetrwajapi.Localisation.Localisation;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

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

    public Report addNewReport(Date date, Localisation localisation,
                                ReportType reportType,  Integer threatDegree,
                                String nameDescription,  String reportDescription) {
        return reportRepository.save(new Report(date, localisation, reportType,
                threatDegree, nameDescription, reportDescription));
    }
}
