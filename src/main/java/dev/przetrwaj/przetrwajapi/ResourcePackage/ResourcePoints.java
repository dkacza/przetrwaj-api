package dev.przetrwaj.przetrwajapi.ResourcePackage;

import dev.przetrwaj.przetrwajapi.Localisation.Localisation;
import jakarta.persistence.*;


import java.util.Set;

@Entity(name = "ResourcePoints")
public class ResourcePoints {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long resourcePointId;

    private String resourcePointName;

    @OneToMany(mappedBy="resourcePoint")
    private Set<Resources> resources;
    @OneToOne
    @JoinColumn(
            unique = true
    )
    private Localisation location;

    public Long getResourcePointId() {
        return resourcePointId;
    }

    public void setResourcePointId(Long id) {
        this.resourcePointId = id;
    }

    public String getResourcePointName() {
        return resourcePointName;
    }

    public void setResourcePointName(String resourcePointName) {
        this.resourcePointName = resourcePointName;
    }

    public Set<Resources> getResources() {
        return resources;
    }

    public void setResources(Set<Resources> resources) {
        this.resources = resources;
    }
    public ResourcePoints(){

    }
    public ResourcePoints(Long resourcePointId, String resourcePointName, Set<Resources> resources) {
        this.resourcePointId = resourcePointId;
        this.resourcePointName = resourcePointName;
        this.resources = resources;
    }

    /*
    ADD CONSTRUCTOR, GETTER, SETTER!!!
    */
}


