package com.neobank.infrastructure;
import java.util.List; import java.util.UUID;
public interface KafkaEventMessageArchiveService {
    List<KafkaEventMessageArchiveDto> getByUser(UUID userId);
    KafkaEventMessageArchiveDto create(KafkaEventMessageArchiveDto dto);
    KafkaEventMessageArchiveDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<KafkaEventMessageArchiveDto> listAll();
}
