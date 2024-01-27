package dev.przetrwaj.przetrwajapi.resource.point;

import dev.przetrwaj.przetrwajapi.location.Location;
import dev.przetrwaj.przetrwajapi.resource.Resource;
import dev.przetrwaj.przetrwajapi.resource.type.ResourceTypes;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/resourcePoint")
public class ResourcePointController {
    private final ResourcePointsService resourcePointsService;
    public ResourcePointController(ResourcePointsService resourcePointsService) {
        this.resourcePointsService = resourcePointsService;
    }

    @GetMapping
    public List<ResourcePoint> getAllResourcePoints(){
        return resourcePointsService.getAllResourcePoints();
    }
    @PostMapping
    public ResourcePoint addResourcePoints(@RequestBody String name, @RequestBody Location location){
        return resourcePointsService.addNewResourcePoints(name, location);
    }
    @PostMapping("/addResource")
    public Resource addResourceToPoint(@RequestBody Double quantity, @RequestBody ResourceTypes resourceType, @RequestBody ResourcePoint resourcePoint){
        return resourcePointsService.addResourceToPoint(quantity, resourceType, resourcePoint);
    }
}