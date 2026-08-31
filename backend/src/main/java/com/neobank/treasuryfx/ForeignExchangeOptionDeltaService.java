package com.neobank.treasuryfx;
import java.util.List; import java.util.UUID;
public interface ForeignExchangeOptionDeltaService {
    List<ForeignExchangeOptionDeltaDto> getByUser(UUID userId);
    ForeignExchangeOptionDeltaDto create(ForeignExchangeOptionDeltaDto dto);
    ForeignExchangeOptionDeltaDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<ForeignExchangeOptionDeltaDto> listAll();
}
