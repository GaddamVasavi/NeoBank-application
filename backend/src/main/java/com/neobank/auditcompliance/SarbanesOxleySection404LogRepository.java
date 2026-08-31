package com.neobank.auditcompliance;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface SarbanesOxleySection404LogRepository extends JpaRepository<SarbanesOxleySection404Log, UUID> {
    List<SarbanesOxleySection404Log> findByUserId(UUID userId);
    Optional<SarbanesOxleySection404Log> findByClearingKey(String key);
    List<SarbanesOxleySection404Log> findByAuditStatus(String status);
}
