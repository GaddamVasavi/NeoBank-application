package com.neobank.securities;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface BrokerageAccountMandateRepository extends JpaRepository<BrokerageAccountMandate, UUID> {
    List<BrokerageAccountMandate> findByUserId(UUID userId);
    Optional<BrokerageAccountMandate> findBySystemIdentifier(String id);
    List<BrokerageAccountMandate> findByValidationState(String state);
}
