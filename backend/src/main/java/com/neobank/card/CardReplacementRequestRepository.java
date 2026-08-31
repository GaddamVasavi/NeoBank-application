package com.neobank.card;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface CardReplacementRequestRepository extends JpaRepository<CardReplacementRequest, UUID> {
    List<CardReplacementRequest> findByUserId(UUID userId);
    Optional<CardReplacementRequest> findByCodeReference(String ref);
    List<CardReplacementRequest> findByStatus(String status);
}
