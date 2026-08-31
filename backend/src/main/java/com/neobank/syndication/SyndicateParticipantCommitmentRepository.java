package com.neobank.syndication;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface SyndicateParticipantCommitmentRepository extends JpaRepository<SyndicateParticipantCommitment, UUID> {
    List<SyndicateParticipantCommitment> findByUserId(UUID userId);
    Optional<SyndicateParticipantCommitment> findByDossierReference(String ref);
    List<SyndicateParticipantCommitment> findByOperationalStatus(String status);
}
