package com.neobank.corporate;
import java.util.List; import java.util.UUID;
public interface CommercialPaperProgramService {
    List<CommercialPaperProgramDto> getByUser(UUID userId);
    CommercialPaperProgramDto create(CommercialPaperProgramDto dto);
    CommercialPaperProgramDto getByCode(String code);
    void updateState(UUID id, String state);
    List<CommercialPaperProgramDto> listAll();
}
