package dev.przetrwaj.przetrwajapi.resource;

public class ResourceQuantityDTO {

    private Long resourceId;
    private Double quantityDelta;

    public ResourceQuantityDTO(Long resourceId, Double quantityDelta) {
        this.resourceId = resourceId;
        this.quantityDelta = quantityDelta;
    }

    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }

    public Double getQuantityDelta() {
        return quantityDelta;
    }

    public void setQuantityDelta(Double quantityDelta) {
        this.quantityDelta = quantityDelta;
    }
}
