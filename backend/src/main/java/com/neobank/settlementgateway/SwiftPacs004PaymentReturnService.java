package com.neobank.settlementgateway;
import java.util.List; import java.util.UUID;
public interface SwiftPacs004PaymentReturnService {
    List<SwiftPacs004PaymentReturnDto> getByUser(UUID userId);
    SwiftPacs004PaymentReturnDto create(SwiftPacs004PaymentReturnDto dto);
    SwiftPacs004PaymentReturnDto getByRef(String ref);
    void updateState(UUID id, String state);
    List<SwiftPacs004PaymentReturnDto> listAll();
}
