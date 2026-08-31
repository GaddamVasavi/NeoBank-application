package com.neobank.syndicatedloans;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface IntercreditorSubordinationRepository extends JpaRepository<IntercreditorSubordination, UUID> {
    List<IntercreditorSubordination> findByUserId(UUID userId);
    Optional<IntercreditorSubordination> findByProtocolReference(String ref);
    List<IntercreditorSubordination> findByOperationalState(String state);
}
