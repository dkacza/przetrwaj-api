package dev.przetrwaj.przetrwajapi.report;

import org.springframework.data.repository.ListCrudRepository;

import java.util.Optional;

public interface ReportRepository extends ListCrudRepository<Report, Long> {
}
