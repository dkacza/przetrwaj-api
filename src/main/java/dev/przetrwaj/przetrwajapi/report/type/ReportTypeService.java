package dev.przetrwaj.przetrwajapi.report.type;

import dev.przetrwaj.przetrwajapi.report.type.ReportType;
import dev.przetrwaj.przetrwajapi.report.type.ReportTypeDAO;
import dev.przetrwaj.przetrwajapi.report.type.ReportTypeRepository;
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

    public ReportType addNewReportType(ReportTypeDAO reportTypeDAO) {
        ReportType newReportType = reportTypeDAO.convertFromDAO();
        reportTypeRepository.save(newReportType);
        return newReportType;
    }
}
