package com.neobank.digitalvault;
import java.util.List; import java.util.UUID;
public interface ZeroKnowledgeProofAttestationService {
    List<ZeroKnowledgeProofAttestationDto> getByUser(UUID userId);
    ZeroKnowledgeProofAttestationDto create(ZeroKnowledgeProofAttestationDto dto);
    ZeroKnowledgeProofAttestationDto getByRef(String ref);
    void updateState(UUID id, String state);
    List<ZeroKnowledgeProofAttestationDto> listAll();
}
