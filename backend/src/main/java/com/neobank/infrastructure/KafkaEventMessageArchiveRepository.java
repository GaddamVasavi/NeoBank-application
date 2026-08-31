package com.neobank.infrastructure;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface KafkaEventMessageArchiveRepository extends JpaRepository<KafkaEventMessageArchive, UUID> {
    List<KafkaEventMessageArchive> findByUserId(UUID userId);
    Optional<KafkaEventMessageArchive> findByDossierReference(String ref);
    List<KafkaEventMessageArchive> findByOperationalStatus(String status);
}
