package com.neobank.account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface EscrowAccountRepository extends JpaRepository<EscrowAccount, UUID> {
    List<EscrowAccount> findByAccountId(UUID accountId);
    Optional<EscrowAccount> findByReferenceCode(String ref);
    List<EscrowAccount> findByStatus(String status);
}
