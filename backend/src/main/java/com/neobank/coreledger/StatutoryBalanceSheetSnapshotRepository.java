package com.neobank.coreledger;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface StatutoryBalanceSheetSnapshotRepository extends JpaRepository<StatutoryBalanceSheetSnapshot, UUID> {
    List<StatutoryBalanceSheetSnapshot> findByUserId(UUID userId);
    Optional<StatutoryBalanceSheetSnapshot> findByCoreReference(String ref);
    List<StatutoryBalanceSheetSnapshot> findByProcessingStatus(String status);
}
