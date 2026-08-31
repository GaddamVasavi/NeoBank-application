package com.neobank.openbanking;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface ApiUsageQuotaAllocationRepository extends JpaRepository<ApiUsageQuotaAllocation, UUID> {
    List<ApiUsageQuotaAllocation> findByUserId(UUID userId);
    Optional<ApiUsageQuotaAllocation> findByTrackingCode(String code);
    List<ApiUsageQuotaAllocation> findByStateFlag(String stateFlag);
}
