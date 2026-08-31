package com.neobank.analyticsengine;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface DepositBetaSensitivityRepository extends JpaRepository<DepositBetaSensitivity, UUID> {
    List<DepositBetaSensitivity> findByUserId(UUID userId);
    Optional<DepositBetaSensitivity> findByCoreReference(String ref);
    List<DepositBetaSensitivity> findByProcessingStatus(String status);
}
