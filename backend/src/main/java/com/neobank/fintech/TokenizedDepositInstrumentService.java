package com.neobank.fintech;
import java.util.List; import java.util.UUID;
public interface TokenizedDepositInstrumentService {
    List<TokenizedDepositInstrumentDto> getByUser(UUID userId);
    TokenizedDepositInstrumentDto create(TokenizedDepositInstrumentDto dto);
    TokenizedDepositInstrumentDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<TokenizedDepositInstrumentDto> listAll();
}
