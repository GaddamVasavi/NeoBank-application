package com.neobank.trade;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface LetterOfCreditDocumentRepository extends JpaRepository<LetterOfCreditDocument, UUID> {
    List<LetterOfCreditDocument> findByUserId(UUID userId);
    Optional<LetterOfCreditDocument> findBySettlementRef(String ref);
    List<LetterOfCreditDocument> findByLifecycleStatus(String status);
}
