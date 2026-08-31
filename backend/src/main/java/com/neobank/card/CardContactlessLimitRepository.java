package com.neobank.card;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface CardContactlessLimitRepository extends JpaRepository<CardContactlessLimit, UUID> {
    List<CardContactlessLimit> findByUserId(UUID userId);
    Optional<CardContactlessLimit> findByRecordKey(String recordKey);
    List<CardContactlessLimit> findByStatus(String status);
}
