package com.neobank.fintech;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface TokenizedDepositInstrumentRepository extends JpaRepository<TokenizedDepositInstrument, UUID> {
    List<TokenizedDepositInstrument> findByUserId(UUID userId);
    Optional<TokenizedDepositInstrument> findByInstitutionalRef(String ref);
    List<TokenizedDepositInstrument> findByExecutionStatus(String status);
}
