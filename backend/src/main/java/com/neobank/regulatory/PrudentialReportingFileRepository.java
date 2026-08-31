package com.neobank.regulatory;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface PrudentialReportingFileRepository extends JpaRepository<PrudentialReportingFile, UUID> {
    List<PrudentialReportingFile> findByUserId(UUID userId);
    Optional<PrudentialReportingFile> findByAuthorityRef(String ref);
    List<PrudentialReportingFile> findBySubmissionStatus(String status);
}
