package com.neobank.bill;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface AutoDebitAuthorizationRepository extends JpaRepository<AutoDebitAuthorization, UUID> {
    List<AutoDebitAuthorization> findByUserId(UUID userId);
    Optional<AutoDebitAuthorization> findByRecordKey(String recordKey);
    List<AutoDebitAuthorization> findByStatus(String status);
}
