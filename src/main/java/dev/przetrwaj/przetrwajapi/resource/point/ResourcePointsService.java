package dev.przetrwaj.przetrwajapi.resource.point;

import dev.przetrwaj.przetrwajapi.location.Location;
import dev.przetrwaj.przetrwajapi.location.LocationRepository;
import dev.przetrwaj.przetrwajapi.resource.Resource;
import dev.przetrwaj.przetrwajapi.resource.ResourceRepository;
import dev.przetrwaj.przetrwajapi.resource.type.ResourceTypes;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ResourcePointsService {
    private final ResourcePointRepository resourcePointsRepository;
    private final ResourceRepository resourcesRepository;
    private final LocationRepository locationRepository;

    public ResourcePointsService(ResourcePointRepository resourcePointsRepository, ResourceRepository resourcesRepository,
                                 LocationRepository locationRepository) {
        this.resourcePointsRepository = resourcePointsRepository;
        this.resourcesRepository = resourcesRepository;
        this.locationRepository = locationRepository;
    }

    public List<ResourcePoint> getAllResourcePoints(){
        return resourcePointsRepository.findAll();
    }
    public ResourcePoint addNewResourcePoints(ResourcePointDTO resourcePointDTO) {
        Long locationId = resourcePointDTO.getLocationId();
        String name = resourcePointDTO.getPointName();
        Location location = locationRepository.findById(locationId).orElse(null);

            return resourcePointsRepository.save(new ResourcePoint(name, location));

    }
    public Resource addResourceToPoint(Double quantity, ResourceTypes resourceType, ResourcePoint resourcePoint ) {

        return resourcesRepository.save(new Resource(quantity, resourceType, resourcePoint));
    }
}
