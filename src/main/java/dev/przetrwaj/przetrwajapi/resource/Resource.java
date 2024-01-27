package dev.przetrwaj.przetrwajapi.resource;

import dev.przetrwaj.przetrwajapi.resource.point.ResourcePoint;
import dev.przetrwaj.przetrwajapi.resource.type.ResourceTypes;
import jakarta.persistence.*;

@Entity(name = "resources")
public class Resource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long resourceId;
    private Double quantity;
    @ManyToOne
    @JoinColumn(
            unique = true
    )
    private ResourceTypes resourceType;
    @ManyToOne
    @JoinColumn(name="resourcePointId", nullable=false)
    private ResourcePoint resourcePoint;

    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long id) {
        this.resourceId = id;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public ResourceTypes getResourceType() {
        return resourceType;
    }

    public void setResourceType(ResourceTypes resourceType) {
        this.resourceType = resourceType;
    }

    public Resource(){

    }
    public Resource(Double quantity, ResourceTypes resourceType, ResourcePoint resourcePoint) {

        this.quantity = quantity;
        this.resourceType = resourceType;
        this.resourcePoint = resourcePoint;
    }
}