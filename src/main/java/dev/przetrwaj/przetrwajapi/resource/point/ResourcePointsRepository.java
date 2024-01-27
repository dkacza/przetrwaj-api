package dev.przetrwaj.przetrwajapi.resource.point;

import dev.przetrwaj.przetrwajapi.resource.point.ResourcePoint;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourcePointsRepository extends ListCrudRepository<ResourcePoint, Long> {
}
