package com.neobank.openbanking;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface OpenBankingApiTrafficLogRepository extends JpaRepository<OpenBankingApiTrafficLog, UUID> {
    List<OpenBankingApiTrafficLog> findByUserId(UUID userId);
    Optional<OpenBankingApiTrafficLog> findByTrackingCode(String code);
    List<OpenBankingApiTrafficLog> findByStateFlag(String stateFlag);
}
