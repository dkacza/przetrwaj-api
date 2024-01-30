package dev.przetrwaj.przetrwajapi.report;

import dev.przetrwaj.przetrwajapi.location.Location;
import dev.przetrwaj.przetrwajapi.report.type.ReportType;


import java.util.Date;

public class ReportDTO {

    private int rejections;
    private int confirmations;
    private int threatDegree;
    private String description;
    private Long locationId;
    private Long reportTypeID;


    public ReportDTO() {
    }


    public ReportDTO(int rejections, int confirmations, Long locationId,
                     Long reportTypeID, int threatDegree, String description) {
        this.rejections = rejections;
        this.confirmations = confirmations;
        this.locationId = locationId;
        this.reportTypeID = reportTypeID;
        this.threatDegree = threatDegree;
        this.description = description;
    }

    public ReportDTO(Long locationId, Long reportTypeID,
                     int threatDegree, String description) {
        this.locationId = locationId;
        this.reportTypeID = reportTypeID;
        this.threatDegree = threatDegree;
        this.description = description;

        this.rejections = 0;
        this.confirmations = 0;
    }
    public Long getReportTypeID() {
        return reportTypeID;
    }

    public void setReportTypeID(Long reportTypeID) {
        this.reportTypeID = reportTypeID;
    }
    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    public int getRejections() {
        return rejections;
    }

    public void setRejections(int rejections) {
        this.rejections = rejections;
    }

    public int getConfirmations() {
        return confirmations;
    }

    public void setConfirmations(int confirmations) {
        this.confirmations = confirmations;
    }

    public int getThreatDegree() {
        return threatDegree;
    }

    public void setThreatDegree(int threatDegree) {
        this.threatDegree = threatDegree;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String nameDescription) {
        this.description = nameDescription;
    }

}
