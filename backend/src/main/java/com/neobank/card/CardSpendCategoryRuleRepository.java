package com.neobank.card;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface CardSpendCategoryRuleRepository extends JpaRepository<CardSpendCategoryRule, UUID> {
    List<CardSpendCategoryRule> findByUserId(UUID userId);
    Optional<CardSpendCategoryRule> findByCodeReference(String ref);
    List<CardSpendCategoryRule> findByStatus(String status);
}
