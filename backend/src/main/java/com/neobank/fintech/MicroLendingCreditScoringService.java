package com.neobank.fintech;
import java.util.List; import java.util.UUID;
public interface MicroLendingCreditScoringService {
    List<MicroLendingCreditScoringDto> getByUser(UUID userId);
    MicroLendingCreditScoringDto create(MicroLendingCreditScoringDto dto);
    MicroLendingCreditScoringDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<MicroLendingCreditScoringDto> listAll();
}
