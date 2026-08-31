package com.neobank.kyc;
import java.util.List; import java.util.UUID;
public interface KycDocumentArchiveService {
    List<KycDocumentArchiveDto> getByUser(UUID userId);
    KycDocumentArchiveDto create(KycDocumentArchiveDto dto);
    KycDocumentArchiveDto getByKey(String key);
    void updateStatus(UUID id, String status);
    List<KycDocumentArchiveDto> listAll();
}
