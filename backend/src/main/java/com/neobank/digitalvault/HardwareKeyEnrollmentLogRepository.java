package com.neobank.digitalvault;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface HardwareKeyEnrollmentLogRepository extends JpaRepository<HardwareKeyEnrollmentLog, UUID> {
    List<HardwareKeyEnrollmentLog> findByUserId(UUID userId);
    Optional<HardwareKeyEnrollmentLog> findByProtocolReference(String ref);
    List<HardwareKeyEnrollmentLog> findByOperationalState(String state);
}
