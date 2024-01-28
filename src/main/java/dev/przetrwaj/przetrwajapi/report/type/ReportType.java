package dev.przetrwaj.przetrwajapi.report.type;

import dev.przetrwaj.przetrwajapi.resource.type.ResourceTypes;
import jakarta.persistence.*;

import java.util.List;


@Entity(name = "report_types")
public class ReportType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String typeName;
    private String typeDescription;
    @ManyToMany
    @JoinTable(name = "resources_for_report_type")
    private List<ResourceTypes> recommendedResources;

    public ReportType() {}
    public ReportType(String typeName, String typeDescription) {
        this.typeName = typeName;
        this.typeDescription = typeDescription;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }
    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
    public String getTypeName() {
        return typeName;
    }
    public String getTypeDescription() {
        return typeDescription;
    }
    public void setTypeDescription(String typeDescription) {
        this.typeDescription = typeDescription;
    }
    public ReportTypeDTO convertToDTO() {
        return new ReportTypeDTO(this.typeName, this.typeDescription);
    }
}