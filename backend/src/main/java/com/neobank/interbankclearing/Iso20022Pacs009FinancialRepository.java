package com.neobank.interbankclearing;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface Iso20022Pacs009FinancialRepository extends JpaRepository<Iso20022Pacs009Financial, UUID> {
    List<Iso20022Pacs009Financial> findByUserId(UUID userId);
    Optional<Iso20022Pacs009Financial> findByProtocolReference(String ref);
    List<Iso20022Pacs009Financial> findByOperationalState(String state);
}
