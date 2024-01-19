package dev.przetrwaj.przetrwajapi.Localisation;

import dev.przetrwaj.przetrwajapi.user.User;
import org.springframework.data.repository.ListCrudRepository;

import java.util.Optional;

public interface LocalisationRepository extends ListCrudRepository<Localisation, Long> {
}
