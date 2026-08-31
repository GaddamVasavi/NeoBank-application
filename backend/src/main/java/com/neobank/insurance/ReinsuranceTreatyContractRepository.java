package com.neobank.insurance;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface ReinsuranceTreatyContractRepository extends JpaRepository<ReinsuranceTreatyContract, UUID> {
    List<ReinsuranceTreatyContract> findByUserId(UUID userId);
    Optional<ReinsuranceTreatyContract> findByDossierReference(String ref);
    List<ReinsuranceTreatyContract> findByOperationalStatus(String status);
}
