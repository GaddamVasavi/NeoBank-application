package com.neobank.digitalvault;
import java.util.List; import java.util.UUID;
public interface PostQuantumKeyExchangeLogService {
    List<PostQuantumKeyExchangeLogDto> getByUser(UUID userId);
    PostQuantumKeyExchangeLogDto create(PostQuantumKeyExchangeLogDto dto);
    PostQuantumKeyExchangeLogDto getByRef(String ref);
    void updateState(UUID id, String state);
    List<PostQuantumKeyExchangeLogDto> listAll();
}
