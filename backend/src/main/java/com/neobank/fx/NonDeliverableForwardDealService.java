package com.neobank.fx;
import java.util.List; import java.util.UUID;
public interface NonDeliverableForwardDealService {
    List<NonDeliverableForwardDealDto> getByUser(UUID userId);
    NonDeliverableForwardDealDto create(NonDeliverableForwardDealDto dto);
    NonDeliverableForwardDealDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<NonDeliverableForwardDealDto> listAll();
}
