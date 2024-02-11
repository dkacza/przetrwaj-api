package dev.przetrwaj.przetrwajapi.resource.point;

import dev.przetrwaj.przetrwajapi.location.Location;
import dev.przetrwaj.przetrwajapi.resource.Resource;
import jakarta.persistence.*;
import org.jetbrains.annotations.NotNull;


import java.util.HashSet;
import java.util.Set;

@Entity(name = "resource_points")
public class ResourcePoint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String name;
    @NotNull
    @OneToMany(mappedBy="resourcePoint", cascade = CascadeType.ALL)
    private Set<Resource> resources;
    @NotNull
    @OneToOne
    @JoinColumn(
            unique = true
    )
    private Location location;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String resourcePointName) {
        this.name = resourcePointName;
    }
    public Set<Resource> getResources() {
        return resources;
    }
    public void setResources(Set<Resource> resources) {
        this.resources = resources;
    }

    public ResourcePoint(){

    }
    public ResourcePoint(Long resourcePointId, String resourcePointName, Set<Resource> resources) {
        this.id = resourcePointId;
        this.name = resourcePointName;
        this.resources = resources;
    }
    public ResourcePoint(String resourcePointName, Set<Resource> resources, Location location) {
        this.name = resourcePointName;
        this.resources = resources;
        this.location = location;
    }
    public ResourcePoint(String resourcePointName, Location location) {
        this.resources = new HashSet<Resource>();
        this.name = resourcePointName;
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}


