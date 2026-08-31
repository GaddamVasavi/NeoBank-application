package com.neobank.settlement;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface DvPSettlementInstructionRepository extends JpaRepository<DvPSettlementInstruction, UUID> {
    List<DvPSettlementInstruction> findByUserId(UUID userId);
    Optional<DvPSettlementInstruction> findBySettlementRef(String ref);
    List<DvPSettlementInstruction> findByLifecycleStatus(String status);
}
