package com.neobank.auth;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.UUID;
@Repository public interface PasswordHistoryRepository extends JpaRepository<PasswordHistory, UUID> {
    List<PasswordHistory> findTop5ByUserIdOrderByCreatedAtDesc(UUID userId);
}
