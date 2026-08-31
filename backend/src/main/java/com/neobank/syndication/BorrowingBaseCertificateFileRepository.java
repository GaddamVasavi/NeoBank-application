package com.neobank.syndication;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface BorrowingBaseCertificateFileRepository extends JpaRepository<BorrowingBaseCertificateFile, UUID> {
    List<BorrowingBaseCertificateFile> findByUserId(UUID userId);
    Optional<BorrowingBaseCertificateFile> findByDossierReference(String ref);
    List<BorrowingBaseCertificateFile> findByOperationalStatus(String status);
}
