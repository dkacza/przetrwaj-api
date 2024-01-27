package dev.przetrwaj.przetrwajapi.resource.point;

import dev.przetrwaj.przetrwajapi.location.Location;
import dev.przetrwaj.przetrwajapi.resource.Resources;
import dev.przetrwaj.przetrwajapi.resource.ResourcesRepository;
import dev.przetrwaj.przetrwajapi.resource.point.ResourcePoint;
import dev.przetrwaj.przetrwajapi.resource.point.ResourcePointsRepository;
import dev.przetrwaj.przetrwajapi.resource.type.ResourceTypes;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ResourcePointsService {

    private final ResourcePointsRepository resourcePointsRepository;
    private final ResourcesRepository resourcesRepository;

    public ResourcePointsService(ResourcePointsRepository resourcePointsRepository, ResourcesRepository resourcesRepository) {
        this.resourcePointsRepository = resourcePointsRepository;
        this.resourcesRepository = resourcesRepository;
    }

    public List<ResourcePoint> getAllResourcePoints(){
        return resourcePointsRepository.findAll();
    }

    public ResourcePoint addNewResourcePoints(String name, Location location ) {

        return resourcePointsRepository.save(new ResourcePoint(name,location));
    }
    public Resources addResourceToPoint(Double quantity, ResourceTypes resourceType, ResourcePoint resourcePoint ) {

        return resourcesRepository.save(new Resources(quantity, resourceType, resourcePoint));
    }
}
