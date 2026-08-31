package com.neobank.regulatory;
import java.util.List; import java.util.UUID;
public interface PrudentialReportingFileService {
    List<PrudentialReportingFileDto> getByUser(UUID userId);
    PrudentialReportingFileDto create(PrudentialReportingFileDto dto);
    PrudentialReportingFileDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<PrudentialReportingFileDto> listAll();
}
