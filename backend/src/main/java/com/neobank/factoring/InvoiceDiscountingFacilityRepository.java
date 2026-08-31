package com.neobank.factoring;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface InvoiceDiscountingFacilityRepository extends JpaRepository<InvoiceDiscountingFacility, UUID> {
    List<InvoiceDiscountingFacility> findByUserId(UUID userId);
    Optional<InvoiceDiscountingFacility> findByDossierReference(String ref);
    List<InvoiceDiscountingFacility> findByOperationalStatus(String status);
}
