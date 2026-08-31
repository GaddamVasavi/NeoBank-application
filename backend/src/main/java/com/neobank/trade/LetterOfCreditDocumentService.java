package com.neobank.trade;
import java.util.List; import java.util.UUID;
public interface LetterOfCreditDocumentService {
    List<LetterOfCreditDocumentDto> getByUser(UUID userId);
    LetterOfCreditDocumentDto create(LetterOfCreditDocumentDto dto);
    LetterOfCreditDocumentDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<LetterOfCreditDocumentDto> listAll();
}
