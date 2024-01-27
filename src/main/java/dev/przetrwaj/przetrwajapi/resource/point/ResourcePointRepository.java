package dev.przetrwaj.przetrwajapi.resource.point;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourcePointRepository extends ListCrudRepository<ResourcePoint, Long> {
}
