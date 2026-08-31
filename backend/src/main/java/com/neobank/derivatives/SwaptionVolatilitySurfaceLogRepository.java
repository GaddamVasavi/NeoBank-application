package com.neobank.derivatives;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface SwaptionVolatilitySurfaceLogRepository extends JpaRepository<SwaptionVolatilitySurfaceLog, UUID> {
    List<SwaptionVolatilitySurfaceLog> findByUserId(UUID userId);
    Optional<SwaptionVolatilitySurfaceLog> findByClearingKey(String key);
    List<SwaptionVolatilitySurfaceLog> findByAuditStatus(String status);
}
