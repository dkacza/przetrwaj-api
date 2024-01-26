package dev.przetrwaj.przetrwajapi.report;

import dev.przetrwaj.przetrwajapi.Localisation.Localisation;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1/report")
public class ReportController {
    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }
    @GetMapping
    public List<Report> getAllReports(){
        return reportService.getAllReports();
    }
    @PostMapping
    public Report addReport(@RequestBody Date date, @RequestBody Localisation localisation,
                          @RequestBody ReportType reportType, @RequestBody Integer threatDegree,
                          @RequestBody String nameDescription, @RequestBody String reportDescription){
        return reportService.addNewReport(date, localisation, reportType, threatDegree, nameDescription, reportDescription);
    }
}
