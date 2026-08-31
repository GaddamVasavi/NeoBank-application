package com.neobank.wealth;
import java.util.List; import java.util.UUID;
public interface FamilyOfficeStructureService {
    List<FamilyOfficeStructureDto> getByUser(UUID userId);
    FamilyOfficeStructureDto create(FamilyOfficeStructureDto dto);
    FamilyOfficeStructureDto getByCode(String code);
    void updateState(UUID id, String state);
    List<FamilyOfficeStructureDto> listAll();
}
