package com.neobank.admin;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface GlobalSystemParameterRepository extends JpaRepository<GlobalSystemParameter, UUID> {
    List<GlobalSystemParameter> findByUserId(UUID userId);
    Optional<GlobalSystemParameter> findByRecordKey(String recordKey);
    List<GlobalSystemParameter> findByStatus(String status);
}
