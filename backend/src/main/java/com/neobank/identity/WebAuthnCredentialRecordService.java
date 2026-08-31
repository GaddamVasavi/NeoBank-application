package com.neobank.identity;
import java.util.List; import java.util.UUID;
public interface WebAuthnCredentialRecordService {
    List<WebAuthnCredentialRecordDto> getByUser(UUID userId);
    WebAuthnCredentialRecordDto create(WebAuthnCredentialRecordDto dto);
    WebAuthnCredentialRecordDto getByKey(String key);
    void updateStatus(UUID id, String status);
    List<WebAuthnCredentialRecordDto> listAll();
}
