package com.neobank.openbanking;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface OpenBankingSecurityCertificateRepository extends JpaRepository<OpenBankingSecurityCertificate, UUID> {
    List<OpenBankingSecurityCertificate> findByUserId(UUID userId);
    Optional<OpenBankingSecurityCertificate> findByTrackingCode(String code);
    List<OpenBankingSecurityCertificate> findByStateFlag(String stateFlag);
}
