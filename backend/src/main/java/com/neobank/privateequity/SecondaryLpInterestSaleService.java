package com.neobank.privateequity;
import java.util.List; import java.util.UUID;
public interface SecondaryLpInterestSaleService {
    List<SecondaryLpInterestSaleDto> getByUser(UUID userId);
    SecondaryLpInterestSaleDto create(SecondaryLpInterestSaleDto dto);
    SecondaryLpInterestSaleDto getByRef(String ref);
    void updateState(UUID id, String state);
    List<SecondaryLpInterestSaleDto> listAll();
}
