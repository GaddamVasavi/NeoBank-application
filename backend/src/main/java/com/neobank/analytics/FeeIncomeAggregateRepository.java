package com.neobank.analytics;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface FeeIncomeAggregateRepository extends JpaRepository<FeeIncomeAggregate, UUID> {
    List<FeeIncomeAggregate> findByUserId(UUID userId);
    Optional<FeeIncomeAggregate> findByRecordKey(String recordKey);
    List<FeeIncomeAggregate> findByStatus(String status);
}
