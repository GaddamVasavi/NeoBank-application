package com.neobank.treasuryoperations;
import java.util.List; import java.util.UUID;
public interface NonDeliverableOptionSurfaceService {
    List<NonDeliverableOptionSurfaceDto> getByUser(UUID userId);
    NonDeliverableOptionSurfaceDto create(NonDeliverableOptionSurfaceDto dto);
    NonDeliverableOptionSurfaceDto getByIdentifier(String id);
    void updateStatus(UUID id, String status);
    List<NonDeliverableOptionSurfaceDto> listAll();
}
