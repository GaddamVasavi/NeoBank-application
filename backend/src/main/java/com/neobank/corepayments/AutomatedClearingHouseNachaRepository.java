package com.neobank.corepayments;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface AutomatedClearingHouseNachaRepository extends JpaRepository<AutomatedClearingHouseNacha, UUID> {
    List<AutomatedClearingHouseNacha> findByUserId(UUID userId);
    Optional<AutomatedClearingHouseNacha> findByClearingKey(String key);
    List<AutomatedClearingHouseNacha> findByAuditStatus(String status);
}
