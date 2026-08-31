package com.neobank.clearing;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface ClearingBrokerAgreementRecordRepository extends JpaRepository<ClearingBrokerAgreementRecord, UUID> {
    List<ClearingBrokerAgreementRecord> findByUserId(UUID userId);
    Optional<ClearingBrokerAgreementRecord> findByInstitutionalRef(String ref);
    List<ClearingBrokerAgreementRecord> findByExecutionStatus(String status);
}
