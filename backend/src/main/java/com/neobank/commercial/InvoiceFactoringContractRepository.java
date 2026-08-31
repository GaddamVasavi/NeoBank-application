package com.neobank.commercial;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface InvoiceFactoringContractRepository extends JpaRepository<InvoiceFactoringContract, UUID> {
    List<InvoiceFactoringContract> findByUserId(UUID userId);
    Optional<InvoiceFactoringContract> findByIdentifierCode(String code);
    List<InvoiceFactoringContract> findByStatus(String status);
}
