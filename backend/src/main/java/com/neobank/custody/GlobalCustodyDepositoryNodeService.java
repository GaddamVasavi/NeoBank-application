package com.neobank.custody;
import java.util.List; import java.util.UUID;
public interface GlobalCustodyDepositoryNodeService {
    List<GlobalCustodyDepositoryNodeDto> getByUser(UUID userId);
    GlobalCustodyDepositoryNodeDto create(GlobalCustodyDepositoryNodeDto dto);
    GlobalCustodyDepositoryNodeDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<GlobalCustodyDepositoryNodeDto> listAll();
}
