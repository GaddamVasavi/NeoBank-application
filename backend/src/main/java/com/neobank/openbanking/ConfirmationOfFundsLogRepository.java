package com.neobank.openbanking;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface ConfirmationOfFundsLogRepository extends JpaRepository<ConfirmationOfFundsLog, UUID> {
    List<ConfirmationOfFundsLog> findByUserId(UUID userId);
    Optional<ConfirmationOfFundsLog> findByTrackingCode(String code);
    List<ConfirmationOfFundsLog> findByStateFlag(String stateFlag);
}
