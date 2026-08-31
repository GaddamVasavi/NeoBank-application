package com.neobank.securities;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface EquityTradeConfirmationRepository extends JpaRepository<EquityTradeConfirmation, UUID> {
    List<EquityTradeConfirmation> findByUserId(UUID userId);
    Optional<EquityTradeConfirmation> findBySystemIdentifier(String id);
    List<EquityTradeConfirmation> findByValidationState(String state);
}
