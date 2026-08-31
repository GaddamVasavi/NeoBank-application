package com.neobank.governance;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface ProxyVoteAdvisoryFileRepository extends JpaRepository<ProxyVoteAdvisoryFile, UUID> {
    List<ProxyVoteAdvisoryFile> findByUserId(UUID userId);
    Optional<ProxyVoteAdvisoryFile> findByInstitutionalRef(String ref);
    List<ProxyVoteAdvisoryFile> findByExecutionStatus(String status);
}
