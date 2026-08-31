package com.neobank.regulatory;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface LiquidityCoverageReturnRepository extends JpaRepository<LiquidityCoverageReturn, UUID> {
    List<LiquidityCoverageReturn> findByUserId(UUID userId);
    Optional<LiquidityCoverageReturn> findByAuthorityRef(String ref);
    List<LiquidityCoverageReturn> findBySubmissionStatus(String status);
}
