package com.neobank.collateral;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface AircraftVesselLienRegistryRepository extends JpaRepository<AircraftVesselLienRegistry, UUID> {
    List<AircraftVesselLienRegistry> findByUserId(UUID userId);
    Optional<AircraftVesselLienRegistry> findByCoreReference(String ref);
    List<AircraftVesselLienRegistry> findByProcessingStatus(String status);
}
