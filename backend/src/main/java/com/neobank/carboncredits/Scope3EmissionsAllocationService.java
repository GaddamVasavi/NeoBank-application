package com.neobank.carboncredits;
import java.util.List; import java.util.UUID;
public interface Scope3EmissionsAllocationService {
    List<Scope3EmissionsAllocationDto> getByUser(UUID userId);
    Scope3EmissionsAllocationDto create(Scope3EmissionsAllocationDto dto);
    Scope3EmissionsAllocationDto getByRef(String ref);
    void updateState(UUID id, String state);
    List<Scope3EmissionsAllocationDto> listAll();
}
