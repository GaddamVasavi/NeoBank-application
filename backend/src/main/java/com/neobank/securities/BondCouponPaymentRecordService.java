package com.neobank.securities;
import java.util.List; import java.util.UUID;
public interface BondCouponPaymentRecordService {
    List<BondCouponPaymentRecordDto> getByUser(UUID userId);
    BondCouponPaymentRecordDto create(BondCouponPaymentRecordDto dto);
    BondCouponPaymentRecordDto getByIdentifier(String id);
    void updateState(UUID id, String state);
    List<BondCouponPaymentRecordDto> listAll();
}
