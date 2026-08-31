package com.neobank.regulatory;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface LargeExposureReturnRepository extends JpaRepository<LargeExposureReturn, UUID> {
    List<LargeExposureReturn> findByUserId(UUID userId);
    Optional<LargeExposureReturn> findByAuthorityRef(String ref);
    List<LargeExposureReturn> findBySubmissionStatus(String status);
}
