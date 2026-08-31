package com.neobank.factoring;
import java.util.List; import java.util.UUID;
public interface RecourseCollectionLedgerService {
    List<RecourseCollectionLedgerDto> getByUser(UUID userId);
    RecourseCollectionLedgerDto create(RecourseCollectionLedgerDto dto);
    RecourseCollectionLedgerDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<RecourseCollectionLedgerDto> listAll();
}
