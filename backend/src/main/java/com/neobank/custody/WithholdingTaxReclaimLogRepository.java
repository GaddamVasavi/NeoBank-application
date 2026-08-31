package com.neobank.custody;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface WithholdingTaxReclaimLogRepository extends JpaRepository<WithholdingTaxReclaimLog, UUID> {
    List<WithholdingTaxReclaimLog> findByUserId(UUID userId);
    Optional<WithholdingTaxReclaimLog> findBySettlementRef(String ref);
    List<WithholdingTaxReclaimLog> findByLifecycleStatus(String status);
}
