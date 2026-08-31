package com.neobank.settlementgateway;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface CentralSecuritiesDepositoryLinkRepository extends JpaRepository<CentralSecuritiesDepositoryLink, UUID> {
    List<CentralSecuritiesDepositoryLink> findByUserId(UUID userId);
    Optional<CentralSecuritiesDepositoryLink> findByGatewayReference(String ref);
    List<CentralSecuritiesDepositoryLink> findBySettlementState(String state);
}
