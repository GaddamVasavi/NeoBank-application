package com.neobank.openbanking;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface AccountInformationRequestLogRepository extends JpaRepository<AccountInformationRequestLog, UUID> {
    List<AccountInformationRequestLog> findByUserId(UUID userId);
    Optional<AccountInformationRequestLog> findByTrackingCode(String code);
    List<AccountInformationRequestLog> findByStateFlag(String stateFlag);
}
