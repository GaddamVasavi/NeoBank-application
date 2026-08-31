package com.neobank.coreledger;
import com.neobank.common.ApiResponse;
import lombok.RequiredArgsConstructor; import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List; import java.util.UUID;
@RestController @RequestMapping("/api/v1/coreledger/modules/statutorybalancesheetsnapshot") @RequiredArgsConstructor
public class StatutoryBalanceSheetSnapshotController {
    private final StatutoryBalanceSheetSnapshotService service;
    @GetMapping public ResponseEntity<ApiResponse<List<StatutoryBalanceSheetSnapshotDto>>> listAll() { return ResponseEntity.ok(ApiResponse.success(service.listAll())); }
    @GetMapping("/user/{userId}") public ResponseEntity<ApiResponse<List<StatutoryBalanceSheetSnapshotDto>>> getByUser(@PathVariable UUID userId) { return ResponseEntity.ok(ApiResponse.success(service.getByUser(userId))); }
    @PostMapping public ResponseEntity<ApiResponse<StatutoryBalanceSheetSnapshotDto>> create(@RequestBody StatutoryBalanceSheetSnapshotDto dto) { return ResponseEntity.ok(ApiResponse.success(service.create(dto), "Created")); }
    @GetMapping("/ref/{ref}") public ResponseEntity<ApiResponse<StatutoryBalanceSheetSnapshotDto>> getByRef(@PathVariable String ref) { return ResponseEntity.ok(ApiResponse.success(service.getByRef(ref))); }
    @PatchMapping("/{id}/status") public ResponseEntity<ApiResponse<Void>> updateStatus(@PathVariable UUID id, @RequestParam String status) { service.updateStatus(id, status); return ResponseEntity.ok(ApiResponse.success(null, "Updated")); }
}
