package com.neobank.settlementgateway;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface DvPAssetExchangeRecordRepository extends JpaRepository<DvPAssetExchangeRecord, UUID> {
    List<DvPAssetExchangeRecord> findByUserId(UUID userId);
    Optional<DvPAssetExchangeRecord> findByGatewayReference(String ref);
    List<DvPAssetExchangeRecord> findBySettlementState(String state);
}
