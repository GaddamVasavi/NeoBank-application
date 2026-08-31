package com.neobank.analyticsengine;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface ExpectedCreditLossModelRepository extends JpaRepository<ExpectedCreditLossModel, UUID> {
    List<ExpectedCreditLossModel> findByUserId(UUID userId);
    Optional<ExpectedCreditLossModel> findByCoreReference(String ref);
    List<ExpectedCreditLossModel> findByProcessingStatus(String status);
}
