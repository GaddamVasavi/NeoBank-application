package com.neobank.securities;
import java.util.List; import java.util.UUID;
public interface StructuredNoteValuationLogService {
    List<StructuredNoteValuationLogDto> getByUser(UUID userId);
    StructuredNoteValuationLogDto create(StructuredNoteValuationLogDto dto);
    StructuredNoteValuationLogDto getByIdentifier(String id);
    void updateState(UUID id, String state);
    List<StructuredNoteValuationLogDto> listAll();
}
