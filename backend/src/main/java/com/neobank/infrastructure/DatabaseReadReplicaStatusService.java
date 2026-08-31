package com.neobank.infrastructure;
import java.util.List; import java.util.UUID;
public interface DatabaseReadReplicaStatusService {
    List<DatabaseReadReplicaStatusDto> getByUser(UUID userId);
    DatabaseReadReplicaStatusDto create(DatabaseReadReplicaStatusDto dto);
    DatabaseReadReplicaStatusDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<DatabaseReadReplicaStatusDto> listAll();
}
