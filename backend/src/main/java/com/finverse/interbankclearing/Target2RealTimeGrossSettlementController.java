package com.finverse.interbankclearing;

import com.finverse.common.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

/**
 * REST API Controller for Target2RealTimeGrossSettlement
 */
@Tag(name = "Interbankclearing - Target2RealTimeGrossSettlement")
@RestController
@RequestMapping("/api/v1/interbankclearing/modules/target2realtimegrosssettlement")
@RequiredArgsConstructor
public class Target2RealTimeGrossSettlementController {
    private final Target2RealTimeGrossSettlementService service;

    @Operation(summary = "List all entities")
    @GetMapping
    public ResponseEntity<ApiResponse<List<Target2RealTimeGrossSettlementDto>>> listAll() {
        return ResponseEntity.ok(ApiResponse.success(service.listAll()));
    }

    @Operation(summary = "List by tenant ID")
    @GetMapping("/tenant/{tenantId}")
    public ResponseEntity<ApiResponse<List<Target2RealTimeGrossSettlementDto>>> getByTenant(@PathVariable UUID tenantId) {
        return ResponseEntity.ok(ApiResponse.success(service.getByTenant(tenantId)));
    }

    @Operation(summary = "List by user ID")
    @GetMapping("/user/{userId}")
    public ResponseEntity<ApiResponse<List<Target2RealTimeGrossSettlementDto>>> getByUser(@PathVariable UUID userId) {
        return ResponseEntity.ok(ApiResponse.success(service.getByUser(userId)));
    }

    @Operation(summary = "Create entity")
    @PostMapping
    public ResponseEntity<ApiResponse<Target2RealTimeGrossSettlementDto>> create(@Valid @RequestBody Target2RealTimeGrossSettlementDto dto) {
        return ResponseEntity.ok(ApiResponse.success(service.create(dto), "Created successfully"));
    }

    @Operation(summary = "Lookup by reference")
    @GetMapping("/ref/{ref}")
    public ResponseEntity<ApiResponse<Target2RealTimeGrossSettlementDto>> getByRef(@PathVariable String ref) {
        return ResponseEntity.ok(ApiResponse.success(service.getByReference(ref)));
    }

    @Operation(summary = "Update status")
    @PatchMapping("/{id}/status")
    public ResponseEntity<ApiResponse<Void>> updateStatus(@PathVariable UUID id, @RequestParam String status) {
        service.updateStatus(id, status);
        return ResponseEntity.ok(ApiResponse.success(null, "Updated"));
    }
}
