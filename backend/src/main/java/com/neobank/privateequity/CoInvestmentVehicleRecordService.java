package com.neobank.privateequity;
import java.util.List; import java.util.UUID;
public interface CoInvestmentVehicleRecordService {
    List<CoInvestmentVehicleRecordDto> getByUser(UUID userId);
    CoInvestmentVehicleRecordDto create(CoInvestmentVehicleRecordDto dto);
    CoInvestmentVehicleRecordDto getByRef(String ref);
    void updateState(UUID id, String state);
    List<CoInvestmentVehicleRecordDto> listAll();
}
