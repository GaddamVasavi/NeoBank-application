package com.neobank.merchant;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface VirtualTerminalTransactionRepository extends JpaRepository<VirtualTerminalTransaction, UUID> {
    List<VirtualTerminalTransaction> findByUserId(UUID userId);
    Optional<VirtualTerminalTransaction> findByCoreReference(String ref);
    List<VirtualTerminalTransaction> findByProcessingStatus(String status);
}
