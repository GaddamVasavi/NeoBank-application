package com.neobank.admin;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface UserRoleHierarchyRepository extends JpaRepository<UserRoleHierarchy, UUID> {
    List<UserRoleHierarchy> findByUserId(UUID userId);
    Optional<UserRoleHierarchy> findByRecordKey(String recordKey);
    List<UserRoleHierarchy> findByStatus(String status);
}
