package com.neobank.tax;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface DividendTaxWithholdingRepository extends JpaRepository<DividendTaxWithholding, UUID> {
    List<DividendTaxWithholding> findByUserId(UUID userId);
    Optional<DividendTaxWithholding> findByCoreReference(String ref);
    List<DividendTaxWithholding> findByProcessingStatus(String status);
}
