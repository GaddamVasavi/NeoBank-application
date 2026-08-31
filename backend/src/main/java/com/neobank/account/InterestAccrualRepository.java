package com.neobank.account;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.UUID;
@Repository public interface InterestAccrualRepository extends JpaRepository<InterestAccrual, UUID> {
    List<InterestAccrual> findByAccountIdAndPostedFalse(UUID accountId);
}
