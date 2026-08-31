package com.neobank.corporate;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface VirtualIbanPoolRepository extends JpaRepository<VirtualIbanPool, UUID> {
    List<VirtualIbanPool> findByUserId(UUID userId);
    Optional<VirtualIbanPool> findByTrackingCode(String code);
    List<VirtualIbanPool> findByStateFlag(String stateFlag);
}
