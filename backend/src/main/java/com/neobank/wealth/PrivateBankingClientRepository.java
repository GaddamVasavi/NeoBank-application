package com.neobank.wealth;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface PrivateBankingClientRepository extends JpaRepository<PrivateBankingClient, UUID> {
    List<PrivateBankingClient> findByUserId(UUID userId);
    Optional<PrivateBankingClient> findByTrackingCode(String code);
    List<PrivateBankingClient> findByStateFlag(String stateFlag);
}
