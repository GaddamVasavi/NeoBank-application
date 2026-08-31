package com.neobank.treasury;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface GovernmentBondHoldingRepository extends JpaRepository<GovernmentBondHolding, UUID> {
    List<GovernmentBondHolding> findByUserId(UUID userId);
    Optional<GovernmentBondHolding> findByIdentifierCode(String code);
    List<GovernmentBondHolding> findByStatus(String status);
}
