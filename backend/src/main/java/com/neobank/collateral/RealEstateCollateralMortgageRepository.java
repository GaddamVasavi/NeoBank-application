package com.neobank.collateral;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface RealEstateCollateralMortgageRepository extends JpaRepository<RealEstateCollateralMortgage, UUID> {
    List<RealEstateCollateralMortgage> findByUserId(UUID userId);
    Optional<RealEstateCollateralMortgage> findByCoreReference(String ref);
    List<RealEstateCollateralMortgage> findByProcessingStatus(String status);
}
