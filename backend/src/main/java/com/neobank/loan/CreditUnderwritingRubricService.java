package com.neobank.loan;
import java.util.List; import java.util.UUID;
public interface CreditUnderwritingRubricService {
    List<CreditUnderwritingRubricDto> getByUser(UUID userId);
    CreditUnderwritingRubricDto create(CreditUnderwritingRubricDto dto);
    CreditUnderwritingRubricDto getByKey(String key);
    void updateStatus(UUID id, String status);
    List<CreditUnderwritingRubricDto> listAll();
}
