package com.neobank.interbankclearing;
import java.util.List; import java.util.UUID;
public interface Iso20022Pacs009FinancialService {
    List<Iso20022Pacs009FinancialDto> getByUser(UUID userId);
    Iso20022Pacs009FinancialDto create(Iso20022Pacs009FinancialDto dto);
    Iso20022Pacs009FinancialDto getByRef(String ref);
    void updateState(UUID id, String state);
    List<Iso20022Pacs009FinancialDto> listAll();
}
