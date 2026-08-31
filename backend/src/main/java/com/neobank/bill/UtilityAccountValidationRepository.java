package com.neobank.bill;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface UtilityAccountValidationRepository extends JpaRepository<UtilityAccountValidation, UUID> {
    List<UtilityAccountValidation> findByUserId(UUID userId);
    Optional<UtilityAccountValidation> findByRecordKey(String recordKey);
    List<UtilityAccountValidation> findByStatus(String status);
}
