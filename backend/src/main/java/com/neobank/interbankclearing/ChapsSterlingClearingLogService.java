package com.neobank.interbankclearing;
import java.util.List; import java.util.UUID;
public interface ChapsSterlingClearingLogService {
    List<ChapsSterlingClearingLogDto> getByUser(UUID userId);
    ChapsSterlingClearingLogDto create(ChapsSterlingClearingLogDto dto);
    ChapsSterlingClearingLogDto getByRef(String ref);
    void updateState(UUID id, String state);
    List<ChapsSterlingClearingLogDto> listAll();
}
