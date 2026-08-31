package com.neobank.transfer;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository
public interface TransferRepository extends JpaRepository<Transfer, UUID> {
    List<Transfer> findBySourceAccountIdOrderByCreatedAtDesc(UUID accountId);
    Optional<Transfer> findByIdempotencyKey(String key);
}
