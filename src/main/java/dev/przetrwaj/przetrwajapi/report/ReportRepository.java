package dev.przetrwaj.przetrwajapi.report;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ReportRepository extends ListCrudRepository<Report, Long> {
}
