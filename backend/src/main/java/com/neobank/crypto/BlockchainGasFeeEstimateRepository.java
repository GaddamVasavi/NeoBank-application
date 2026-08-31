package com.neobank.crypto;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface BlockchainGasFeeEstimateRepository extends JpaRepository<BlockchainGasFeeEstimate, UUID> {
    List<BlockchainGasFeeEstimate> findByUserId(UUID userId);
    Optional<BlockchainGasFeeEstimate> findByAuthorityRef(String ref);
    List<BlockchainGasFeeEstimate> findBySubmissionStatus(String status);
}
