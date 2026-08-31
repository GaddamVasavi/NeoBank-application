package com.neobank.loan;
import java.util.List; import java.util.UUID;
public interface CollateralEvaluationService {
    List<CollateralEvaluationDto> getByUser(UUID userId);
    CollateralEvaluationDto create(CollateralEvaluationDto dto);
    CollateralEvaluationDto getByRef(String ref);
    void updateStatus(UUID id, String status);
}
