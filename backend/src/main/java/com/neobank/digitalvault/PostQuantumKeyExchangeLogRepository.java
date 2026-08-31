package com.neobank.digitalvault;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface PostQuantumKeyExchangeLogRepository extends JpaRepository<PostQuantumKeyExchangeLog, UUID> {
    List<PostQuantumKeyExchangeLog> findByUserId(UUID userId);
    Optional<PostQuantumKeyExchangeLog> findByProtocolReference(String ref);
    List<PostQuantumKeyExchangeLog> findByOperationalState(String state);
}
