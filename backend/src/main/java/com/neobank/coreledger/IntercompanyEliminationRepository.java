package com.neobank.coreledger;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface IntercompanyEliminationRepository extends JpaRepository<IntercompanyElimination, UUID> {
    List<IntercompanyElimination> findByUserId(UUID userId);
    Optional<IntercompanyElimination> findByCoreReference(String ref);
    List<IntercompanyElimination> findByProcessingStatus(String status);
}
