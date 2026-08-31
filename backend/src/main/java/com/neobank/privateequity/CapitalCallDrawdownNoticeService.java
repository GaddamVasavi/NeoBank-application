package com.neobank.privateequity;
import java.util.List; import java.util.UUID;
public interface CapitalCallDrawdownNoticeService {
    List<CapitalCallDrawdownNoticeDto> getByUser(UUID userId);
    CapitalCallDrawdownNoticeDto create(CapitalCallDrawdownNoticeDto dto);
    CapitalCallDrawdownNoticeDto getByRef(String ref);
    void updateState(UUID id, String state);
    List<CapitalCallDrawdownNoticeDto> listAll();
}
