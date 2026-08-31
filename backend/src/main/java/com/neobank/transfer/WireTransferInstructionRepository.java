package com.neobank.transfer;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface WireTransferInstructionRepository extends JpaRepository<WireTransferInstruction, UUID> {
    List<WireTransferInstruction> findBySourceAccountId(UUID accountId);
    Optional<WireTransferInstruction> findByTrackingNumber(String trackingNumber);
    List<WireTransferInstruction> findByStatus(String status);
}
