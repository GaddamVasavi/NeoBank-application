package com.neobank.interbankclearing;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface NostroAccountReconBreakRepository extends JpaRepository<NostroAccountReconBreak, UUID> {
    List<NostroAccountReconBreak> findByUserId(UUID userId);
    Optional<NostroAccountReconBreak> findByProtocolReference(String ref);
    List<NostroAccountReconBreak> findByOperationalState(String state);
}
