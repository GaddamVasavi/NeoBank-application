package com.neobank.auditstream;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface ImmutableAuditLogBlockRepository extends JpaRepository<ImmutableAuditLogBlock, UUID> {
    List<ImmutableAuditLogBlock> findByUserId(UUID userId);
    Optional<ImmutableAuditLogBlock> findByCoreReference(String ref);
    List<ImmutableAuditLogBlock> findByProcessingStatus(String status);
}
