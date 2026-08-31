package com.neobank.card;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface CardMerchantBlacklistRepository extends JpaRepository<CardMerchantBlacklist, UUID> {
    List<CardMerchantBlacklist> findByUserId(UUID userId);
    Optional<CardMerchantBlacklist> findByRecordKey(String recordKey);
    List<CardMerchantBlacklist> findByStatus(String status);
}
