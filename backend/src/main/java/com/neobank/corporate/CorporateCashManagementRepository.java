package com.neobank.corporate;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface CorporateCashManagementRepository extends JpaRepository<CorporateCashManagement, UUID> {
    List<CorporateCashManagement> findByUserId(UUID userId);
    Optional<CorporateCashManagement> findByTrackingCode(String code);
    List<CorporateCashManagement> findByStateFlag(String stateFlag);
}
