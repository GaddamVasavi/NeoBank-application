package com.neobank.support;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface CustomerSatisfactionRatingRepository extends JpaRepository<CustomerSatisfactionRating, UUID> {
    List<CustomerSatisfactionRating> findByUserId(UUID userId);
    Optional<CustomerSatisfactionRating> findByRecordKey(String recordKey);
    List<CustomerSatisfactionRating> findByStatus(String status);
}
