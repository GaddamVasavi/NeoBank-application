package com.neobank.privateequity;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface CapitalCallDrawdownNoticeRepository extends JpaRepository<CapitalCallDrawdownNotice, UUID> {
    List<CapitalCallDrawdownNotice> findByUserId(UUID userId);
    Optional<CapitalCallDrawdownNotice> findByProtocolReference(String ref);
    List<CapitalCallDrawdownNotice> findByOperationalState(String state);
}
