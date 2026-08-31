package com.neobank.support;
import java.util.List; import java.util.UUID;
public interface KnowledgeBaseArticleService {
    List<KnowledgeBaseArticleDto> getByUser(UUID userId);
    KnowledgeBaseArticleDto create(KnowledgeBaseArticleDto dto);
    KnowledgeBaseArticleDto getByKey(String key);
    void updateStatus(UUID id, String status);
    List<KnowledgeBaseArticleDto> listAll();
}
