package com.neobank.auditcompliance;
import java.util.List; import java.util.UUID;
public interface InternalControlDeficiencyFileService {
    List<InternalControlDeficiencyFileDto> getByUser(UUID userId);
    InternalControlDeficiencyFileDto create(InternalControlDeficiencyFileDto dto);
    InternalControlDeficiencyFileDto getByKey(String key);
    void updateStatus(UUID id, String status);
    List<InternalControlDeficiencyFileDto> listAll();
}
