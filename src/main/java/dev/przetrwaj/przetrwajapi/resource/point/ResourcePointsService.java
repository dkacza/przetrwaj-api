package dev.przetrwaj.przetrwajapi.resource.point;

import dev.przetrwaj.przetrwajapi.location.Location;
import dev.przetrwaj.przetrwajapi.resource.Resource;
import dev.przetrwaj.przetrwajapi.resource.ResourceRepository;
import dev.przetrwaj.przetrwajapi.resource.type.ResourceTypes;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ResourcePointsService {
    private final ResourcePointRepository resourcePointsRepository;
    private final ResourceRepository resourcesRepository;

    public ResourcePointsService(ResourcePointRepository resourcePointsRepository, ResourceRepository resourcesRepository) {
        this.resourcePointsRepository = resourcePointsRepository;
        this.resourcesRepository = resourcesRepository;
    }

    public List<ResourcePoint> getAllResourcePoints(){
        return resourcePointsRepository.findAll();
    }
    public ResourcePoint addNewResourcePoints(String name, Location location ) {

        return resourcePointsRepository.save(new ResourcePoint(name,location));
    }
    public Resource addResourceToPoint(Double quantity, ResourceTypes resourceType, ResourcePoint resourcePoint ) {

        return resourcesRepository.save(new Resource(quantity, resourceType, resourcePoint));
    }
}
