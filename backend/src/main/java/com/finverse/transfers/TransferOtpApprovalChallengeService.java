package com.finverse.transfers;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for TransferOtpApprovalChallenge
 */
public interface TransferOtpApprovalChallengeService {

    List<TransferOtpApprovalChallengeDto> getByTenant(UUID tenantId);

    List<TransferOtpApprovalChallengeDto> getByUser(UUID userId);

    TransferOtpApprovalChallengeDto create(TransferOtpApprovalChallengeDto dto);

    TransferOtpApprovalChallengeDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<TransferOtpApprovalChallengeDto> listAll();
}
