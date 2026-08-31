package com.neobank.leasing;
import java.util.List; import java.util.UUID;
public interface EndOfLeasePurchaseOptionService {
    List<EndOfLeasePurchaseOptionDto> getByUser(UUID userId);
    EndOfLeasePurchaseOptionDto create(EndOfLeasePurchaseOptionDto dto);
    EndOfLeasePurchaseOptionDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<EndOfLeasePurchaseOptionDto> listAll();
}
