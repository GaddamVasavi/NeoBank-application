package com.neobank.fraud;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface AccountTakeoverSignalRepository extends JpaRepository<AccountTakeoverSignal, UUID> {
    List<AccountTakeoverSignal> findByUserId(UUID userId);
    Optional<AccountTakeoverSignal> findByRecordKey(String recordKey);
    List<AccountTakeoverSignal> findByStatus(String status);
}
