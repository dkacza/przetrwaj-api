package dev.przetrwaj.przetrwajapi.ResourcePackage;

import dev.przetrwaj.przetrwajapi.Localisation.Localisation;
import dev.przetrwaj.przetrwajapi.report.Report;
import dev.przetrwaj.przetrwajapi.report.ReportRepository;
import dev.przetrwaj.przetrwajapi.report.ReportType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.*;

@Service
public class ResourcePointsService {

    private final ResourcePointsRepository resourcePointsRepository;
    private final ResourcesRepository resourcesRepository;

    public ResourcePointsService(ResourcePointsRepository resourcePointsRepository, ResourcesRepository resourcesRepository) {
        this.resourcePointsRepository = resourcePointsRepository;
        this.resourcesRepository = resourcesRepository;
    }

    public List<ResourcePoints> getAllResourcePoints(){
        return resourcePointsRepository.findAll();
    }

    public ResourcePoints addNewResourcePoints(String name, Localisation location ) {

        return resourcePointsRepository.save(new ResourcePoints(name,location));
    }
    public Resources addResourceToPoint(Double quantity, ResourceTypes resourceType, ResourcePoints resourcePoint ) {

        return resourcesRepository.save(new Resources(quantity, resourceType, resourcePoint));
    }
}
