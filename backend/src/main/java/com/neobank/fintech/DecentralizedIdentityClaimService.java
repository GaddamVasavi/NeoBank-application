package com.neobank.fintech;
import java.util.List; import java.util.UUID;
public interface DecentralizedIdentityClaimService {
    List<DecentralizedIdentityClaimDto> getByUser(UUID userId);
    DecentralizedIdentityClaimDto create(DecentralizedIdentityClaimDto dto);
    DecentralizedIdentityClaimDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<DecentralizedIdentityClaimDto> listAll();
}
