package com.neobank.card;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface CardDesignThemeRepository extends JpaRepository<CardDesignTheme, UUID> {
    List<CardDesignTheme> findByUserId(UUID userId);
    Optional<CardDesignTheme> findByRecordKey(String recordKey);
    List<CardDesignTheme> findByStatus(String status);
}
