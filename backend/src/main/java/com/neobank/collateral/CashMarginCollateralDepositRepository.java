package com.neobank.collateral;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface CashMarginCollateralDepositRepository extends JpaRepository<CashMarginCollateralDeposit, UUID> {
    List<CashMarginCollateralDeposit> findByUserId(UUID userId);
    Optional<CashMarginCollateralDeposit> findByCoreReference(String ref);
    List<CashMarginCollateralDeposit> findByProcessingStatus(String status);
}
