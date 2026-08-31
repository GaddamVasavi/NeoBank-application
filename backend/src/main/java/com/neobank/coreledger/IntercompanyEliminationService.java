package com.neobank.coreledger;
import java.util.List; import java.util.UUID;
public interface IntercompanyEliminationService {
    List<IntercompanyEliminationDto> getByUser(UUID userId);
    IntercompanyEliminationDto create(IntercompanyEliminationDto dto);
    IntercompanyEliminationDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<IntercompanyEliminationDto> listAll();
}
