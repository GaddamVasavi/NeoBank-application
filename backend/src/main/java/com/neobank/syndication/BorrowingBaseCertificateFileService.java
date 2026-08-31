package com.neobank.syndication;
import java.util.List; import java.util.UUID;
public interface BorrowingBaseCertificateFileService {
    List<BorrowingBaseCertificateFileDto> getByUser(UUID userId);
    BorrowingBaseCertificateFileDto create(BorrowingBaseCertificateFileDto dto);
    BorrowingBaseCertificateFileDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<BorrowingBaseCertificateFileDto> listAll();
}
