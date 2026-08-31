package com.neobank.corepayments;
import java.util.List; import java.util.UUID;
public interface RealTimePaymentsRtpTransactionService {
    List<RealTimePaymentsRtpTransactionDto> getByUser(UUID userId);
    RealTimePaymentsRtpTransactionDto create(RealTimePaymentsRtpTransactionDto dto);
    RealTimePaymentsRtpTransactionDto getByKey(String key);
    void updateStatus(UUID id, String status);
    List<RealTimePaymentsRtpTransactionDto> listAll();
}
