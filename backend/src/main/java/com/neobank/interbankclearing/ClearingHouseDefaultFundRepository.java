package com.neobank.interbankclearing;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface ClearingHouseDefaultFundRepository extends JpaRepository<ClearingHouseDefaultFund, UUID> {
    List<ClearingHouseDefaultFund> findByUserId(UUID userId);
    Optional<ClearingHouseDefaultFund> findByProtocolReference(String ref);
    List<ClearingHouseDefaultFund> findByOperationalState(String state);
}
