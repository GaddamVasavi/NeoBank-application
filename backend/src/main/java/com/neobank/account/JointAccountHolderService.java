package com.neobank.account;
import java.util.List; import java.util.UUID;
public interface JointAccountHolderService {
    List<JointAccountHolderDto> getByAccount(UUID accountId);
    JointAccountHolderDto create(JointAccountHolderDto dto);
    JointAccountHolderDto getByRef(String ref);
    void updateStatus(UUID id, String status);
}
