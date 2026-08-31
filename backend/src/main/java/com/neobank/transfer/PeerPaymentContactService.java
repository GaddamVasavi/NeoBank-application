package com.neobank.transfer;
import java.util.List; import java.util.UUID;
public interface PeerPaymentContactService {
    List<PeerPaymentContactDto> getByAccount(UUID accountId);
    PeerPaymentContactDto create(PeerPaymentContactDto dto);
    PeerPaymentContactDto getByTrackingNumber(String trackingNumber);
    void process(UUID id);
}
