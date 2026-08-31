package com.neobank.bill;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface BillerCategoryMappingRepository extends JpaRepository<BillerCategoryMapping, UUID> {
    List<BillerCategoryMapping> findByUserId(UUID userId);
    Optional<BillerCategoryMapping> findByRecordKey(String recordKey);
    List<BillerCategoryMapping> findByStatus(String status);
}
