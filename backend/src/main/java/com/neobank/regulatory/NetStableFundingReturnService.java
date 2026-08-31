package com.neobank.regulatory;
import java.util.List; import java.util.UUID;
public interface NetStableFundingReturnService {
    List<NetStableFundingReturnDto> getByUser(UUID userId);
    NetStableFundingReturnDto create(NetStableFundingReturnDto dto);
    NetStableFundingReturnDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<NetStableFundingReturnDto> listAll();
}
