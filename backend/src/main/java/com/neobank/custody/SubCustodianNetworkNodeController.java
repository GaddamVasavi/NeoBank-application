package com.neobank.custody;
import com.neobank.common.ApiResponse;
import lombok.RequiredArgsConstructor; import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List; import java.util.UUID;
@RestController @RequestMapping("/api/v1/custody/modules/subcustodiannetworknode") @RequiredArgsConstructor
public class SubCustodianNetworkNodeController {
    private final SubCustodianNetworkNodeService service;
    @GetMapping public ResponseEntity<ApiResponse<List<SubCustodianNetworkNodeDto>>> listAll() { return ResponseEntity.ok(ApiResponse.success(service.listAll())); }
    @GetMapping("/user/{userId}") public ResponseEntity<ApiResponse<List<SubCustodianNetworkNodeDto>>> getByUser(@PathVariable UUID userId) { return ResponseEntity.ok(ApiResponse.success(service.getByUser(userId))); }
    @PostMapping public ResponseEntity<ApiResponse<SubCustodianNetworkNodeDto>> create(@RequestBody SubCustodianNetworkNodeDto dto) { return ResponseEntity.ok(ApiResponse.success(service.create(dto), "Created")); }
    @GetMapping("/ref/{ref}") public ResponseEntity<ApiResponse<SubCustodianNetworkNodeDto>> getByRef(@PathVariable String ref) { return ResponseEntity.ok(ApiResponse.success(service.getByRef(ref))); }
    @PatchMapping("/{id}/status") public ResponseEntity<ApiResponse<Void>> updateStatus(@PathVariable UUID id, @RequestParam String status) { service.updateStatus(id, status); return ResponseEntity.ok(ApiResponse.success(null, "Updated")); }
}
