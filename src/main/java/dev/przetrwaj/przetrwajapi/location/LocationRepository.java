package dev.przetrwaj.przetrwajapi.location;

import dev.przetrwaj.przetrwajapi.report.type.ReportType;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends ListCrudRepository<Location, Long> {
}
