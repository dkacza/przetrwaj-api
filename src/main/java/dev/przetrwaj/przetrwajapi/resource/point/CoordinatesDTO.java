package dev.przetrwaj.przetrwajapi.resource.point;

public class CoordinatesDTO {

    private Double latitudeLowerBoundry;
    private Double latitudeUpperBoundry;
    private Double longitudeLowerBoundry;
    private Double longitudeUpperBoundry;

    public CoordinatesDTO(Double latitudeLowerBoundry, Double latitudeUpperBoundry, Double longitudeLowerBoundry, Double longitudeUpperBoundry) {
        this.latitudeLowerBoundry = latitudeLowerBoundry;
        this.latitudeUpperBoundry = latitudeUpperBoundry;
        this.longitudeLowerBoundry = longitudeLowerBoundry;
        this.longitudeUpperBoundry = longitudeUpperBoundry;
    }

    public Double getLatitudeLowerBoundry() {
        return latitudeLowerBoundry;
    }

    public void setLatitudeLowerBoundry(Double latitudeLowerBoundry) {
        this.latitudeLowerBoundry = latitudeLowerBoundry;
    }

    public Double getLatitudeUpperBoundry() {
        return latitudeUpperBoundry;
    }

    public void setLatitudeUpperBoundry(Double latitudeUpperBoundry) {
        this.latitudeUpperBoundry = latitudeUpperBoundry;
    }

    public Double getLongitudeLowerBoundry() {
        return longitudeLowerBoundry;
    }

    public void setLongitudeLowerBoundry(Double longitudeLowerBoundry) {
        this.longitudeLowerBoundry = longitudeLowerBoundry;
    }

    public Double getLongitudeUpperBoundry() {
        return longitudeUpperBoundry;
    }

    public void setLongitudeUpperBoundry(Double longitudeUpperBoundry) {
        this.longitudeUpperBoundry = longitudeUpperBoundry;
    }
}
