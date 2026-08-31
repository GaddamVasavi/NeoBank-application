package com.neobank.settlement;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface Target2PaymentInstructionRepository extends JpaRepository<Target2PaymentInstruction, UUID> {
    List<Target2PaymentInstruction> findByUserId(UUID userId);
    Optional<Target2PaymentInstruction> findBySettlementRef(String ref);
    List<Target2PaymentInstruction> findByLifecycleStatus(String status);
}
