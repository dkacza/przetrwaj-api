package dev.przetrwaj.przetrwajapi.resource;

import dev.przetrwaj.przetrwajapi.resource.point.ResourcePoint;
import dev.przetrwaj.przetrwajapi.resource.type.ResourceType;
import jakarta.persistence.*;
import org.jetbrains.annotations.NotNull;

@Entity(name = "resources")
public class Resource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long resourceId;
    @NotNull
    private Double quantity;
    @NotNull
    @ManyToOne
    @JoinColumn(
            unique = true
    )
    private ResourceType resourceType;
    @NotNull
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

    public ResourceType getResourceType() {
        return resourceType;
    }

    public void setResourceType(ResourceType resourceType) {
        this.resourceType = resourceType;
    }

    public Resource(){

    }
    public Resource(Double quantity, ResourceType resourceType, ResourcePoint resourcePoint) {

        this.quantity = quantity;
        this.resourceType = resourceType;
        this.resourcePoint = resourcePoint;
    }
}