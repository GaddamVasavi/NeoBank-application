package com.neobank.factoring;
import java.util.List; import java.util.UUID;
public interface ReverseFactoringProgramService {
    List<ReverseFactoringProgramDto> getByUser(UUID userId);
    ReverseFactoringProgramDto create(ReverseFactoringProgramDto dto);
    ReverseFactoringProgramDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<ReverseFactoringProgramDto> listAll();
}
