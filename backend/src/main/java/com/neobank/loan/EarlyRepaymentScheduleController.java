package com.neobank.loan;
import com.neobank.common.ApiResponse;
import lombok.RequiredArgsConstructor; import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List; import java.util.UUID;
@RestController @RequestMapping("/api/v1/loan/modules/earlyrepaymentschedule") @RequiredArgsConstructor
public class EarlyRepaymentScheduleController {
    private final EarlyRepaymentScheduleService service;
    @GetMapping("/user/{userId}") public ResponseEntity<ApiResponse<List<EarlyRepaymentScheduleDto>>> getByUser(@PathVariable UUID userId) { return ResponseEntity.ok(ApiResponse.success(service.getByUser(userId))); }
    @PostMapping public ResponseEntity<ApiResponse<EarlyRepaymentScheduleDto>> create(@RequestBody EarlyRepaymentScheduleDto dto) { return ResponseEntity.ok(ApiResponse.success(service.create(dto), "Created")); }
    @GetMapping("/ref/{ref}") public ResponseEntity<ApiResponse<EarlyRepaymentScheduleDto>> getByRef(@PathVariable String ref) { return ResponseEntity.ok(ApiResponse.success(service.getByRef(ref))); }
    @PatchMapping("/{id}/status") public ResponseEntity<ApiResponse<Void>> updateStatus(@PathVariable UUID id, @RequestParam String status) { service.updateStatus(id, status); return ResponseEntity.ok(ApiResponse.success(null, "Status updated")); }
}
