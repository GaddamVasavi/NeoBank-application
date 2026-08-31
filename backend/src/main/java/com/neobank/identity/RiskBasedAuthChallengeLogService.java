package com.neobank.identity;
import java.util.List; import java.util.UUID;
public interface RiskBasedAuthChallengeLogService {
    List<RiskBasedAuthChallengeLogDto> getByUser(UUID userId);
    RiskBasedAuthChallengeLogDto create(RiskBasedAuthChallengeLogDto dto);
    RiskBasedAuthChallengeLogDto getByKey(String key);
    void updateStatus(UUID id, String status);
    List<RiskBasedAuthChallengeLogDto> listAll();
}
