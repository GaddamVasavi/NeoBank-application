package com.neobank.derivatives;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface TotalReturnSwapDealAgreementRepository extends JpaRepository<TotalReturnSwapDealAgreement, UUID> {
    List<TotalReturnSwapDealAgreement> findByUserId(UUID userId);
    Optional<TotalReturnSwapDealAgreement> findByClearingKey(String key);
    List<TotalReturnSwapDealAgreement> findByAuditStatus(String status);
}
