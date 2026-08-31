package com.neobank.crypto;
import java.util.List; import java.util.UUID;
public interface DecentralizedIdentityProofService {
    List<DecentralizedIdentityProofDto> getByUser(UUID userId);
    DecentralizedIdentityProofDto create(DecentralizedIdentityProofDto dto);
    DecentralizedIdentityProofDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<DecentralizedIdentityProofDto> listAll();
}
