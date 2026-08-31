package com.neobank.insurance;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface ActuarialLossReserveModelRepository extends JpaRepository<ActuarialLossReserveModel, UUID> {
    List<ActuarialLossReserveModel> findByUserId(UUID userId);
    Optional<ActuarialLossReserveModel> findByDossierReference(String ref);
    List<ActuarialLossReserveModel> findByOperationalStatus(String status);
}
