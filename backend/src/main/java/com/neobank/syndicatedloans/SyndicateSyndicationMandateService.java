package com.neobank.syndicatedloans;
import java.util.List; import java.util.UUID;
public interface SyndicateSyndicationMandateService {
    List<SyndicateSyndicationMandateDto> getByUser(UUID userId);
    SyndicateSyndicationMandateDto create(SyndicateSyndicationMandateDto dto);
    SyndicateSyndicationMandateDto getByRef(String ref);
    void updateState(UUID id, String state);
    List<SyndicateSyndicationMandateDto> listAll();
}
