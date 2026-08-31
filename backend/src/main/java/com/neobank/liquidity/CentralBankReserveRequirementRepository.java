package com.neobank.liquidity;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface CentralBankReserveRequirementRepository extends JpaRepository<CentralBankReserveRequirement, UUID> {
    List<CentralBankReserveRequirement> findByUserId(UUID userId);
    Optional<CentralBankReserveRequirement> findBySystemIdentifier(String id);
    List<CentralBankReserveRequirement> findByValidationState(String state);
}
