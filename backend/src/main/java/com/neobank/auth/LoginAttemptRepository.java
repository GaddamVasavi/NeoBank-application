package com.neobank.auth;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.time.Instant; import java.util.UUID;
@Repository public interface LoginAttemptRepository extends JpaRepository<LoginAttempt, UUID> {
    long countByUsernameOrEmailAndSuccessFalseAndAttemptedAtAfter(String target, Instant after);
}
