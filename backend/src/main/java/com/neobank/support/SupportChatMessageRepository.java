package com.neobank.support;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface SupportChatMessageRepository extends JpaRepository<SupportChatMessage, UUID> {
    List<SupportChatMessage> findByUserId(UUID userId);
    Optional<SupportChatMessage> findByRecordKey(String recordKey);
    List<SupportChatMessage> findByStatus(String status);
}
