package dev.przetrwaj.przetrwajapi.report;

import dev.przetrwaj.przetrwajapi.Localisation.Localisation;
import org.springframework.stereotype.Service;

import java.util.Date;
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

    public ReportType addNewReportType(ReportTypeDAO reportTypeDAO) {
        ReportType newReportType = reportTypeDAO.convertFromDAO();
        reportTypeRepository.save(newReportType);
        return newReportType;
    }
}
