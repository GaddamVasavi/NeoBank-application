package com.neobank.regulatory;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface NetStableFundingReturnRepository extends JpaRepository<NetStableFundingReturn, UUID> {
    List<NetStableFundingReturn> findByUserId(UUID userId);
    Optional<NetStableFundingReturn> findByAuthorityRef(String ref);
    List<NetStableFundingReturn> findBySubmissionStatus(String status);
}
