package dev.przetrwaj.przetrwajapi.resource.point;

public class ResourcePointDTO {
    private String pointName;
    private Long locationId;

    public ResourcePointDTO(String pointName, Long locationId ) {
        this.pointName = pointName;
        this.locationId = locationId;
    }

    public String getPointName() {
        return pointName;
    }
    public void setPointName(String pointName) {
        this.pointName = pointName;
    }
    public Long getLocationId() {
        return locationId;
    }
    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

}
