package com.neobank.factoring;
import java.util.List; import java.util.UUID;
public interface DebtorCreditAssessmentLogService {
    List<DebtorCreditAssessmentLogDto> getByUser(UUID userId);
    DebtorCreditAssessmentLogDto create(DebtorCreditAssessmentLogDto dto);
    DebtorCreditAssessmentLogDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<DebtorCreditAssessmentLogDto> listAll();
}
