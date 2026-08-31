package com.neobank.transaction;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.UUID;
@Repository public interface DoubleEntryLedgerRepository extends JpaRepository<DoubleEntryLedger, UUID> {
    List<DoubleEntryLedger> findByEntryReference(String ref);
}
