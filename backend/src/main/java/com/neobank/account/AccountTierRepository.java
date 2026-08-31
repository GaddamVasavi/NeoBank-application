package com.neobank.account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface AccountTierRepository extends JpaRepository<AccountTier, UUID> {
    List<AccountTier> findByAccountId(UUID accountId);
    Optional<AccountTier> findByReferenceCode(String ref);
    List<AccountTier> findByStatus(String status);
}
