package com.neobank.settlement;
import java.util.List; import java.util.UUID;
public interface EurosystemCollateralPoolService {
    List<EurosystemCollateralPoolDto> getByUser(UUID userId);
    EurosystemCollateralPoolDto create(EurosystemCollateralPoolDto dto);
    EurosystemCollateralPoolDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<EurosystemCollateralPoolDto> listAll();
}
