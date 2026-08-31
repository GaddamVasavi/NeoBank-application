package com.neobank.privateequity;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface CoInvestmentVehicleRecordRepository extends JpaRepository<CoInvestmentVehicleRecord, UUID> {
    List<CoInvestmentVehicleRecord> findByUserId(UUID userId);
    Optional<CoInvestmentVehicleRecord> findByProtocolReference(String ref);
    List<CoInvestmentVehicleRecord> findByOperationalState(String state);
}
