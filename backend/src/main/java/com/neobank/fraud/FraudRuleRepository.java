package com.neobank.fraud;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.UUID;
@Repository public interface FraudRuleRepository extends JpaRepository<FraudRule, UUID> {}
