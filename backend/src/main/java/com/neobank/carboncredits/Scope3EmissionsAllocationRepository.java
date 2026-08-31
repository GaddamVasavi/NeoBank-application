package com.neobank.carboncredits;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface Scope3EmissionsAllocationRepository extends JpaRepository<Scope3EmissionsAllocation, UUID> {
    List<Scope3EmissionsAllocation> findByUserId(UUID userId);
    Optional<Scope3EmissionsAllocation> findByProtocolReference(String ref);
    List<Scope3EmissionsAllocation> findByOperationalState(String state);
}
