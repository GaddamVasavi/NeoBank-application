package com.neobank.kyc;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.UUID;
@Repository public interface KycDocumentRepository extends JpaRepository<KycDocument, UUID> {
    List<KycDocument> findByUserId(UUID userId);
    List<KycDocument> findByStatus(String status);
}
