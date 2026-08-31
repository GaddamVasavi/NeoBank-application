package com.neobank.securities;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface MutualFundOrderBookRecordRepository extends JpaRepository<MutualFundOrderBookRecord, UUID> {
    List<MutualFundOrderBookRecord> findByUserId(UUID userId);
    Optional<MutualFundOrderBookRecord> findBySystemIdentifier(String id);
    List<MutualFundOrderBookRecord> findByValidationState(String state);
}
