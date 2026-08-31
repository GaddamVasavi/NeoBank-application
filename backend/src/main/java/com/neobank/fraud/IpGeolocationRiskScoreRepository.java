package com.neobank.fraud;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface IpGeolocationRiskScoreRepository extends JpaRepository<IpGeolocationRiskScore, UUID> {
    List<IpGeolocationRiskScore> findByUserId(UUID userId);
    Optional<IpGeolocationRiskScore> findByRecordKey(String recordKey);
    List<IpGeolocationRiskScore> findByStatus(String status);
}
