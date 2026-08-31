package com.neobank.investment;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface CorporateActionNoticeRepository extends JpaRepository<CorporateActionNotice, UUID> {
    List<CorporateActionNotice> findByUserId(UUID userId);
    Optional<CorporateActionNotice> findByIdentifierCode(String code);
    List<CorporateActionNotice> findByStatus(String status);
}
