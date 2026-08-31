package com.neobank.openbanking;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface Psd2ConsentRecordRepository extends JpaRepository<Psd2ConsentRecord, UUID> {
    List<Psd2ConsentRecord> findByUserId(UUID userId);
    Optional<Psd2ConsentRecord> findByTrackingCode(String code);
    List<Psd2ConsentRecord> findByStateFlag(String stateFlag);
}
