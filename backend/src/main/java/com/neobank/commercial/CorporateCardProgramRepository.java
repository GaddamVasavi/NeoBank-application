package com.neobank.commercial;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface CorporateCardProgramRepository extends JpaRepository<CorporateCardProgram, UUID> {
    List<CorporateCardProgram> findByUserId(UUID userId);
    Optional<CorporateCardProgram> findByIdentifierCode(String code);
    List<CorporateCardProgram> findByStatus(String status);
}
