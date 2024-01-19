package dev.przetrwaj.przetrwajapi.Localisation;

import dev.przetrwaj.przetrwajapi.ResourcePackage.ResourcePoints;
import dev.przetrwaj.przetrwajapi.report.Report;
import jakarta.persistence.*;

@Entity(name = "Localisation")
public class Localisation
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(
            unique = true
    )
    private Report report;
    @OneToOne
    @JoinColumn(
            unique = true
    )
    private ResourcePoints resourcePoints;
    private String adress;
    private Double longitude; //Długość geograficzna
    private Double latitude; //Szerokośc geograficzna
    public Localisation(String adress, Double longitude, Double latitude){
        this.adress = adress;
        this.longitude = longitude;
        this.latitude = latitude;
    }
    public Localisation(){}
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
