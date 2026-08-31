package com.neobank.transfer;
import com.neobank.common.ApiResponse;
import lombok.RequiredArgsConstructor; import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List; import java.util.UUID;
@RestController @RequestMapping("/api/v1/transfers/modules/currencyhedgingcontract") @RequiredArgsConstructor
public class CurrencyHedgingContractController {
    private final CurrencyHedgingContractService service;
    @GetMapping("/account/{accountId}") public ResponseEntity<ApiResponse<List<CurrencyHedgingContractDto>>> getByAccount(@PathVariable UUID accountId) { return ResponseEntity.ok(ApiResponse.success(service.getByAccount(accountId))); }
    @PostMapping public ResponseEntity<ApiResponse<CurrencyHedgingContractDto>> create(@RequestBody CurrencyHedgingContractDto dto) { return ResponseEntity.ok(ApiResponse.success(service.create(dto), "Created")); }
    @GetMapping("/track/{trackingNumber}") public ResponseEntity<ApiResponse<CurrencyHedgingContractDto>> getByTrack(@PathVariable String trackingNumber) { return ResponseEntity.ok(ApiResponse.success(service.getByTrackingNumber(trackingNumber))); }
    @PostMapping("/{id}/process") public ResponseEntity<ApiResponse<Void>> process(@PathVariable UUID id) { service.process(id); return ResponseEntity.ok(ApiResponse.success(null, "Processed")); }
}
