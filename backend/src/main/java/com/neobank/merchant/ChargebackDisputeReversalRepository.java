package com.neobank.merchant;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface ChargebackDisputeReversalRepository extends JpaRepository<ChargebackDisputeReversal, UUID> {
    List<ChargebackDisputeReversal> findByUserId(UUID userId);
    Optional<ChargebackDisputeReversal> findByCoreReference(String ref);
    List<ChargebackDisputeReversal> findByProcessingStatus(String status);
}
