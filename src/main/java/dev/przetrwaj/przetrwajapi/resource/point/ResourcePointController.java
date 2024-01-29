package dev.przetrwaj.przetrwajapi.resource.point;

import dev.przetrwaj.przetrwajapi.resource.Resource;
import dev.przetrwaj.przetrwajapi.resource.ResourceDTO;
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
    @GetMapping("/getResByLoc")
    public List<ResourcePoint> getResourcePointsByLocation(@RequestBody CoordinatesDTO coordinatesDTO){
        return resourcePointsService.getResourcePointsByLocation(coordinatesDTO);
    }
    @PostMapping
    public ResourcePoint addResourcePoints(@RequestBody ResourcePointDTO resourcePointDTO){
        return resourcePointsService.addNewResourcePoints(resourcePointDTO);
    }
    @PostMapping("/addResource")
    public Resource addResourceToPoint(@RequestBody ResourceDTO resourceDTO){
        return resourcePointsService.addResourceToPoint(resourceDTO);
    }

}