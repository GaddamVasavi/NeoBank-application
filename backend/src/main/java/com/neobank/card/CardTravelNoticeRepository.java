package com.neobank.card;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface CardTravelNoticeRepository extends JpaRepository<CardTravelNotice, UUID> {
    List<CardTravelNotice> findByUserId(UUID userId);
    Optional<CardTravelNotice> findByRecordKey(String recordKey);
    List<CardTravelNotice> findByStatus(String status);
}
