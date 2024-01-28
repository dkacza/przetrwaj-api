package dev.przetrwaj.przetrwajapi.report.type;

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

    public ReportType addNewReportType(ReportTypeDTO reportTypeDAO) {
        ReportType newReportType = reportTypeDAO.convertFromDTO();
        reportTypeRepository.save(newReportType);
        return newReportType;
    }
}
