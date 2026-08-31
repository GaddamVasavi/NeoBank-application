package com.neobank.syndication;
import java.util.List; import java.util.UUID;
public interface AgencyNoticeDistributionLogService {
    List<AgencyNoticeDistributionLogDto> getByUser(UUID userId);
    AgencyNoticeDistributionLogDto create(AgencyNoticeDistributionLogDto dto);
    AgencyNoticeDistributionLogDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<AgencyNoticeDistributionLogDto> listAll();
}
