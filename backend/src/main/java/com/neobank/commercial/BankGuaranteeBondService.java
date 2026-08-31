package com.neobank.commercial;
import java.util.List; import java.util.UUID;
public interface BankGuaranteeBondService {
    List<BankGuaranteeBondDto> getByUser(UUID userId);
    BankGuaranteeBondDto create(BankGuaranteeBondDto dto);
    BankGuaranteeBondDto getByCode(String code);
    void updateStatus(UUID id, String status);
    List<BankGuaranteeBondDto> listAll();
}
