package com.neobank.merchant;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface InterchangeFeeScheduleLogRepository extends JpaRepository<InterchangeFeeScheduleLog, UUID> {
    List<InterchangeFeeScheduleLog> findByUserId(UUID userId);
    Optional<InterchangeFeeScheduleLog> findByCoreReference(String ref);
    List<InterchangeFeeScheduleLog> findByProcessingStatus(String status);
}
