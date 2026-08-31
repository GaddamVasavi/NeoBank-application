package com.neobank.securities;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface BondCouponPaymentRecordRepository extends JpaRepository<BondCouponPaymentRecord, UUID> {
    List<BondCouponPaymentRecord> findByUserId(UUID userId);
    Optional<BondCouponPaymentRecord> findBySystemIdentifier(String id);
    List<BondCouponPaymentRecord> findByValidationState(String state);
}
