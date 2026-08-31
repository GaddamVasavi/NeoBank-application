package com.neobank.treasuryoperations;
import com.neobank.common.ApiResponse;
import lombok.RequiredArgsConstructor; import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List; import java.util.UUID;
@RestController @RequestMapping("/api/v1/treasuryoperations/modules/centralbankauctiontender") @RequiredArgsConstructor
public class CentralBankAuctionTenderController {
    private final CentralBankAuctionTenderService service;
    @GetMapping public ResponseEntity<ApiResponse<List<CentralBankAuctionTenderDto>>> listAll() { return ResponseEntity.ok(ApiResponse.success(service.listAll())); }
    @GetMapping("/user/{userId}") public ResponseEntity<ApiResponse<List<CentralBankAuctionTenderDto>>> getByUser(@PathVariable UUID userId) { return ResponseEntity.ok(ApiResponse.success(service.getByUser(userId))); }
    @PostMapping public ResponseEntity<ApiResponse<CentralBankAuctionTenderDto>> create(@RequestBody CentralBankAuctionTenderDto dto) { return ResponseEntity.ok(ApiResponse.success(service.create(dto), "Created")); }
    @GetMapping("/id/{id}") public ResponseEntity<ApiResponse<CentralBankAuctionTenderDto>> getByIdentifier(@PathVariable String id) { return ResponseEntity.ok(ApiResponse.success(service.getByIdentifier(id))); }
    @PatchMapping("/{id}/status") public ResponseEntity<ApiResponse<Void>> updateStatus(@PathVariable UUID id, @RequestParam String status) { service.updateStatus(id, status); return ResponseEntity.ok(ApiResponse.success(null, "Updated")); }
}
