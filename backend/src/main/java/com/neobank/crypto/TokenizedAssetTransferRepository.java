package com.neobank.crypto;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface TokenizedAssetTransferRepository extends JpaRepository<TokenizedAssetTransfer, UUID> {
    List<TokenizedAssetTransfer> findByUserId(UUID userId);
    Optional<TokenizedAssetTransfer> findByAuthorityRef(String ref);
    List<TokenizedAssetTransfer> findBySubmissionStatus(String status);
}
