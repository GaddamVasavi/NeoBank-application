package com.neobank.account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface SubAccountRepository extends JpaRepository<SubAccount, UUID> {
    List<SubAccount> findByAccountId(UUID accountId);
    Optional<SubAccount> findByReferenceCode(String ref);
    List<SubAccount> findByStatus(String status);
}
