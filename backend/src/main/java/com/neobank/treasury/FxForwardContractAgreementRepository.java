package com.neobank.treasury;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface FxForwardContractAgreementRepository extends JpaRepository<FxForwardContractAgreement, UUID> {
    List<FxForwardContractAgreement> findByUserId(UUID userId);
    Optional<FxForwardContractAgreement> findByIdentifierCode(String code);
    List<FxForwardContractAgreement> findByStatus(String status);
}
