package dev.przetrwaj.przetrwajapi.report;

import dev.przetrwaj.przetrwajapi.ResourcePackage.ResourceTypes;
import jakarta.persistence.*;

import java.util.List;
import java.util.Set;


@Entity(name = "ReportType")
public class ReportType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String typeName;
    private String typeDescription;
    @OneToMany(mappedBy="id")
    private Set<Report> report;
    @ManyToMany
    @JoinTable(name = "ResourceTypes")
    private List<ResourceTypes> recommendedSources;

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
    public ReportTypeDAO convertToDAO() {
        return new ReportTypeDAO(this.typeName, this.typeDescription);
    }
}
