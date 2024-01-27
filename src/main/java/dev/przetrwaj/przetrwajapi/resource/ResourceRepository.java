package dev.przetrwaj.przetrwajapi.resource;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourceRepository extends ListCrudRepository<Resource, Long> {
}