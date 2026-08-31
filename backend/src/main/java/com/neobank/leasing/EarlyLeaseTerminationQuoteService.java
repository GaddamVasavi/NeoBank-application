package com.neobank.leasing;
import java.util.List; import java.util.UUID;
public interface EarlyLeaseTerminationQuoteService {
    List<EarlyLeaseTerminationQuoteDto> getByUser(UUID userId);
    EarlyLeaseTerminationQuoteDto create(EarlyLeaseTerminationQuoteDto dto);
    EarlyLeaseTerminationQuoteDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<EarlyLeaseTerminationQuoteDto> listAll();
}
