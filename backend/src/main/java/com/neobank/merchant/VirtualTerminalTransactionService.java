package com.neobank.merchant;
import java.util.List; import java.util.UUID;
public interface VirtualTerminalTransactionService {
    List<VirtualTerminalTransactionDto> getByUser(UUID userId);
    VirtualTerminalTransactionDto create(VirtualTerminalTransactionDto dto);
    VirtualTerminalTransactionDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<VirtualTerminalTransactionDto> listAll();
}
