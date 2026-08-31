package com.neobank.syndicatedloans;
import java.util.List; import java.util.UUID;
public interface SyndicatedRepaymentWaterfallService {
    List<SyndicatedRepaymentWaterfallDto> getByUser(UUID userId);
    SyndicatedRepaymentWaterfallDto create(SyndicatedRepaymentWaterfallDto dto);
    SyndicatedRepaymentWaterfallDto getByRef(String ref);
    void updateState(UUID id, String state);
    List<SyndicatedRepaymentWaterfallDto> listAll();
}
