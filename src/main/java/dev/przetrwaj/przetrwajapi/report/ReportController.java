package dev.przetrwaj.przetrwajapi.report;

import dev.przetrwaj.przetrwajapi.location.Location;
import dev.przetrwaj.przetrwajapi.report.type.ReportType;
import dev.przetrwaj.przetrwajapi.report.type.ReportTypeDTO;
import dev.przetrwaj.przetrwajapi.resource.point.CoordinatesDTO;
import dev.przetrwaj.przetrwajapi.resource.point.ResourcePoint;
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
    @GetMapping("/getRepsByLoc")
    public List<Report> getResourcePointsByLocation(@RequestBody CoordinatesDTO coordinatesDTO){
        return reportService.getReportsByLocation(coordinatesDTO);
    }
    @GetMapping
    public List<Report> getAllReports(){
        return reportService.getAllReports();
    }
    @PostMapping
    public Report addReport(@RequestBody ReportDTO reportDTO){
        return reportService.addNewReport(reportDTO);
    }
}
