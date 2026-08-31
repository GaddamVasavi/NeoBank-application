package com.neobank.wealth;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface WealthAdvisorAssignmentRepository extends JpaRepository<WealthAdvisorAssignment, UUID> {
    List<WealthAdvisorAssignment> findByUserId(UUID userId);
    Optional<WealthAdvisorAssignment> findByTrackingCode(String code);
    List<WealthAdvisorAssignment> findByStateFlag(String stateFlag);
}
