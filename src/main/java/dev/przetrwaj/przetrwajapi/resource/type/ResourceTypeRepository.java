package dev.przetrwaj.przetrwajapi.resource.type;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourceTypeRepository extends ListCrudRepository<ResourceTypes, Long> {
}