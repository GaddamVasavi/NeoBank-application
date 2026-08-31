package com.neobank.identity;
import java.util.List; import java.util.UUID;
public interface DeviceTrustCertificateFileService {
    List<DeviceTrustCertificateFileDto> getByUser(UUID userId);
    DeviceTrustCertificateFileDto create(DeviceTrustCertificateFileDto dto);
    DeviceTrustCertificateFileDto getByKey(String key);
    void updateStatus(UUID id, String status);
    List<DeviceTrustCertificateFileDto> listAll();
}
