package com.neobank.clearing;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface CentralCounterpartyNovationRepository extends JpaRepository<CentralCounterpartyNovation, UUID> {
    List<CentralCounterpartyNovation> findByUserId(UUID userId);
    Optional<CentralCounterpartyNovation> findByInstitutionalRef(String ref);
    List<CentralCounterpartyNovation> findByExecutionStatus(String status);
}
