package dev.przetrwaj.przetrwajapi.report;

import dev.przetrwaj.przetrwajapi.Localisation.Localisation;
import jakarta.persistence.*;

import java.util.Date;

@Entity(name = "Report")
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    private int rejections;
    private int confirmations;
    @OneToOne
    @JoinColumn(
            unique = true
    )
    private Localisation localisation;
    @ManyToOne
    @JoinColumn(
            name = "ReportTypeId", nullable = false)
    private ReportType reportType;

    private int threatDegree;

    private String nameDescription;

    private String reportDescription;

    public Report() {
    }

    public java.util.Date getDate() {
        return date;
    }

    public void setDate(java.util.Date date) {
        this.date = date;
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

    public ReportType getReportType() {
        return reportType;
    }

    public void setReportType(ReportType reportType) {
        this.reportType = reportType;
    }

    public int getThreatDegree() {
        return threatDegree;
    }

    public void setThreatDegree(int threatDegree) {
        this.threatDegree = threatDegree;
    }
    public String getNameDescription() {
        return nameDescription;
    }

    public void setNameDescription(String nameDescription) {
        this.nameDescription = nameDescription;
    }

    public String getReportDescription() {
        return reportDescription;
    }

    public void setReportDescription(String reportDescription) {
        this.reportDescription = reportDescription;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }


}
