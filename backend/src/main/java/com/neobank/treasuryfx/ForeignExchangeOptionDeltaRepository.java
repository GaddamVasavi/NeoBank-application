package com.neobank.treasuryfx;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface ForeignExchangeOptionDeltaRepository extends JpaRepository<ForeignExchangeOptionDelta, UUID> {
    List<ForeignExchangeOptionDelta> findByUserId(UUID userId);
    Optional<ForeignExchangeOptionDelta> findByInstitutionalRef(String ref);
    List<ForeignExchangeOptionDelta> findByExecutionStatus(String status);
}
