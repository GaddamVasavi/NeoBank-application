package com.neobank.commercial;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface LetterOfCreditAgreementRepository extends JpaRepository<LetterOfCreditAgreement, UUID> {
    List<LetterOfCreditAgreement> findByUserId(UUID userId);
    Optional<LetterOfCreditAgreement> findByIdentifierCode(String code);
    List<LetterOfCreditAgreement> findByStatus(String status);
}
