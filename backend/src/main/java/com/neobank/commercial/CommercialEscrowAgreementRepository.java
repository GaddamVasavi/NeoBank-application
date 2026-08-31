package com.neobank.commercial;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface CommercialEscrowAgreementRepository extends JpaRepository<CommercialEscrowAgreement, UUID> {
    List<CommercialEscrowAgreement> findByUserId(UUID userId);
    Optional<CommercialEscrowAgreement> findByIdentifierCode(String code);
    List<CommercialEscrowAgreement> findByStatus(String status);
}
