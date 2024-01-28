package dev.przetrwaj.przetrwajapi.location;

import dev.przetrwaj.przetrwajapi.report.type.ReportType;
import dev.przetrwaj.przetrwajapi.report.type.ReportTypeDAO;
import dev.przetrwaj.przetrwajapi.report.type.ReportTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {
    private final LocationRepository locationRepository;
    private final Double MINIMAL_DISTANCE = 1d;

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
}
