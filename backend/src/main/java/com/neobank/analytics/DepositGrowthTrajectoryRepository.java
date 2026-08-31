package com.neobank.analytics;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface DepositGrowthTrajectoryRepository extends JpaRepository<DepositGrowthTrajectory, UUID> {
    List<DepositGrowthTrajectory> findByUserId(UUID userId);
    Optional<DepositGrowthTrajectory> findByRecordKey(String recordKey);
    List<DepositGrowthTrajectory> findByStatus(String status);
}
