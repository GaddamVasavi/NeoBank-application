package com.neobank.infrastructure;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface DatabaseReadReplicaStatusRepository extends JpaRepository<DatabaseReadReplicaStatus, UUID> {
    List<DatabaseReadReplicaStatus> findByUserId(UUID userId);
    Optional<DatabaseReadReplicaStatus> findByDossierReference(String ref);
    List<DatabaseReadReplicaStatus> findByOperationalStatus(String status);
}
