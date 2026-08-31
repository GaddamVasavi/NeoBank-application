package com.neobank.commercial;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface CorporateEntityProfileRepository extends JpaRepository<CorporateEntityProfile, UUID> {
    List<CorporateEntityProfile> findByUserId(UUID userId);
    Optional<CorporateEntityProfile> findByIdentifierCode(String code);
    List<CorporateEntityProfile> findByStatus(String status);
}
