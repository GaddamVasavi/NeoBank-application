package com.neobank.interbankclearing;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface FedwireHighValueMessageRepository extends JpaRepository<FedwireHighValueMessage, UUID> {
    List<FedwireHighValueMessage> findByUserId(UUID userId);
    Optional<FedwireHighValueMessage> findByProtocolReference(String ref);
    List<FedwireHighValueMessage> findByOperationalState(String state);
}
