package com.neobank.privateequity;
import java.util.List; import java.util.UUID;
public interface LimitedPartnerCommitmentService {
    List<LimitedPartnerCommitmentDto> getByUser(UUID userId);
    LimitedPartnerCommitmentDto create(LimitedPartnerCommitmentDto dto);
    LimitedPartnerCommitmentDto getByRef(String ref);
    void updateState(UUID id, String state);
    List<LimitedPartnerCommitmentDto> listAll();
}
