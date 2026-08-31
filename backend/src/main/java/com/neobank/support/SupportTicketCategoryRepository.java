package com.neobank.support;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface SupportTicketCategoryRepository extends JpaRepository<SupportTicketCategory, UUID> {
    List<SupportTicketCategory> findByUserId(UUID userId);
    Optional<SupportTicketCategory> findByRecordKey(String recordKey);
    List<SupportTicketCategory> findByStatus(String status);
}
