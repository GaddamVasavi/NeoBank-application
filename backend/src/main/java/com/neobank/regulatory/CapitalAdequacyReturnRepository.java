package com.neobank.regulatory;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface CapitalAdequacyReturnRepository extends JpaRepository<CapitalAdequacyReturn, UUID> {
    List<CapitalAdequacyReturn> findByUserId(UUID userId);
    Optional<CapitalAdequacyReturn> findByAuthorityRef(String ref);
    List<CapitalAdequacyReturn> findBySubmissionStatus(String status);
}
