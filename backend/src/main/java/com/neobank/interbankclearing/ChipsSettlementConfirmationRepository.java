package com.neobank.interbankclearing;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface ChipsSettlementConfirmationRepository extends JpaRepository<ChipsSettlementConfirmation, UUID> {
    List<ChipsSettlementConfirmation> findByUserId(UUID userId);
    Optional<ChipsSettlementConfirmation> findByProtocolReference(String ref);
    List<ChipsSettlementConfirmation> findByOperationalState(String state);
}
