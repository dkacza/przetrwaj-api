package dev.przetrwaj.przetrwajapi.resource.point;

import dev.przetrwaj.przetrwajapi.resource.Resource;
import dev.przetrwaj.przetrwajapi.resource.ResourceDTO;
import dev.przetrwaj.przetrwajapi.resource.ResourceQuantityDTO;
import dev.przetrwaj.przetrwajapi.resource.type.ResourceType;
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
    @PostMapping("/getResByLoc")
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
    @PostMapping("/removeResource")
    public void removeResource(@RequestBody Long resourceId){
        resourcePointsService.removeResource(resourceId);
    }
    @PostMapping("/removeResourcePoint")
    public void removeResourcePoint(@RequestBody Long resourcePointId){
        resourcePointsService.removeResourcePoint(resourcePointId);
    }
    @PostMapping("/changeResQuantity")
    public Resource changeResourceQuantity(@RequestBody ResourceQuantityDTO resourceQuantityDTO){
        return resourcePointsService.changeResourceQuantity(resourceQuantityDTO);
    }
    @GetMapping("/getResType")
    public List<ResourceType> getAllResourceTypes(){
        return resourcePointsService.getAllResourceTypes();
    }

}