package com.neobank.account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface AccountClosureRequestRepository extends JpaRepository<AccountClosureRequest, UUID> {
    List<AccountClosureRequest> findByAccountId(UUID accountId);
    Optional<AccountClosureRequest> findByReferenceCode(String ref);
    List<AccountClosureRequest> findByStatus(String status);
}
