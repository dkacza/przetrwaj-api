package dev.przetrwaj.przetrwajapi.report;

import dev.przetrwaj.przetrwajapi.location.Location;
import dev.przetrwaj.przetrwajapi.report.type.ReportType;
import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.Date;

@Entity(name = "reports")
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private Date date;
    @NotNull
    private String name;
    @NotNull
    private int rejections;
    @NotNull
    private int confirmations;
    @NotNull
    private int threatDegree;
    @NotNull
    private String description;
    @NotNull
    @OneToOne
    @JoinColumn(
            unique = true
    )
    private Location location;
    @NotNull
    @ManyToOne
    @JoinColumn(
            name = "report_type_id", nullable = false)
    private ReportType reportType;


    public Report() {
    }

    public Report(String name, int rejections, int confirmations, Location localisation,
                  ReportType reportType, int threatDegree, String description) {
        this.date = new Date();
        this.name = name;
        this.rejections = rejections;
        this.confirmations = confirmations;
        this.location = localisation;
        this.reportType = reportType;
        this.threatDegree = threatDegree;
        this.description = description;
    }

    public Report(String name, Location localisation, ReportType reportType,
                  int threatDegree, String description) {
        this.date = new Date();
        this.name = name;
        this.location = localisation;
        this.reportType = reportType;
        this.threatDegree = threatDegree;
        this.description = description;

        this.rejections = 0;
        this.confirmations = 0;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
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
    public String getDescription() {
        return description;
    }

    public void setDescription(String nameDescription) {
        this.description = nameDescription;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }


}
