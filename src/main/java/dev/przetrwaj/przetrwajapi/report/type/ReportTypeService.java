package dev.przetrwaj.przetrwajapi.report.type;

import dev.przetrwaj.przetrwajapi.resource.type.ResourceType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportTypeService {
    private final ReportTypeRepository reportTypeRepository;

    public ReportTypeService(ReportTypeRepository reportTypeRepository) {
        this.reportTypeRepository = reportTypeRepository;
    }

    public List<ReportType> getAllReportTypes(){
        return reportTypeRepository.findAll();
    }

//    public ReportType addNewReportType(ReportTypeDTO reportTypeDTO) {
//        ReportType newReportType = reportTypeDTO.convertFromDTO();
//        reportTypeRepository.save(newReportType);
//        return newReportType;
//    }
    public void addReportType(ReportType reportType){
        reportTypeRepository.save(reportType);
}
}