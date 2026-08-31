package com.neobank.openbanking;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface DynamicClientRegistrationRecordRepository extends JpaRepository<DynamicClientRegistrationRecord, UUID> {
    List<DynamicClientRegistrationRecord> findByUserId(UUID userId);
    Optional<DynamicClientRegistrationRecord> findByTrackingCode(String code);
    List<DynamicClientRegistrationRecord> findByStateFlag(String stateFlag);
}
