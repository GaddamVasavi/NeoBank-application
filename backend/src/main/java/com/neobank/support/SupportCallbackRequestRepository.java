package com.neobank.support;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface SupportCallbackRequestRepository extends JpaRepository<SupportCallbackRequest, UUID> {
    List<SupportCallbackRequest> findByUserId(UUID userId);
    Optional<SupportCallbackRequest> findByRecordKey(String recordKey);
    List<SupportCallbackRequest> findByStatus(String status);
}
