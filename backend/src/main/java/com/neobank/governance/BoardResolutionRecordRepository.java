package com.neobank.governance;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface BoardResolutionRecordRepository extends JpaRepository<BoardResolutionRecord, UUID> {
    List<BoardResolutionRecord> findByUserId(UUID userId);
    Optional<BoardResolutionRecord> findByInstitutionalRef(String ref);
    List<BoardResolutionRecord> findByExecutionStatus(String status);
}
