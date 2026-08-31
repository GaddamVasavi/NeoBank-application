package com.neobank.compliance;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface RegulatoryFilingPackageRepository extends JpaRepository<RegulatoryFilingPackage, UUID> {
    List<RegulatoryFilingPackage> findByUserId(UUID userId);
    Optional<RegulatoryFilingPackage> findByIdentifierCode(String code);
    List<RegulatoryFilingPackage> findByStatus(String status);
}
