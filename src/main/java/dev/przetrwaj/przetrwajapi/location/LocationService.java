package dev.przetrwaj.przetrwajapi.location;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LocationService {
    private final LocationRepository locationRepository;
    private final Double MINIMAL_DISTANCE = 1d;  //TODO: determine it

    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public List<Location> getAllLocations(){
        return locationRepository.findAll();
    }

    public Location addNewLocation(LocationDTO locationDTO) {
        Location newLocation = this.getLocation(locationDTO);
        locationRepository.save(newLocation);
        return newLocation;
    }

    private Location getLocation(LocationDTO locationDTO){
        Location result = null;
        List<Location> locations = locationRepository.findAll();
        for(Location location : locations){
            if(getDistance(location, locationDTO) < MINIMAL_DISTANCE){
                result = location;
            }
        }
        if(result == null){
            result = locationDTO.convertFromDTO();
        }
        return result;
    }

    private Double getDistance(Location location, LocationDTO locationDTO){
        return Math.abs(location.getLatitude() - locationDTO.getLatitude()) +
                Math.abs(location.getLongitude() - locationDTO.getLongitude());
    }

    //TODO: May be used in defferent files, TBD
    public List<Location> getLocationsInBounds(Double top, Double bottom, Double left, Double right){
        List<Location> source = locationRepository.findAll();
        List<Location> result = new ArrayList<Location>();
        for(Location location:source){
            if(this.locationIsInBounds(location, top, bottom, left, right)){
                result.add(location);
            }
        }
        return result;
    }
    private boolean locationIsInBounds(Location location, Double top, Double bottom, Double left, Double right){
        return (location.getLongitude() > left && location.getLongitude() < right & location.getLatitude() < top && location.getLatitude() > bottom);
    }
}
