package dev.przetrwaj.przetrwajapi.resource.type;

import org.springframework.stereotype.Service;

@Service
public class ResourceTypeService {

    private final ResourceTypeRepository resourceTypeRepository;

    public ResourceTypeService(ResourceTypeRepository resourceTypeRepository) {
        this.resourceTypeRepository = resourceTypeRepository;
    }
    public void addResourceType(ResourceType resourceType){
        resourceTypeRepository.save(resourceType);
    }
}
