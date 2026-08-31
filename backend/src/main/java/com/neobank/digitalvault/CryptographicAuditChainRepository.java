package com.neobank.digitalvault;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface CryptographicAuditChainRepository extends JpaRepository<CryptographicAuditChain, UUID> {
    List<CryptographicAuditChain> findByUserId(UUID userId);
    Optional<CryptographicAuditChain> findByProtocolReference(String ref);
    List<CryptographicAuditChain> findByOperationalState(String state);
}
