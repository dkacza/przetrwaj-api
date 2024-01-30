package dev.przetrwaj.przetrwajapi.resource.point;

import dev.przetrwaj.przetrwajapi.location.Location;
import dev.przetrwaj.przetrwajapi.location.LocationRepository;
import dev.przetrwaj.przetrwajapi.resource.Resource;
import dev.przetrwaj.przetrwajapi.resource.ResourceDTO;
import dev.przetrwaj.przetrwajapi.resource.ResourceQuantityDTO;
import dev.przetrwaj.przetrwajapi.resource.ResourceRepository;
import dev.przetrwaj.przetrwajapi.resource.type.ResourceTypeRepository;
import dev.przetrwaj.przetrwajapi.resource.type.ResourceType;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ResourcePointsService {
    private final ResourcePointRepository resourcePointsRepository;
    private final ResourceRepository resourcesRepository;
    private final LocationRepository locationRepository;
    private final ResourceTypeRepository resourceTypeRepository;

    public ResourcePointsService(ResourcePointRepository resourcePointsRepository, ResourceRepository resourcesRepository,
                                 LocationRepository locationRepository, ResourceTypeRepository resourceTypeRepository) {
        this.resourcePointsRepository = resourcePointsRepository;
        this.resourcesRepository = resourcesRepository;
        this.locationRepository = locationRepository;
        this.resourceTypeRepository = resourceTypeRepository;
    }

    public List<ResourcePoint> getAllResourcePoints(){
        return resourcePointsRepository.findAll();
    }
    public List<ResourcePoint> getResourcePointsByLocation(CoordinatesDTO coordinatesDTO){
        List <ResourcePoint> allPoints = resourcePointsRepository.findAll();
        List <ResourcePoint> visiblePoints = new ArrayList<>();
        for(ResourcePoint rp : allPoints){
            if(locationIsInBounds(rp.getLocation(),coordinatesDTO.getLatitudeUpperBoundry(),
                                  coordinatesDTO.getLatitudeLowerBoundry(),coordinatesDTO.getLongitudeLowerBoundry(),
                                  coordinatesDTO.getLongitudeUpperBoundry()))
            {
                visiblePoints.add(rp);
            }
        }
        return visiblePoints;
    }
    public ResourcePoint addNewResourcePoints(ResourcePointDTO resourcePointDTO) {
        Long locationId = resourcePointDTO.getLocationId();
        String name = resourcePointDTO.getPointName();
        Location location = locationRepository.findById(locationId).orElse(null);

            return resourcePointsRepository.save(new ResourcePoint(name, location));

    }
    public Resource addResourceToPoint(ResourceDTO resourceDTO) {
        Double quantity = resourceDTO.getQuantity();
        ResourcePoint resourcePoint = resourcePointsRepository.findById(resourceDTO.getPointId()).orElse(null);
        ResourceType resourceType = resourceTypeRepository.findById(resourceDTO.getResourceTypeId()).orElse(null);

        return resourcesRepository.save(new Resource(quantity, resourceType, resourcePoint));
    }
    public Resource changeResourceQuantity(ResourceQuantityDTO resourceQuantityDTO){
        Resource res = resourcesRepository.findById(resourceQuantityDTO.getResourceId()).orElse(null);
        if (res != null) {
            res.setQuantity(res.getQuantity() + resourceQuantityDTO.getQuantityDelta());
            return resourcesRepository.save(res);
        }
        else { return null; }
    }
    public void removeResource(Long resourceId){
        resourcesRepository.deleteById(resourceId);
    }
    public void removeResourcePoint(Long resourcePointId){
        resourcePointsRepository.deleteById(resourcePointId);
    }
    private boolean locationIsInBounds(Location location, Double top, Double bottom, Double left, Double right){
        return (location.getLongitude() > left && location.getLongitude() < right & location.getLatitude() < top && location.getLatitude() > bottom);
    }
}
