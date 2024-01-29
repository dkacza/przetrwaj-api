package dev.przetrwaj.przetrwajapi.location;

import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

@Entity(name = "locations")
public class Location
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String address;
    @NotNull
    private Double longitude;
    @NotNull
    private Double latitude;

    public Location(String address, Double longitude, Double latitude){
        this.address = address;
        this.longitude = longitude;
        this.latitude = latitude;
    }
    public Location() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String adress) {
        this.address = adress;
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
