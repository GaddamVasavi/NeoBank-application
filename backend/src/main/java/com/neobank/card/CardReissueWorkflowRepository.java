package com.neobank.card;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface CardReissueWorkflowRepository extends JpaRepository<CardReissueWorkflow, UUID> {
    List<CardReissueWorkflow> findByUserId(UUID userId);
    Optional<CardReissueWorkflow> findByRecordKey(String recordKey);
    List<CardReissueWorkflow> findByStatus(String status);
}
