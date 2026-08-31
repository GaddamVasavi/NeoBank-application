package com.neobank.account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface OverdraftFacilityRepository extends JpaRepository<OverdraftFacility, UUID> {
    List<OverdraftFacility> findByAccountId(UUID accountId);
    Optional<OverdraftFacility> findByReferenceCode(String ref);
    List<OverdraftFacility> findByStatus(String status);
}
