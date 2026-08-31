package com.neobank.syndicatedloans;
import com.neobank.common.ApiResponse;
import lombok.RequiredArgsConstructor; import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List; import java.util.UUID;
@RestController @RequestMapping("/api/v1/syndicatedloans/modules/syndicatedrepaymentwaterfall") @RequiredArgsConstructor
public class SyndicatedRepaymentWaterfallController {
    private final SyndicatedRepaymentWaterfallService service;
    @GetMapping public ResponseEntity<ApiResponse<List<SyndicatedRepaymentWaterfallDto>>> listAll() { return ResponseEntity.ok(ApiResponse.success(service.listAll())); }
    @GetMapping("/user/{userId}") public ResponseEntity<ApiResponse<List<SyndicatedRepaymentWaterfallDto>>> getByUser(@PathVariable UUID userId) { return ResponseEntity.ok(ApiResponse.success(service.getByUser(userId))); }
    @PostMapping public ResponseEntity<ApiResponse<SyndicatedRepaymentWaterfallDto>> create(@RequestBody SyndicatedRepaymentWaterfallDto dto) { return ResponseEntity.ok(ApiResponse.success(service.create(dto), "Created")); }
    @GetMapping("/ref/{ref}") public ResponseEntity<ApiResponse<SyndicatedRepaymentWaterfallDto>> getByRef(@PathVariable String ref) { return ResponseEntity.ok(ApiResponse.success(service.getByRef(ref))); }
    @PatchMapping("/{id}/state") public ResponseEntity<ApiResponse<Void>> updateState(@PathVariable UUID id, @RequestParam String state) { service.updateState(id, state); return ResponseEntity.ok(ApiResponse.success(null, "Updated")); }
}
