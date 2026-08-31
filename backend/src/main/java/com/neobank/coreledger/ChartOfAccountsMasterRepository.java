package com.neobank.coreledger;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface ChartOfAccountsMasterRepository extends JpaRepository<ChartOfAccountsMaster, UUID> {
    List<ChartOfAccountsMaster> findByUserId(UUID userId);
    Optional<ChartOfAccountsMaster> findByCoreReference(String ref);
    List<ChartOfAccountsMaster> findByProcessingStatus(String status);
}
