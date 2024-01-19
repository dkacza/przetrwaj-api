package dev.przetrwaj.przetrwajapi.ResourcePackage;

import jakarta.persistence.*;

@Entity(name = "Resources")
public class Resources{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long resourceId;

    private Double quantity;

    @OneToOne
    @JoinColumn(
            unique = true
    )
    private ResourceTypes resourceType;

    @ManyToOne
    @JoinColumn(name="resourcePointId", nullable=false)
    private ResourcePoints resourcePoint;

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

    public Resources(){

    }
    public Resources(Long resourceId, Double quantity, ResourceTypes resourceType) {
        this.resourceId = resourceId;
        this.quantity = quantity;
        this.resourceType = resourceType;
    }
}