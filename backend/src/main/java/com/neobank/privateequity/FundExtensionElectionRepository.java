package com.neobank.privateequity;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface FundExtensionElectionRepository extends JpaRepository<FundExtensionElection, UUID> {
    List<FundExtensionElection> findByUserId(UUID userId);
    Optional<FundExtensionElection> findByProtocolReference(String ref);
    List<FundExtensionElection> findByOperationalState(String state);
}
