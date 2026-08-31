package com.neobank.corepayments;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface Iso20022Pacs008MessageRecordRepository extends JpaRepository<Iso20022Pacs008MessageRecord, UUID> {
    List<Iso20022Pacs008MessageRecord> findByUserId(UUID userId);
    Optional<Iso20022Pacs008MessageRecord> findByClearingKey(String key);
    List<Iso20022Pacs008MessageRecord> findByAuditStatus(String status);
}
