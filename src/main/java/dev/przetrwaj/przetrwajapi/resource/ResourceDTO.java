package dev.przetrwaj.przetrwajapi.resource;

public class ResourceDTO {
    private Long resourceTypeId;
    private Long pointId;
    private Double quantity;

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }
    public ResourceDTO(Long resourceTypeId, Long pointId ) {
        this.resourceTypeId = resourceTypeId;
        this.pointId = pointId;
    }

    public Long getResourceTypeId() {
        return resourceTypeId;
    }

    public void setResourceTypeId(Long resourceTypeId) {
        this.resourceTypeId = resourceTypeId;
    }

    public Long getPointId() {
        return pointId;
    }

    public void setPointId(Long pointId) {
        this.pointId = pointId;
    }
}
