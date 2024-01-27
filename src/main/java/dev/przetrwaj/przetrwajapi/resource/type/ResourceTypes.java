package dev.przetrwaj.przetrwajapi.resource.type;

import jakarta.persistence.*;

@Entity(name = "resource_types")
public class ResourceTypes{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @Enumerated(EnumType.STRING)
    private Units unit;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
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
        this.id = resourceTypeId;
        this.name = name;
        this.description = description;
        this.unit = unit;
    }
}