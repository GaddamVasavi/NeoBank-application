package com.neobank.carboncredits;
import java.util.List; import java.util.UUID;
public interface EsgScorecardAssessmentService {
    List<EsgScorecardAssessmentDto> getByUser(UUID userId);
    EsgScorecardAssessmentDto create(EsgScorecardAssessmentDto dto);
    EsgScorecardAssessmentDto getByRef(String ref);
    void updateState(UUID id, String state);
    List<EsgScorecardAssessmentDto> listAll();
}
