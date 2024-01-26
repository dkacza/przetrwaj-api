package dev.przetrwaj.przetrwajapi.ResourcePackage;

import dev.przetrwaj.przetrwajapi.Localisation.Localisation;
import dev.przetrwaj.przetrwajapi.report.Report;
import dev.przetrwaj.przetrwajapi.report.ReportService;
import dev.przetrwaj.przetrwajapi.report.ReportType;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1/resourcePoint")
public class ResourcePointsController {

    private final ResourcePointsService resourcePointsService;

    public ResourcePointsController(ResourcePointsService resourcePointsService) {

        this.resourcePointsService = resourcePointsService;
    }
    @GetMapping
    public List<ResourcePoints> getAllResourcePoints(){
        return resourcePointsService.getAllResourcePoints();
    }

    @PostMapping
    public ResourcePoints addResourcePoints(@RequestBody String name, @RequestBody Localisation location){
        return resourcePointsService.addNewResourcePoints(name, location);
    }
    @PostMapping("/addResource")
    public Resources addResourceToPoint(@RequestBody Double quantity, @RequestBody ResourceTypes resourceType, @RequestBody ResourcePoints resourcePoint){
        return resourcePointsService.addResourceToPoint(quantity, resourceType, resourcePoint);
    }
}