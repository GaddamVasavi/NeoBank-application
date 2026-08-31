package com.neobank.custody;
import java.util.List; import java.util.UUID;
public interface WithholdingTaxReclaimLogService {
    List<WithholdingTaxReclaimLogDto> getByUser(UUID userId);
    WithholdingTaxReclaimLogDto create(WithholdingTaxReclaimLogDto dto);
    WithholdingTaxReclaimLogDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<WithholdingTaxReclaimLogDto> listAll();
}
