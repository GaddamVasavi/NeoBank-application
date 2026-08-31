package com.neobank.commercial;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface BankGuaranteeBondRepository extends JpaRepository<BankGuaranteeBond, UUID> {
    List<BankGuaranteeBond> findByUserId(UUID userId);
    Optional<BankGuaranteeBond> findByIdentifierCode(String code);
    List<BankGuaranteeBond> findByStatus(String status);
}
