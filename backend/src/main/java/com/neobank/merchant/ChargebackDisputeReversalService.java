package com.neobank.merchant;
import java.util.List; import java.util.UUID;
public interface ChargebackDisputeReversalService {
    List<ChargebackDisputeReversalDto> getByUser(UUID userId);
    ChargebackDisputeReversalDto create(ChargebackDisputeReversalDto dto);
    ChargebackDisputeReversalDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<ChargebackDisputeReversalDto> listAll();
}
