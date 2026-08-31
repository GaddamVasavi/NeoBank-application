package com.neobank.corporate;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface SweepAccountArrangementRepository extends JpaRepository<SweepAccountArrangement, UUID> {
    List<SweepAccountArrangement> findByUserId(UUID userId);
    Optional<SweepAccountArrangement> findByTrackingCode(String code);
    List<SweepAccountArrangement> findByStateFlag(String stateFlag);
}
