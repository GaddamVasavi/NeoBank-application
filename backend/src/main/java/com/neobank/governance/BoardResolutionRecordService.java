package com.neobank.governance;
import java.util.List; import java.util.UUID;
public interface BoardResolutionRecordService {
    List<BoardResolutionRecordDto> getByUser(UUID userId);
    BoardResolutionRecordDto create(BoardResolutionRecordDto dto);
    BoardResolutionRecordDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<BoardResolutionRecordDto> listAll();
}
