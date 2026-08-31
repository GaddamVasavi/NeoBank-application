package com.neobank.governance;
import java.util.List; import java.util.UUID;
public interface RelatedPartyTransactionLogService {
    List<RelatedPartyTransactionLogDto> getByUser(UUID userId);
    RelatedPartyTransactionLogDto create(RelatedPartyTransactionLogDto dto);
    RelatedPartyTransactionLogDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<RelatedPartyTransactionLogDto> listAll();
}
