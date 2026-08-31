package com.neobank.tax;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface TaxForm1099IntGenerationRepository extends JpaRepository<TaxForm1099IntGeneration, UUID> {
    List<TaxForm1099IntGeneration> findByUserId(UUID userId);
    Optional<TaxForm1099IntGeneration> findByCoreReference(String ref);
    List<TaxForm1099IntGeneration> findByProcessingStatus(String status);
}
