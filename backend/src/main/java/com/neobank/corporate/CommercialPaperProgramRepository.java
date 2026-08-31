package com.neobank.corporate;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface CommercialPaperProgramRepository extends JpaRepository<CommercialPaperProgram, UUID> {
    List<CommercialPaperProgram> findByUserId(UUID userId);
    Optional<CommercialPaperProgram> findByTrackingCode(String code);
    List<CommercialPaperProgram> findByStateFlag(String stateFlag);
}
