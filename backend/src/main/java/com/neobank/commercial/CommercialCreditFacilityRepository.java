package com.neobank.commercial;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface CommercialCreditFacilityRepository extends JpaRepository<CommercialCreditFacility, UUID> {
    List<CommercialCreditFacility> findByUserId(UUID userId);
    Optional<CommercialCreditFacility> findByIdentifierCode(String code);
    List<CommercialCreditFacility> findByStatus(String status);
}
