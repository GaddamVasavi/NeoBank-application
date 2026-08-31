package com.neobank.privateequity;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface LimitedPartnerCommitmentRepository extends JpaRepository<LimitedPartnerCommitment, UUID> {
    List<LimitedPartnerCommitment> findByUserId(UUID userId);
    Optional<LimitedPartnerCommitment> findByProtocolReference(String ref);
    List<LimitedPartnerCommitment> findByOperationalState(String state);
}
