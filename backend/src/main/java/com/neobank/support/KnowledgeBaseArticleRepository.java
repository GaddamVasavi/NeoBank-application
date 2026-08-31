package com.neobank.support;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface KnowledgeBaseArticleRepository extends JpaRepository<KnowledgeBaseArticle, UUID> {
    List<KnowledgeBaseArticle> findByUserId(UUID userId);
    Optional<KnowledgeBaseArticle> findByRecordKey(String recordKey);
    List<KnowledgeBaseArticle> findByStatus(String status);
}
