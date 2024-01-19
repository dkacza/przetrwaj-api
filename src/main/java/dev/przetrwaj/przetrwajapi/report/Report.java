package dev.przetrwaj.przetrwajapi.report;

import dev.przetrwaj.przetrwajapi.Localisation.Localisation;
import jakarta.persistence.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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
    private ReportType report_type;

    private int threat_degree;

    private String name_description;

    private String report_description;

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
        return report_type;
    }

    public void setReportType(ReportType report_type) {
        this.report_type = report_type;
    }

    public int getThreatDegree() {
        return threat_degree;
    }

    public void setThreatDegree(int threat_degree) {
        this.threat_degree = threat_degree;
    }
    public String getNameDescription() {
        return name_description;
    }

    public void setNameDescription(String name_description) {
        this.name_description = name_description;
    }

    public String getReportDescription() {
        return report_description;
    }

    public void setReportDescription(String report_description) {
        this.report_description = report_description;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }


}
