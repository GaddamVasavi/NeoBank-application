package com.neobank.syndication;
import java.util.List; import java.util.UUID;
public interface DebtSyndicationTrancheService {
    List<DebtSyndicationTrancheDto> getByUser(UUID userId);
    DebtSyndicationTrancheDto create(DebtSyndicationTrancheDto dto);
    DebtSyndicationTrancheDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<DebtSyndicationTrancheDto> listAll();
}
