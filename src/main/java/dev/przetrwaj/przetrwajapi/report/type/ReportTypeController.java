package dev.przetrwaj.przetrwajapi.report.type;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reportType")
public class ReportTypeController {
    private final ReportTypeService reportTypeService;

    public ReportTypeController(ReportTypeService reportTypeService) {
        this.reportTypeService = reportTypeService;
    }

    @GetMapping
    public List<ReportType> getAllReportTypes(){
        return reportTypeService.getAllReportTypes();
    }
    @PostMapping
    public ReportType addReportType(@RequestBody ReportTypeDTO reportTypeDTO){
        return reportTypeService.addNewReportType(reportTypeDTO);
    }
}
