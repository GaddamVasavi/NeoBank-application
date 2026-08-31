package com.finverse.kyc;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for ProofOfAddressDocument
 */
public interface ProofOfAddressDocumentService {

    List<ProofOfAddressDocumentDto> getByTenant(UUID tenantId);

    List<ProofOfAddressDocumentDto> getByUser(UUID userId);

    ProofOfAddressDocumentDto create(ProofOfAddressDocumentDto dto);

    ProofOfAddressDocumentDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<ProofOfAddressDocumentDto> listAll();
}
