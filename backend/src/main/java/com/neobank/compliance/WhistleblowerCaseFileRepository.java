package com.neobank.compliance;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface WhistleblowerCaseFileRepository extends JpaRepository<WhistleblowerCaseFile, UUID> {
    List<WhistleblowerCaseFile> findByUserId(UUID userId);
    Optional<WhistleblowerCaseFile> findByIdentifierCode(String code);
    List<WhistleblowerCaseFile> findByStatus(String status);
}
