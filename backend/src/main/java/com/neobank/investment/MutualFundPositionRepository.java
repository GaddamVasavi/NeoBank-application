package com.neobank.investment;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface MutualFundPositionRepository extends JpaRepository<MutualFundPosition, UUID> {
    List<MutualFundPosition> findByUserId(UUID userId);
    Optional<MutualFundPosition> findByIdentifierCode(String code);
    List<MutualFundPosition> findByStatus(String status);
}
