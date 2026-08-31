package com.neobank.wealth;
import java.util.List; import java.util.UUID;
public interface PrivateEquityCommitmentService {
    List<PrivateEquityCommitmentDto> getByUser(UUID userId);
    PrivateEquityCommitmentDto create(PrivateEquityCommitmentDto dto);
    PrivateEquityCommitmentDto getByCode(String code);
    void updateState(UUID id, String state);
    List<PrivateEquityCommitmentDto> listAll();
}
