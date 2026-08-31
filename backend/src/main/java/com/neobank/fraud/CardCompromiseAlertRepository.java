package com.neobank.fraud;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface CardCompromiseAlertRepository extends JpaRepository<CardCompromiseAlert, UUID> {
    List<CardCompromiseAlert> findByUserId(UUID userId);
    Optional<CardCompromiseAlert> findByRecordKey(String recordKey);
    List<CardCompromiseAlert> findByStatus(String status);
}
