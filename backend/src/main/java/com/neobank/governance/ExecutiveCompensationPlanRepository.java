package com.neobank.governance;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface ExecutiveCompensationPlanRepository extends JpaRepository<ExecutiveCompensationPlan, UUID> {
    List<ExecutiveCompensationPlan> findByUserId(UUID userId);
    Optional<ExecutiveCompensationPlan> findByInstitutionalRef(String ref);
    List<ExecutiveCompensationPlan> findByExecutionStatus(String status);
}
