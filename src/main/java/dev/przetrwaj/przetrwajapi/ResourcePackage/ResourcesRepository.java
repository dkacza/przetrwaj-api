package dev.przetrwaj.przetrwajapi.ResourcePackage;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ResourcesRepository extends ListCrudRepository<Resources, Long> {
}