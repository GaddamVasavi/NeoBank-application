package com.neobank.kyc;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface KycDocumentArchiveRepository extends JpaRepository<KycDocumentArchive, UUID> {
    List<KycDocumentArchive> findByUserId(UUID userId);
    Optional<KycDocumentArchive> findByRecordKey(String recordKey);
    List<KycDocumentArchive> findByStatus(String status);
}
