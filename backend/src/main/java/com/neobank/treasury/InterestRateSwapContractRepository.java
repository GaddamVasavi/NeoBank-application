package com.neobank.treasury;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface InterestRateSwapContractRepository extends JpaRepository<InterestRateSwapContract, UUID> {
    List<InterestRateSwapContract> findByUserId(UUID userId);
    Optional<InterestRateSwapContract> findByIdentifierCode(String code);
    List<InterestRateSwapContract> findByStatus(String status);
}
