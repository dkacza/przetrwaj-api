package dev.przetrwaj.przetrwajapi.location;

import jakarta.persistence.*;

@Entity(name = "locations")
public class Location
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String adress;
    private Double longitude; //Długość geograficzna
    private Double latitude; //Szerokość geograficzna

    public Location(String adress, Double longitude, Double latitude){
        this.adress = adress;
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
    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
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
