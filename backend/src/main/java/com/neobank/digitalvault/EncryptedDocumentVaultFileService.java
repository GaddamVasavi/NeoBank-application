package com.neobank.digitalvault;
import java.util.List; import java.util.UUID;
public interface EncryptedDocumentVaultFileService {
    List<EncryptedDocumentVaultFileDto> getByUser(UUID userId);
    EncryptedDocumentVaultFileDto create(EncryptedDocumentVaultFileDto dto);
    EncryptedDocumentVaultFileDto getByRef(String ref);
    void updateState(UUID id, String state);
    List<EncryptedDocumentVaultFileDto> listAll();
}
