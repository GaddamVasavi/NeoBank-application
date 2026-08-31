package com.neobank.syndicatedloans;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface BorrowingBaseCertificateRepository extends JpaRepository<BorrowingBaseCertificate, UUID> {
    List<BorrowingBaseCertificate> findByUserId(UUID userId);
    Optional<BorrowingBaseCertificate> findByProtocolReference(String ref);
    List<BorrowingBaseCertificate> findByOperationalState(String state);
}
