package com.neobank.account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface JointAccountHolderRepository extends JpaRepository<JointAccountHolder, UUID> {
    List<JointAccountHolder> findByAccountId(UUID accountId);
    Optional<JointAccountHolder> findByReferenceCode(String ref);
    List<JointAccountHolder> findByStatus(String status);
}
