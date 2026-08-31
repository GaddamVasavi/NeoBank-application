package com.neobank.wealth;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface PrivateEquityCommitmentRepository extends JpaRepository<PrivateEquityCommitment, UUID> {
    List<PrivateEquityCommitment> findByUserId(UUID userId);
    Optional<PrivateEquityCommitment> findByTrackingCode(String code);
    List<PrivateEquityCommitment> findByStateFlag(String stateFlag);
}
