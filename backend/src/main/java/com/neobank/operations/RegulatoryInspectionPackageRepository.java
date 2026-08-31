package com.neobank.operations;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface RegulatoryInspectionPackageRepository extends JpaRepository<RegulatoryInspectionPackage, UUID> {
    List<RegulatoryInspectionPackage> findByUserId(UUID userId);
    Optional<RegulatoryInspectionPackage> findByTrackingCode(String code);
    List<RegulatoryInspectionPackage> findByStateFlag(String stateFlag);
}
