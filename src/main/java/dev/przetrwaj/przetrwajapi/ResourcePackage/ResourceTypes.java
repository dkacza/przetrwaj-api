package dev.przetrwaj.przetrwajapi.ResourcePackage;

import jakarta.persistence.*;

@Entity(name = "ResourceTypes")
public class ResourceTypes{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long resourceTypeId;

    private String name;

    private String description;

    @Enumerated(EnumType.STRING)
    private Units unit;

    /*
    @ManyToMany
    private Set<ReportType> reportTypes;

    ADD CONSTRUCTOR, GETTER, SETTER!!!
    */
    public Long getResourceTypeId() {
        return resourceTypeId;
    }

    public void setResourceTypeId(Long id) {
        this.resourceTypeId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Units getUnit() {
        return unit;
    }

    public void setUnit(Units unit) {
        this.unit = unit;
    }

    public ResourceTypes() {
    }

    public ResourceTypes(Long resourceTypeId, String name, String description, Units unit) {
        this.resourceTypeId = resourceTypeId;
        this.name = name;
        this.description = description;
        this.unit = unit;
    }
}