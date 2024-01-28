package dev.przetrwaj.przetrwajapi.location;

public class LocationDTO {
    private String address;
    private Double longitude;
    private Double latitude;

    public Location convertFromDTO(){
        return new Location (this.address, this.longitude, this.latitude);
    }

    public LocationDTO(String address, Double longitude, Double latitude) {
        this.address = address;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }
}
