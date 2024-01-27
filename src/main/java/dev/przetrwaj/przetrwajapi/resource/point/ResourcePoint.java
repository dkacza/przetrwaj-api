package dev.przetrwaj.przetrwajapi.resource.point;

import dev.przetrwaj.przetrwajapi.location.Location;
import dev.przetrwaj.przetrwajapi.resource.Resources;
import jakarta.persistence.*;


import java.util.HashSet;
import java.util.Set;

@Entity(name = "ResourcePoints")
public class ResourcePoint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy="resourcePoint")
    private Set<Resources> resources;
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

    public Set<Resources> getResources() {
        return resources;
    }

    public void setResources(Set<Resources> resources) {
        this.resources = resources;
    }
    public ResourcePoint(){

    }
    public ResourcePoint(Long resourcePointId, String resourcePointName, Set<Resources> resources) {
        this.id = resourcePointId;
        this.name = resourcePointName;
        this.resources = resources;
    }

    /*
    ADD CONSTRUCTOR, GETTER, SETTER!!!
    */

    public ResourcePoint(String resourcePointName, Set<Resources> resources, Location location) {
        this.name = resourcePointName;
        this.resources = resources;
        this.location = location;
    }

    public ResourcePoint(String resourcePointName, Location location) {

        this.resources = new HashSet<Resources>();
        this.name = resourcePointName;
        this.location = location;
    }
}


