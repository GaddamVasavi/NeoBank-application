package com.neobank.card;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface CardRewardsTierRepository extends JpaRepository<CardRewardsTier, UUID> {
    List<CardRewardsTier> findByUserId(UUID userId);
    Optional<CardRewardsTier> findByRecordKey(String recordKey);
    List<CardRewardsTier> findByStatus(String status);
}
