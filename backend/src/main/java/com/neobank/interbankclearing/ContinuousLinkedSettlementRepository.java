package com.neobank.interbankclearing;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface ContinuousLinkedSettlementRepository extends JpaRepository<ContinuousLinkedSettlement, UUID> {
    List<ContinuousLinkedSettlement> findByUserId(UUID userId);
    Optional<ContinuousLinkedSettlement> findByProtocolReference(String ref);
    List<ContinuousLinkedSettlement> findByOperationalState(String state);
}
