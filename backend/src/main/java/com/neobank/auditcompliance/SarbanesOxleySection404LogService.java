package com.neobank.auditcompliance;
import java.util.List; import java.util.UUID;
public interface SarbanesOxleySection404LogService {
    List<SarbanesOxleySection404LogDto> getByUser(UUID userId);
    SarbanesOxleySection404LogDto create(SarbanesOxleySection404LogDto dto);
    SarbanesOxleySection404LogDto getByKey(String key);
    void updateStatus(UUID id, String status);
    List<SarbanesOxleySection404LogDto> listAll();
}
