package com.neobank.bonds;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface GreenBondIssuanceCertificateRepository extends JpaRepository<GreenBondIssuanceCertificate, UUID> {
    List<GreenBondIssuanceCertificate> findByUserId(UUID userId);
    Optional<GreenBondIssuanceCertificate> findByClearingKey(String key);
    List<GreenBondIssuanceCertificate> findByAuditStatus(String status);
}
