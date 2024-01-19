package dev.przetrwaj.przetrwajapi.report;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;

import java.util.Set;


@Entity(name = "ReportType")
public class ReportType {

    @Id
    private Long id;

    public String getType_name() {
        return type_name;
    }

    @OneToMany(mappedBy="id")
    private Set<Report> report;
    public void setType_name(String type_name) {
        this.type_name = type_name;
    }

    public String getType_description() {
        return type_description;
    }

    public void setType_description(String type_description) {
        this.type_description = type_description;
    }

    private String type_name;
    private String type_description;

    public ReportType() {
    }
    //@ManyToMany
    //@JoinTable(
            //name = "ResourceTypes";
            //)
   // private List<ResourceTypes> recommended_sources;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
