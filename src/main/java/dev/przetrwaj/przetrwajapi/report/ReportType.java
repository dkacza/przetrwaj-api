package dev.przetrwaj.przetrwajapi.report;

import dev.przetrwaj.przetrwajapi.ResourcePackage.ResourceTypes;
import jakarta.persistence.*;

import java.util.List;
import java.util.Set;


@Entity(name = "ReportType")
public class ReportType {

    @Id
    private Long id;

    public ReportType(String typeName, String typeDescription) {
        this.typeName = typeName;
        this.typeDescription = typeDescription;
    }

    public String getTypeName() {
        return typeName;
    }

    @OneToMany(mappedBy="id")
    private Set<Report> report;
    private String typeName;
    private String typeDescription;
    public ReportType() {}
    @ManyToMany
    @JoinTable(name = "ResourceTypes")
    private List<ResourceTypes> recommendedSources;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeDescription() {
        return typeDescription;
    }

    public void setTypeDescription(String typeDescription) {
        this.typeDescription = typeDescription;
    }
}
