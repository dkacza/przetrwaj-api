package dev.przetrwaj.przetrwajapi.report.type;

import dev.przetrwaj.przetrwajapi.report.type.ReportType;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportTypeRepository extends ListCrudRepository<ReportType, Long> {
}
