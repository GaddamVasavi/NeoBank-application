package com.neobank.auditcompliance;
import java.util.List; import java.util.UUID;
public interface SupervisoryStressTestPackageService {
    List<SupervisoryStressTestPackageDto> getByUser(UUID userId);
    SupervisoryStressTestPackageDto create(SupervisoryStressTestPackageDto dto);
    SupervisoryStressTestPackageDto getByKey(String key);
    void updateStatus(UUID id, String status);
    List<SupervisoryStressTestPackageDto> listAll();
}
