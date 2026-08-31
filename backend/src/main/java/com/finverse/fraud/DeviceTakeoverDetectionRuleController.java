package com.finverse.fraud;

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
 * REST API Controller for DeviceTakeoverDetectionRule
 */
@Tag(name = "Fraud - DeviceTakeoverDetectionRule")
@RestController
@RequestMapping("/api/v1/fraud/modules/devicetakeoverdetectionrule")
@RequiredArgsConstructor
public class DeviceTakeoverDetectionRuleController {
    private final DeviceTakeoverDetectionRuleService service;

    @Operation(summary = "List all entities")
    @GetMapping
    public ResponseEntity<ApiResponse<List<DeviceTakeoverDetectionRuleDto>>> listAll() {
        return ResponseEntity.ok(ApiResponse.success(service.listAll()));
    }

    @Operation(summary = "List by tenant ID")
    @GetMapping("/tenant/{tenantId}")
    public ResponseEntity<ApiResponse<List<DeviceTakeoverDetectionRuleDto>>> getByTenant(@PathVariable UUID tenantId) {
        return ResponseEntity.ok(ApiResponse.success(service.getByTenant(tenantId)));
    }

    @Operation(summary = "List by user ID")
    @GetMapping("/user/{userId}")
    public ResponseEntity<ApiResponse<List<DeviceTakeoverDetectionRuleDto>>> getByUser(@PathVariable UUID userId) {
        return ResponseEntity.ok(ApiResponse.success(service.getByUser(userId)));
    }

    @Operation(summary = "Create entity")
    @PostMapping
    public ResponseEntity<ApiResponse<DeviceTakeoverDetectionRuleDto>> create(@Valid @RequestBody DeviceTakeoverDetectionRuleDto dto) {
        return ResponseEntity.ok(ApiResponse.success(service.create(dto), "Created successfully"));
    }

    @Operation(summary = "Lookup by reference")
    @GetMapping("/ref/{ref}")
    public ResponseEntity<ApiResponse<DeviceTakeoverDetectionRuleDto>> getByRef(@PathVariable String ref) {
        return ResponseEntity.ok(ApiResponse.success(service.getByReference(ref)));
    }

    @Operation(summary = "Update status")
    @PatchMapping("/{id}/status")
    public ResponseEntity<ApiResponse<Void>> updateStatus(@PathVariable UUID id, @RequestParam String status) {
        service.updateStatus(id, status);
        return ResponseEntity.ok(ApiResponse.success(null, "Updated"));
    }
}
