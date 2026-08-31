package com.neobank.openbanking;
import java.util.List; import java.util.UUID;
public interface Psd2ConsentRecordService {
    List<Psd2ConsentRecordDto> getByUser(UUID userId);
    Psd2ConsentRecordDto create(Psd2ConsentRecordDto dto);
    Psd2ConsentRecordDto getByCode(String code);
    void updateState(UUID id, String state);
    List<Psd2ConsentRecordDto> listAll();
}
