package com.neobank.notificationservice;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface TemplateVariableSubstitutionRepository extends JpaRepository<TemplateVariableSubstitution, UUID> {
    List<TemplateVariableSubstitution> findByUserId(UUID userId);
    Optional<TemplateVariableSubstitution> findByRegistryKey(String key);
    List<TemplateVariableSubstitution> findByDeliveryStatus(String status);
}
