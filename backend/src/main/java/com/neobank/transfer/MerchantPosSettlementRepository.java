package com.neobank.transfer;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface MerchantPosSettlementRepository extends JpaRepository<MerchantPosSettlement, UUID> {
    List<MerchantPosSettlement> findBySourceAccountId(UUID accountId);
    Optional<MerchantPosSettlement> findByTrackingNumber(String trackingNumber);
    List<MerchantPosSettlement> findByStatus(String status);
}
