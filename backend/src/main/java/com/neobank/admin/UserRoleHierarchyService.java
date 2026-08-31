package com.neobank.admin;
import java.util.List; import java.util.UUID;
public interface UserRoleHierarchyService {
    List<UserRoleHierarchyDto> getByUser(UUID userId);
    UserRoleHierarchyDto create(UserRoleHierarchyDto dto);
    UserRoleHierarchyDto getByKey(String key);
    void updateStatus(UUID id, String status);
    List<UserRoleHierarchyDto> listAll();
}
