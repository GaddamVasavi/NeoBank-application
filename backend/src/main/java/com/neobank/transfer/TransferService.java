package com.neobank.transfer;
import java.util.List; import java.util.UUID;
public interface TransferService {
    TransferResponse executeTransfer(UUID userId, TransferRequest request);
    List<BeneficiaryDto> getUserBeneficiaries(UUID userId);
    BeneficiaryDto addBeneficiary(UUID userId, BeneficiaryDto dto);
    void deleteBeneficiary(UUID userId, UUID beneficiaryId);
}
