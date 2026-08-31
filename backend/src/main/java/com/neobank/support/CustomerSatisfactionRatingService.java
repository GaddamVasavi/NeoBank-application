package com.neobank.support;
import java.util.List; import java.util.UUID;
public interface CustomerSatisfactionRatingService {
    List<CustomerSatisfactionRatingDto> getByUser(UUID userId);
    CustomerSatisfactionRatingDto create(CustomerSatisfactionRatingDto dto);
    CustomerSatisfactionRatingDto getByKey(String key);
    void updateStatus(UUID id, String status);
    List<CustomerSatisfactionRatingDto> listAll();
}
