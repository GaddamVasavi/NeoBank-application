package com.neobank.wealth;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface ArtCollectiblesCollateralRepository extends JpaRepository<ArtCollectiblesCollateral, UUID> {
    List<ArtCollectiblesCollateral> findByUserId(UUID userId);
    Optional<ArtCollectiblesCollateral> findByTrackingCode(String code);
    List<ArtCollectiblesCollateral> findByStateFlag(String stateFlag);
}
