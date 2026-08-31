package com.neobank.auditcompliance;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface SupervisoryStressTestPackageRepository extends JpaRepository<SupervisoryStressTestPackage, UUID> {
    List<SupervisoryStressTestPackage> findByUserId(UUID userId);
    Optional<SupervisoryStressTestPackage> findByClearingKey(String key);
    List<SupervisoryStressTestPackage> findByAuditStatus(String status);
}
