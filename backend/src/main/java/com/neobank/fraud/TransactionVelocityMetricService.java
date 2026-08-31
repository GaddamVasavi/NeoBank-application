package com.neobank.fraud;
import java.util.List; import java.util.UUID;
public interface TransactionVelocityMetricService {
    List<TransactionVelocityMetricDto> getByUser(UUID userId);
    TransactionVelocityMetricDto create(TransactionVelocityMetricDto dto);
    TransactionVelocityMetricDto getByKey(String key);
    void updateStatus(UUID id, String status);
    List<TransactionVelocityMetricDto> listAll();
}
