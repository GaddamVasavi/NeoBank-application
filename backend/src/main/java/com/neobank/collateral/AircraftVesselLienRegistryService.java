package com.neobank.collateral;
import java.util.List; import java.util.UUID;
public interface AircraftVesselLienRegistryService {
    List<AircraftVesselLienRegistryDto> getByUser(UUID userId);
    AircraftVesselLienRegistryDto create(AircraftVesselLienRegistryDto dto);
    AircraftVesselLienRegistryDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<AircraftVesselLienRegistryDto> listAll();
}
