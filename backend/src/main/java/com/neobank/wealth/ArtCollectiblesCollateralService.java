package com.neobank.wealth;
import java.util.List; import java.util.UUID;
public interface ArtCollectiblesCollateralService {
    List<ArtCollectiblesCollateralDto> getByUser(UUID userId);
    ArtCollectiblesCollateralDto create(ArtCollectiblesCollateralDto dto);
    ArtCollectiblesCollateralDto getByCode(String code);
    void updateState(UUID id, String state);
    List<ArtCollectiblesCollateralDto> listAll();
}
