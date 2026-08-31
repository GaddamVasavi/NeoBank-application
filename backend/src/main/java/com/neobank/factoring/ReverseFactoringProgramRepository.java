package com.neobank.factoring;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface ReverseFactoringProgramRepository extends JpaRepository<ReverseFactoringProgram, UUID> {
    List<ReverseFactoringProgram> findByUserId(UUID userId);
    Optional<ReverseFactoringProgram> findByDossierReference(String ref);
    List<ReverseFactoringProgram> findByOperationalStatus(String status);
}
