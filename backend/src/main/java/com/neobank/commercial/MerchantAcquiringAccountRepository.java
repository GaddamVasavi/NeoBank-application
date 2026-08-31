package com.neobank.commercial;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface MerchantAcquiringAccountRepository extends JpaRepository<MerchantAcquiringAccount, UUID> {
    List<MerchantAcquiringAccount> findByUserId(UUID userId);
    Optional<MerchantAcquiringAccount> findByIdentifierCode(String code);
    List<MerchantAcquiringAccount> findByStatus(String status);
}
