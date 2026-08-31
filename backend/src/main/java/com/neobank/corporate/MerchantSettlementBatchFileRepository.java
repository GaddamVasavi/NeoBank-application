package com.neobank.corporate;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface MerchantSettlementBatchFileRepository extends JpaRepository<MerchantSettlementBatchFile, UUID> {
    List<MerchantSettlementBatchFile> findByUserId(UUID userId);
    Optional<MerchantSettlementBatchFile> findByTrackingCode(String code);
    List<MerchantSettlementBatchFile> findByStateFlag(String stateFlag);
}
