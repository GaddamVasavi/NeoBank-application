package com.neobank.carboncredits;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface RenewableEnergyCertificateRepository extends JpaRepository<RenewableEnergyCertificate, UUID> {
    List<RenewableEnergyCertificate> findByUserId(UUID userId);
    Optional<RenewableEnergyCertificate> findByProtocolReference(String ref);
    List<RenewableEnergyCertificate> findByOperationalState(String state);
}
