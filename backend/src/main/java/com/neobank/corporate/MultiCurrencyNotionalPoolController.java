package com.neobank.corporate;
import com.neobank.common.ApiResponse;
import lombok.RequiredArgsConstructor; import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List; import java.util.UUID;
@RestController @RequestMapping("/api/v1/corporate/modules/multicurrencynotionalpool") @RequiredArgsConstructor
public class MultiCurrencyNotionalPoolController {
    private final MultiCurrencyNotionalPoolService service;
    @GetMapping public ResponseEntity<ApiResponse<List<MultiCurrencyNotionalPoolDto>>> listAll() { return ResponseEntity.ok(ApiResponse.success(service.listAll())); }
    @GetMapping("/user/{userId}") public ResponseEntity<ApiResponse<List<MultiCurrencyNotionalPoolDto>>> getByUser(@PathVariable UUID userId) { return ResponseEntity.ok(ApiResponse.success(service.getByUser(userId))); }
    @PostMapping public ResponseEntity<ApiResponse<MultiCurrencyNotionalPoolDto>> create(@RequestBody MultiCurrencyNotionalPoolDto dto) { return ResponseEntity.ok(ApiResponse.success(service.create(dto), "Created")); }
    @GetMapping("/code/{code}") public ResponseEntity<ApiResponse<MultiCurrencyNotionalPoolDto>> getByCode(@PathVariable String code) { return ResponseEntity.ok(ApiResponse.success(service.getByCode(code))); }
    @PatchMapping("/{id}/state") public ResponseEntity<ApiResponse<Void>> updateState(@PathVariable UUID id, @RequestParam String state) { service.updateState(id, state); return ResponseEntity.ok(ApiResponse.success(null, "Updated")); }
}
