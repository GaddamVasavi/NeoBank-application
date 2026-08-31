package com.neobank.kyc;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface SourceOfFundsDeclarationRepository extends JpaRepository<SourceOfFundsDeclaration, UUID> {
    List<SourceOfFundsDeclaration> findByUserId(UUID userId);
    Optional<SourceOfFundsDeclaration> findByRecordKey(String recordKey);
    List<SourceOfFundsDeclaration> findByStatus(String status);
}
