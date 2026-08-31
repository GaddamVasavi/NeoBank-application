package com.neobank.clearing;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface InitialMarginCalculationModelRepository extends JpaRepository<InitialMarginCalculationModel, UUID> {
    List<InitialMarginCalculationModel> findByUserId(UUID userId);
    Optional<InitialMarginCalculationModel> findByInstitutionalRef(String ref);
    List<InitialMarginCalculationModel> findByExecutionStatus(String status);
}
