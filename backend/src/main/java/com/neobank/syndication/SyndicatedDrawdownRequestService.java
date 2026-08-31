package com.neobank.syndication;
import java.util.List; import java.util.UUID;
public interface SyndicatedDrawdownRequestService {
    List<SyndicatedDrawdownRequestDto> getByUser(UUID userId);
    SyndicatedDrawdownRequestDto create(SyndicatedDrawdownRequestDto dto);
    SyndicatedDrawdownRequestDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<SyndicatedDrawdownRequestDto> listAll();
}
