package com.neobank.kyc;
import java.util.List; import java.util.UUID;
public interface SourceOfFundsDeclarationService {
    List<SourceOfFundsDeclarationDto> getByUser(UUID userId);
    SourceOfFundsDeclarationDto create(SourceOfFundsDeclarationDto dto);
    SourceOfFundsDeclarationDto getByKey(String key);
    void updateStatus(UUID id, String status);
    List<SourceOfFundsDeclarationDto> listAll();
}
