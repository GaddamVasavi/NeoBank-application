package com.neobank.card;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface CardGeoFencingControlRepository extends JpaRepository<CardGeoFencingControl, UUID> {
    List<CardGeoFencingControl> findByUserId(UUID userId);
    Optional<CardGeoFencingControl> findByCodeReference(String ref);
    List<CardGeoFencingControl> findByStatus(String status);
}
