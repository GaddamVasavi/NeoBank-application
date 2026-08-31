package com.neobank.wealth;
import java.util.List; import java.util.UUID;
public interface DiscretionaryMandateService {
    List<DiscretionaryMandateDto> getByUser(UUID userId);
    DiscretionaryMandateDto create(DiscretionaryMandateDto dto);
    DiscretionaryMandateDto getByCode(String code);
    void updateState(UUID id, String state);
    List<DiscretionaryMandateDto> listAll();
}
