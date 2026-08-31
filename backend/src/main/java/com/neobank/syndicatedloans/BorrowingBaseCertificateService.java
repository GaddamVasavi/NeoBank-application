package com.neobank.syndicatedloans;
import java.util.List; import java.util.UUID;
public interface BorrowingBaseCertificateService {
    List<BorrowingBaseCertificateDto> getByUser(UUID userId);
    BorrowingBaseCertificateDto create(BorrowingBaseCertificateDto dto);
    BorrowingBaseCertificateDto getByRef(String ref);
    void updateState(UUID id, String state);
    List<BorrowingBaseCertificateDto> listAll();
}
