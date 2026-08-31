package com.neobank.wealth;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface FamilyOfficeStructureRepository extends JpaRepository<FamilyOfficeStructure, UUID> {
    List<FamilyOfficeStructure> findByUserId(UUID userId);
    Optional<FamilyOfficeStructure> findByTrackingCode(String code);
    List<FamilyOfficeStructure> findByStateFlag(String stateFlag);
}
