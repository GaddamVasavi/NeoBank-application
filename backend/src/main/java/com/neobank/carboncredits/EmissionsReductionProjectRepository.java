package com.neobank.carboncredits;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface EmissionsReductionProjectRepository extends JpaRepository<EmissionsReductionProject, UUID> {
    List<EmissionsReductionProject> findByUserId(UUID userId);
    Optional<EmissionsReductionProject> findByProtocolReference(String ref);
    List<EmissionsReductionProject> findByOperationalState(String state);
}
