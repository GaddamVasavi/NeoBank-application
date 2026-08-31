package com.neobank.fraud;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.UUID;
@Repository public interface FraudCaseRepository extends JpaRepository<FraudCase, UUID> {
    List<FraudCase> findByStatus(String status);
    List<FraudCase> findByUserId(UUID userId);
}
