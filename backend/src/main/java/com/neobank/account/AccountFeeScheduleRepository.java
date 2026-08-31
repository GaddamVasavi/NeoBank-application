package com.neobank.account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface AccountFeeScheduleRepository extends JpaRepository<AccountFeeSchedule, UUID> {
    List<AccountFeeSchedule> findByAccountId(UUID accountId);
    Optional<AccountFeeSchedule> findByReferenceCode(String ref);
    List<AccountFeeSchedule> findByStatus(String status);
}
