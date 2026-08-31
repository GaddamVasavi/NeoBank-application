package com.neobank.securities;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface StructuredNoteValuationLogRepository extends JpaRepository<StructuredNoteValuationLog, UUID> {
    List<StructuredNoteValuationLog> findByUserId(UUID userId);
    Optional<StructuredNoteValuationLog> findBySystemIdentifier(String id);
    List<StructuredNoteValuationLog> findByValidationState(String state);
}
