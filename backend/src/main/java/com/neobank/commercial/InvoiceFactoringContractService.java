package com.neobank.commercial;
import java.util.List; import java.util.UUID;
public interface InvoiceFactoringContractService {
    List<InvoiceFactoringContractDto> getByUser(UUID userId);
    InvoiceFactoringContractDto create(InvoiceFactoringContractDto dto);
    InvoiceFactoringContractDto getByCode(String code);
    void updateStatus(UUID id, String status);
    List<InvoiceFactoringContractDto> listAll();
}
