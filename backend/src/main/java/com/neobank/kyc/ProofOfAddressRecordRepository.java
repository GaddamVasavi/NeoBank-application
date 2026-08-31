package com.neobank.kyc;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface ProofOfAddressRecordRepository extends JpaRepository<ProofOfAddressRecord, UUID> {
    List<ProofOfAddressRecord> findByUserId(UUID userId);
    Optional<ProofOfAddressRecord> findByRecordKey(String recordKey);
    List<ProofOfAddressRecord> findByStatus(String status);
}
