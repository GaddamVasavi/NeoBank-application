package com.neobank.crypto;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface CrossChainBridgeSwapRepository extends JpaRepository<CrossChainBridgeSwap, UUID> {
    List<CrossChainBridgeSwap> findByUserId(UUID userId);
    Optional<CrossChainBridgeSwap> findByAuthorityRef(String ref);
    List<CrossChainBridgeSwap> findBySubmissionStatus(String status);
}
