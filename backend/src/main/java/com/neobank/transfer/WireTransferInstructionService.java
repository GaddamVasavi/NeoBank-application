package com.neobank.transfer;
import java.util.List; import java.util.UUID;
public interface WireTransferInstructionService {
    List<WireTransferInstructionDto> getByAccount(UUID accountId);
    WireTransferInstructionDto create(WireTransferInstructionDto dto);
    WireTransferInstructionDto getByTrackingNumber(String trackingNumber);
    void process(UUID id);
}
