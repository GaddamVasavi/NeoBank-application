package com.neobank.loan;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface CreditUnderwritingRubricRepository extends JpaRepository<CreditUnderwritingRubric, UUID> {
    List<CreditUnderwritingRubric> findByUserId(UUID userId);
    Optional<CreditUnderwritingRubric> findByRecordKey(String recordKey);
    List<CreditUnderwritingRubric> findByStatus(String status);
}
