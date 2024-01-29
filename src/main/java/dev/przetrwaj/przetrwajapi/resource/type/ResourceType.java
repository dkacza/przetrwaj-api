package dev.przetrwaj.przetrwajapi.resource.type;

import jakarta.persistence.*;
import org.jetbrains.annotations.NotNull;

@Entity(name = "resource_types")
public class ResourceType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String description;
    @NotNull
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

    public ResourceType() {
    }
    public ResourceType(String name, String description, Units unit) {
        this.name = name;
        this.description = description;
        this.unit = unit;
    }
}