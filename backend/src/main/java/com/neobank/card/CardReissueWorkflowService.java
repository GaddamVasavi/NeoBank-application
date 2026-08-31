package com.neobank.card;
import java.util.List; import java.util.UUID;
public interface CardReissueWorkflowService {
    List<CardReissueWorkflowDto> getByUser(UUID userId);
    CardReissueWorkflowDto create(CardReissueWorkflowDto dto);
    CardReissueWorkflowDto getByKey(String key);
    void updateStatus(UUID id, String status);
    List<CardReissueWorkflowDto> listAll();
}
