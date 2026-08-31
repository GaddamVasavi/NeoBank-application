package com.neobank.openbanking;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface TppClientRegistrationRepository extends JpaRepository<TppClientRegistration, UUID> {
    List<TppClientRegistration> findByUserId(UUID userId);
    Optional<TppClientRegistration> findByTrackingCode(String code);
    List<TppClientRegistration> findByStateFlag(String stateFlag);
}
