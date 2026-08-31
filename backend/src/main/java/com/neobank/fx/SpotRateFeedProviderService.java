package com.neobank.fx;
import java.util.List; import java.util.UUID;
public interface SpotRateFeedProviderService {
    List<SpotRateFeedProviderDto> getByUser(UUID userId);
    SpotRateFeedProviderDto create(SpotRateFeedProviderDto dto);
    SpotRateFeedProviderDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<SpotRateFeedProviderDto> listAll();
}
