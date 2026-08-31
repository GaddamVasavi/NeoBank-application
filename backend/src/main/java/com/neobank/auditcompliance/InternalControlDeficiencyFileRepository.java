package com.neobank.auditcompliance;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface InternalControlDeficiencyFileRepository extends JpaRepository<InternalControlDeficiencyFile, UUID> {
    List<InternalControlDeficiencyFile> findByUserId(UUID userId);
    Optional<InternalControlDeficiencyFile> findByClearingKey(String key);
    List<InternalControlDeficiencyFile> findByAuditStatus(String status);
}
