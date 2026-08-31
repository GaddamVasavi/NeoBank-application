package com.neobank.kyc;
import java.util.List; import java.util.UUID;
public interface ProofOfAddressRecordService {
    List<ProofOfAddressRecordDto> getByUser(UUID userId);
    ProofOfAddressRecordDto create(ProofOfAddressRecordDto dto);
    ProofOfAddressRecordDto getByKey(String key);
    void updateStatus(UUID id, String status);
    List<ProofOfAddressRecordDto> listAll();
}
