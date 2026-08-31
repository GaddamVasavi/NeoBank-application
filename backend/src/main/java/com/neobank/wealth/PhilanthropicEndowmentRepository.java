package com.neobank.wealth;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface PhilanthropicEndowmentRepository extends JpaRepository<PhilanthropicEndowment, UUID> {
    List<PhilanthropicEndowment> findByUserId(UUID userId);
    Optional<PhilanthropicEndowment> findByTrackingCode(String code);
    List<PhilanthropicEndowment> findByStateFlag(String stateFlag);
}
