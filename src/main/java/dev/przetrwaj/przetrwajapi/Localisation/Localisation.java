package dev.przetrwaj.przetrwajapi.Localisation;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "users")
public class Localisation
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String adress;
    private Double longitude; //Długość geograficzna
    private Double latitude; //Szerokośc geograficzna
}
