package com.neobank.privateequity;
import java.util.List; import java.util.UUID;
public interface FundDistributionWaterfallService {
    List<FundDistributionWaterfallDto> getByUser(UUID userId);
    FundDistributionWaterfallDto create(FundDistributionWaterfallDto dto);
    FundDistributionWaterfallDto getByRef(String ref);
    void updateState(UUID id, String state);
    List<FundDistributionWaterfallDto> listAll();
}
