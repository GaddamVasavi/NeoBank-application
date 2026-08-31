package com.neobank.settlement;
import java.util.List; import java.util.UUID;
public interface ChapsSterlingPaymentService {
    List<ChapsSterlingPaymentDto> getByUser(UUID userId);
    ChapsSterlingPaymentDto create(ChapsSterlingPaymentDto dto);
    ChapsSterlingPaymentDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<ChapsSterlingPaymentDto> listAll();
}
