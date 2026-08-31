package com.neobank.digitalvault;
import java.util.List; import java.util.UUID;
public interface MultiPartyComputationShareService {
    List<MultiPartyComputationShareDto> getByUser(UUID userId);
    MultiPartyComputationShareDto create(MultiPartyComputationShareDto dto);
    MultiPartyComputationShareDto getByRef(String ref);
    void updateState(UUID id, String state);
    List<MultiPartyComputationShareDto> listAll();
}
