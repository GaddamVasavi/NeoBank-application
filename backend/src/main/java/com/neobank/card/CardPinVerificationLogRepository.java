package com.neobank.card;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface CardPinVerificationLogRepository extends JpaRepository<CardPinVerificationLog, UUID> {
    List<CardPinVerificationLog> findByUserId(UUID userId);
    Optional<CardPinVerificationLog> findByRecordKey(String recordKey);
    List<CardPinVerificationLog> findByStatus(String status);
}
