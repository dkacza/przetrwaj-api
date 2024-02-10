package dev.przetrwaj.przetrwajapi.report;

import dev.przetrwaj.przetrwajapi.location.Location;
import dev.przetrwaj.przetrwajapi.location.LocationRepository;
import dev.przetrwaj.przetrwajapi.report.type.ReportType;
import dev.przetrwaj.przetrwajapi.report.type.ReportTypeRepository;
import dev.przetrwaj.przetrwajapi.resource.point.CoordinatesDTO;
import dev.przetrwaj.przetrwajapi.resource.point.ResourcePoint;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ReportService {
    private final ReportRepository reportRepository;
    private final LocationRepository locationRepository;
    private final ReportTypeRepository reportTypeRepository;

    public ReportService(ReportRepository reportRepository, LocationRepository locationRepository, ReportTypeRepository reportTypeRepository) {
        this.reportRepository = reportRepository;
        this.locationRepository = locationRepository;
        this.reportTypeRepository = reportTypeRepository;
    }
    public List<Report> getReportsByLocation(CoordinatesDTO coordinatesDTO){
        List <Report> allPoints = reportRepository.findAll();
        List <Report> visiblePoints = new ArrayList<>();
        for(Report report : allPoints){
            if(locationIsInBounds(report.getLocation(),coordinatesDTO.getLatitudeUpperBoundry(),
                    coordinatesDTO.getLatitudeLowerBoundry(),coordinatesDTO.getLongitudeLowerBoundry(),
                    coordinatesDTO.getLongitudeUpperBoundry()))
            {
                visiblePoints.add(report);
            }
        }
        return visiblePoints;
    }

    public List<Report> getAllReports(){
        return reportRepository.findAll();
    }

    public Report addNewReport(ReportDTO reportDTO) {
        Location location = locationRepository.findById(reportDTO.getLocationId()).orElse(null);
        ReportType reportType = reportTypeRepository.findById(reportDTO.getReportTypeID()).orElse(null);
        return reportRepository.save(new Report(reportDTO.getName(), location, reportType,
                reportDTO.getThreatDegree(), reportDTO.getDescription()));
    }
    private boolean locationIsInBounds(Location location, Double top, Double bottom, Double left, Double right){
        return (location.getLongitude() > left && location.getLongitude() < right & location.getLatitude() < top && location.getLatitude() > bottom);
    }
    public void removeReport(Long reportId){
        reportRepository.deleteById(reportId);
    }
}
