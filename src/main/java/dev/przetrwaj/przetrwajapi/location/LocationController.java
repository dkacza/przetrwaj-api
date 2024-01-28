package dev.przetrwaj.przetrwajapi.location;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/location")
public class LocationController {
    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping
    public List<Location> gatAllLocations(){
        return locationService.getAllLocations();
    }
    @PostMapping
    public Location addLocation(@RequestBody LocationDTO locationDTO){
        return locationService.addNewLocation(locationDTO);
    }
}
