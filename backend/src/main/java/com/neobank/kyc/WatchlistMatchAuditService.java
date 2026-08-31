package com.neobank.kyc;
import java.util.List; import java.util.UUID;
public interface WatchlistMatchAuditService {
    List<WatchlistMatchAuditDto> getByUser(UUID userId);
    WatchlistMatchAuditDto create(WatchlistMatchAuditDto dto);
    WatchlistMatchAuditDto getByKey(String key);
    void updateStatus(UUID id, String status);
    List<WatchlistMatchAuditDto> listAll();
}
