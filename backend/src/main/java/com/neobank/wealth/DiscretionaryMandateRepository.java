package com.neobank.wealth;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface DiscretionaryMandateRepository extends JpaRepository<DiscretionaryMandate, UUID> {
    List<DiscretionaryMandate> findByUserId(UUID userId);
    Optional<DiscretionaryMandate> findByTrackingCode(String code);
    List<DiscretionaryMandate> findByStateFlag(String stateFlag);
}
