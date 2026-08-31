package com.neobank.auth;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository
public interface UserDeviceRepository extends JpaRepository<UserDevice, UUID> {
    Optional<UserDevice> findByUserIdAndDeviceFingerprint(UUID userId, String fingerprint);
    List<UserDevice> findByUserIdOrderByLastActiveAtDesc(UUID userId);
}
