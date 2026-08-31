package com.neobank.treasuryfx;
import java.util.List; import java.util.UUID;
public interface BondConvexityMetricRecordService {
    List<BondConvexityMetricRecordDto> getByUser(UUID userId);
    BondConvexityMetricRecordDto create(BondConvexityMetricRecordDto dto);
    BondConvexityMetricRecordDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<BondConvexityMetricRecordDto> listAll();
}
