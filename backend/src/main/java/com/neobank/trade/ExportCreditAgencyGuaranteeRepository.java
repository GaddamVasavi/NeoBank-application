package com.neobank.trade;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface ExportCreditAgencyGuaranteeRepository extends JpaRepository<ExportCreditAgencyGuarantee, UUID> {
    List<ExportCreditAgencyGuarantee> findByUserId(UUID userId);
    Optional<ExportCreditAgencyGuarantee> findBySettlementRef(String ref);
    List<ExportCreditAgencyGuarantee> findByLifecycleStatus(String status);
}
