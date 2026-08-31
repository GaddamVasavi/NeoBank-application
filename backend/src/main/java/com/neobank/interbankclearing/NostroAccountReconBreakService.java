package com.neobank.interbankclearing;
import java.util.List; import java.util.UUID;
public interface NostroAccountReconBreakService {
    List<NostroAccountReconBreakDto> getByUser(UUID userId);
    NostroAccountReconBreakDto create(NostroAccountReconBreakDto dto);
    NostroAccountReconBreakDto getByRef(String ref);
    void updateState(UUID id, String state);
    List<NostroAccountReconBreakDto> listAll();
}
