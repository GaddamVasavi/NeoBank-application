package com.neobank.treasuryfx;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface InterestRateCapFloorContractRepository extends JpaRepository<InterestRateCapFloorContract, UUID> {
    List<InterestRateCapFloorContract> findByUserId(UUID userId);
    Optional<InterestRateCapFloorContract> findByInstitutionalRef(String ref);
    List<InterestRateCapFloorContract> findByExecutionStatus(String status);
}
